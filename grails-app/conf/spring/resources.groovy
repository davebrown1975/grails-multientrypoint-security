import com.tucanoo.mep.*

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)


    capuletsAuthenticationProvider(CapuletsAuthenticationProvider) {
      userDetailsService = ref('userDetailsService')
    }

    montaguesAuthenticationProvider(MontaguesAuthenticationProvider) {
      userDetailsService = ref('userDetailsService')
    }

    capuletsAuthenticationManager(CapuletsAuthenticationManager) { bean ->
      bean.constructorArgs = [ref('capuletsAuthenticationProvider')]
    }
  
    // establish authentication filter for capulets
    capuletsAuthenticationFilter(CapuletsAuthenticationFilter) {
      authenticationManager = ref('capuletsAuthenticationManager')
//      filterProcessesUrl = '/capulets/index'
    }

    // establish authentication filter for montagues
    montaguesAuthenticationFilter(MontaguesAuthenticationFilter) {
      authenticationManager = ref('authenticationManager')
//      filterProcessesUrl = '/montagues/index'
    }
}

