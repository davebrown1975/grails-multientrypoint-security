package com.tucanoo.mep.capulets

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class CapuletsController {

    def index() { }

    @Secured(['permitAll'])
    def auth() {}
}
