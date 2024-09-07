package com.abc.restaurant.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        if (role.equals("ROLE_ADMIN")) {
            response.sendRedirect("/admin/dashboard");
        } else if (role.equals("ROLE_STAFF")) {
            response.sendRedirect("/staff/dashboard");
        } else if (role.equals("ROLE_USER")) {
            response.sendRedirect("/user/dashboard");
        } else {
            response.sendRedirect("/");
        }
    }
}
