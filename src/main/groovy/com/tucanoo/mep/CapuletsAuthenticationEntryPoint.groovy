package com.tucanoo.mep

import grails.plugin.springsecurity.web.authentication.AjaxAwareAuthenticationEntryPoint

class CapuletsAuthenticationEntryPoint  extends AjaxAwareAuthenticationEntryPoint {


  /**
   * @param loginFormUrl URL where the login page can be found. Should either be relative to the web-app context path
   * (include a leading {@code /}) or an absolute URL.
   */
  CapuletsAuthenticationEntryPoint(String loginFormUrl) {
    super(loginFormUrl)
    println "Passed in $loginFormUrl"
  }

//  @Override
//    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
//        if (deviceResolver.resolveDevice(request).isMobile())
//        {
//             return mobileLoginFormUrl
//        }
//        return super.determineUrlToUseForThisRequest(request, response, e)
//    }
}