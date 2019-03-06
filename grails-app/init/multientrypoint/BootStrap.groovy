package multientrypoint

import com.tucanoo.mep.CapuletUser
import com.tucanoo.mep.MontagueUser
import com.tucanoo.mep.Role

class BootStrap {
  
    def init = { servletContext ->

      // Establish single role
      if (! Role.count() )
        new Role(authority: 'ROLE_USER').save()

      // create a capulet user
      if (CapuletUser.count()) {
        CapuletUser capuletUser = new CapuletUser()
        capuletUser.username = 'capulet'
        capuletUser.password = 'password'
        capuletUser.enabled = true
        capuletUser.save(failOnError:true)
      }

      // create a single montague user
      if (MontagueUser.count()) {
        MontagueUser montagueUser= new MontagueUser()
        montagueUser.username = 'montague'
        montagueUser.password = 'password'
        montagueUser.enabled = true
        montagueUser.save(failOnError:true)
      }

    }
    def destroy = {
    }
}
