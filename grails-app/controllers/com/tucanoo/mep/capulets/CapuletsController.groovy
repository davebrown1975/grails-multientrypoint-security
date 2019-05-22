package com.tucanoo.mep.capulets

import grails.plugin.springsecurity.annotation.Secured

class CapuletsController {

    @Secured(['IS_AUTHENTICATED_FULLY'])
    def index() {
      println "capulets index"
    }

    @Secured(['permitAll'])
    def auth() {
      println "capulets auth"
    }
}
