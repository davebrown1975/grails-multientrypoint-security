package com.tucanoo.mep

import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CapuletsAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  CapuletsAuthenticationFilter() {
    super();
  }

  @Override
  void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    super.doFilter(req, res, chain)
    println "IN DO FILTER"
    println requiresAuthentication(req, res)
    // prints false... why when the controller is marked as Secured...?
  }

  @Override
  Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    println "Attempting auth"
    return super.attemptAuthentication(request, response)
  }
}
