package com.dstoklosa.webfluxapp.integration

import com.dstoklosa.webfluxapp.domain.team.FinancialOfficer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OfficerControllerSpec extends Specification {

    @Autowired
    WebTestClient webTestClient


    def "should create a new financial officer using test client"() {
        given:
        def officer = new FinancialOfficer(UUID.randomUUID(), "some", "name")

        when:
        def result = createOfficer(officer)

        then:
        result.expectStatus().is2xxSuccessful()
    }

    def "should return list of financial officers"() {
        given:
        def officer1 = new FinancialOfficer(UUID.randomUUID(), "John", "Brown")
        def officer2 = new FinancialOfficer(UUID.randomUUID(), "Mark", "New")
        createOfficer(officer1)
        createOfficer(officer2)

        when:
        def result = webTestClient
                .get()
                .uri("/financial-officers")
                .exchange()
        then:
        result.expectStatus()
                .is2xxSuccessful()
                .expectBodyList(FinancialOfficer)
                .contains(officer1, officer2)
    }


    private createOfficer(def officer) {
        return this.webTestClient
                .post()
                .uri("/financial-officers")
                .body(Mono.just(officer), FinancialOfficer)
                .exchange()
    }

}
