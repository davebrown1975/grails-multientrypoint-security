package com.tucanoo.mep.montagues

import grails.plugin.springsecurity.annotation.Secured

class MontaguesController {

    @Secured(['IS_AUTHENTICATED_FULLY'])
    def index() {
      println "montagues index"
    }

    @Secured(['permitAll'])
    def auth() {
      println "montagues auth"
    }
}
