package com.tucanoo.mep.tests

import com.tucanoo.mep.tests.pages.MontagueLoginPage
import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

@Integration
class SecuritySpec extends GebSpec {

    def "test access to montagues home page is secured and shows login page for montagues"() {
      when:
        println "Starting test"
//        baseUrl = "http://localhost:${serverPort}/"
        go '/montagues/index'
      then:       
        at(MontagueLoginPage)
    }

    def "test access to capulets home page is secured  and shows login page for capulets"() {

    }

    def "test montagues can login"() {

    }

    def "test capulets can login"() {

    }

    def "test logged in montagues cannot access capulets homepage"() {

    }

    def "test logged in capulets cannot access montagues homepage"() {

    }

    def "test logged in capulets logout to capulet login page"() {

    }

    def "test logged in montagues logout to montegue login page"() {

    }
     
}
