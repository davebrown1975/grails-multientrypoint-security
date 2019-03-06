package com.tucanoo.mep.montagues

import grails.plugin.springsecurity.annotation.Secured

class MontaguesController {

    def index() { }

    @Secured(['permitAll'])
    def auth() {}
}
