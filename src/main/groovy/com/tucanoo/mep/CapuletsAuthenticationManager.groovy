package com.tucanoo.mep

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.ProviderManager

class CapuletsAuthenticationManager extends ProviderManager {
  CapuletsAuthenticationManager(List<AuthenticationProvider> providers) {
    super(providers)
    println "LISTING PROVIDERS 1"
    println providers
  }

  CapuletsAuthenticationManager(List<AuthenticationProvider> providers, AuthenticationManager parent) {
    super(providers, parent)
    println "LISTING PROVIDERS 2"
    println providers
  }
}
