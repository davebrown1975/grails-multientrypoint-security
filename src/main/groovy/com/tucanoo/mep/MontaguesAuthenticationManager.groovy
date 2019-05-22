package com.tucanoo.mep

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.ProviderManager

class MontaguesAuthenticationManager extends ProviderManager {
  MontaguesAuthenticationManager(List<AuthenticationProvider> providers) {
    super(providers)
    println "LISTING MONTAGUE PROVIDERS 1"
    println providers
  }

  MontaguesAuthenticationManager(List<AuthenticationProvider> providers, AuthenticationManager parent) {
    super(providers, parent)
    println "LISTING MONTAGUE PROVIDERS 2"
    println providers
  }
}
