package com.tucanoo.mep

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.userdetails.GrailsUser
import groovy.util.logging.Slf4j
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

@Slf4j
class CapuletsAuthenticationProvider extends DaoAuthenticationProvider {

  def springSecurityService, sessionRegistry, licenseService
  //Logger log = Logger.getLogger(getClass())

  @Override
  @Transactional
  Authentication authenticate(Authentication customAuth) {
    if (log.isDebugEnabled()) log.debug '{}', "Authenticating Capulet"

    CapuletUser user = CapuletUser.findByUsername(customAuth.principal)
    if (user) {
      if (user?.password == springSecurityService.encodePassword(customAuth.credentials)) {

        Collection<GrantedAuthority> authorities = user.authorities.collect {
          new SimpleGrantedAuthority(it.authority)
        };

        def userDetails = new GrailsUser(user.username, user.password, true, true, true, true, authorities, user.id);

        def token = new UsernamePasswordAuthenticationToken(userDetails, user.password, userDetails.authorities);
        token.details = customAuth.details;
        return token

      } else
        throw new BadCredentialsException("Log in failed - identity could not be verified");

    } else
      return null

  }

  @Override
  boolean supports(Class<? extends Object> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
