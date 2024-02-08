package com.example.TD3.Utils.IP;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class IpFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String ipAddress = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        if (!ipAddress.equals(session.getAttribute("ipAddress")) || !userAgent.equals(session.getAttribute("userAgent"))) {
            session.setAttribute("adresseIP", ipAddress);
            session.setAttribute("userAgent", userAgent);
        }
        try {
            chain.doFilter(request, response);
        } catch (IllegalStateException e) {
            response.sendRedirect("/inscription");
        }
    }
}
