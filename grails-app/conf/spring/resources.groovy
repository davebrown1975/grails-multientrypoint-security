import com.tucanoo.mep.CapuletsAuthenticationFilter
import com.tucanoo.mep.MontaguesAuthenticationFilter
import com.tucanoo.mep.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)

    // establish authentication filter for capulets
    capuletsAuthenticationFilter(CapuletsAuthenticationFilter) {
      authenticationManager = ref('authenticationManager')
      filterProcessesUrl = '/capulets/index'
    }

    // establish authentication filter for montagues
    montaguesAuthenticationFilter(MontaguesAuthenticationFilter) {
      authenticationManager = ref('authenticationManager')
      filterProcessesUrl = '/montagues/index'
    }
}
