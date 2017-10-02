package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.FinancialOfficer
import spock.lang.Specification

class ProjectTeamControllerSpec extends Specification {

    def "should create a new financial officer"() {
        given:
        def officer = new FinancialOfficer(UUID.randomUUID())

        expect:
        false

    }

}
