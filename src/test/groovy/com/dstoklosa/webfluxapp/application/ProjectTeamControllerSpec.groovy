package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.FinancialOfficer
import com.dstoklosa.webfluxapp.domain.FinancialOfficerRepository
import reactor.core.publisher.Mono
import spock.lang.Specification

class ProjectTeamControllerSpec extends Specification {

    def officersRepository = Mock(FinancialOfficerRepository)
    def projectController = new ProjectTeamController(officersRepository)

    def "should create a new financial officer"() {
        given:
        def id =  UUID.randomUUID()
        def officer = new FinancialOfficer(id)
        officersRepository.save(officer) >> Mono.just(officer)

        when:
        def result = projectController.addFinancialOfficer(officer).block()

        then:
        result.id == id
    }

}
