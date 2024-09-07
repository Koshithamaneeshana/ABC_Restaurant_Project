package com.abc.restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/staff/**").hasRole("STAFF")
                                .requestMatchers("/user/**").hasRole("USER")
                                .requestMatchers("/", "/login", "/register").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .successHandler(customAuthenticationSuccessHandler())
                )
                .logout(logout ->
                        logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login?logout")
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .accessDeniedPage("/403")
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(
                http.getSharedObject(org.springframework.security.config.annotation.web.builders.AuthenticationManagerBuilder.class)
        );
        authenticationManagerBuilder.userDetailsService(customUserDetailsService());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler(); // Custom handler for success login
    }

    @Bean
    public UserDetailsService customUserDetailsService() {
        return (UserDetailsService) new CustomUserDetailsService(); // Custom service to load user details
    }
}