package com.tucanoo.mep.capulets

import grails.plugin.springsecurity.annotation.Secured

class CapuletsController {

    def index() { }

    @Secured(['permitAll'])
    def auth() {}
}
