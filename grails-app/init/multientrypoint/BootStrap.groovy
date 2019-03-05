package multientrypoint

import com.tucanoo.mep.Role

class BootStrap {
  
    def init = { servletContext ->
      if (! Role.count() )
        new Role(authority: 'ROLE_USER').save()


    }
    def destroy = {
    }
}
