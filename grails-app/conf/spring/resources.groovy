import com.tucanoo.mep.*

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)

    montaguesUserDetailsService(MontaguesUserDetailsService)
    capuletsUserDetailsService(CapuletsUserDetailsService)

    capuletsAuthenticationProvider(CapuletsAuthenticationProvider) {
      userDetailsService = ref('capuletsUserDetailsService')
    }

    montaguesAuthenticationProvider(MontaguesAuthenticationProvider) {
      userDetailsService = ref('montaguesUserDetailsService')
    }

    capuletsAuthenticationManager(CapuletsAuthenticationManager) { bean ->
      bean.constructorArgs = [ref('capuletsAuthenticationProvider')]
    }

    montaguesAuthenticationManager(MontaguesAuthenticationManager) { bean ->
      bean.constructorArgs = [ref('montaguesAuthenticationProvider')]
    }

  
    capuletsAuthenticationEntryPoint(CapuletsAuthenticationEntryPoint, "/capulets/auth")

    montaguesAuthenticationEntryPoint(CapuletsAuthenticationEntryPoint, "/montagues/auth")
    
    // establish authentication filter for capulets
    capuletsAuthenticationFilter(CapuletsAuthenticationFilter) {
      authenticationManager = ref('capuletsAuthenticationManager')
      //authenticationEntryPoint = ref('capuletsAuthenticationEntryPoint')
//      filterProcessesUrl = '/capulets/index'
    }

    // establish authentication filter for montagues
    montaguesAuthenticationFilter(MontaguesAuthenticationFilter) {
      authenticationManager = ref('montaguesAuthenticationManager')
      //authenticationEntryPoint = ref('montaguesAuthenticationEntryPoint')
    }
}

