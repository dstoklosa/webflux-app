package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.FinancialOfficer
import com.dstoklosa.webfluxapp.domain.FinancialOfficerRepository
import org.springframework.context.annotation.Configuration
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.config.EnableWebFlux
import reactor.core.publisher.Mono
import spock.lang.Specification

@Configuration
@EnableWebFlux
class ProjectTeamControllerSpec extends Specification {

    def webTestClient

    def setup() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()
//        context.register(WebfluxAppApplication.class)
//        context.refresh()
//       webTestClient = WebTestClient.bindToApplicationContext(context).build()


        webTestClient = WebTestClient.bindToController(new ProjectTeamController(new SomeT())).build()

    }

    def officersRepository = Mock(FinancialOfficerRepository)
    def projectController = new ProjectTeamController(officersRepository)

    def "should create a new financial officer"() {
        given:
        def id = UUID.randomUUID()
        def officer = new FinancialOfficer(id)
        officersRepository.save(officer) >> Mono.just(officer)

        when:
        def result = projectController.addFinancialOfficer(officer).block()

        then:
        result.id == id
    }

    def "should create a new financial officer using test client"() {
        given:
        def id = UUID.randomUUID()
        def officer = Mono.just(new FinancialOfficer(id))

        when:
        def result = webTestClient
                .post()
                .uri("/financial-officers")
                .body(officer, FinancialOfficer)
                .exchange()



        then:
        result.expectStatus().is2xxSuccessful()
    }

}
