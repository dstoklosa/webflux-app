package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.team.FinancialOfficer
import com.dstoklosa.webfluxapp.domain.team.FinancialOfficerRepository
import org.jetbrains.annotations.NotNull
import org.springframework.context.annotation.Configuration
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.config.EnableWebFlux
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import spock.lang.Specification

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic

@Configuration
@EnableWebFlux
class FinancialOfficerControllerSpec extends Specification {

    WebTestClient webTestClient

    def setup() {
        webTestClient = WebTestClient.bindToController(
                new FinancialOfficerController(new OfficerRepositoryStub())).build()
    }

    def officersRepository = Mock(FinancialOfficerRepository)
    def projectController = new FinancialOfficerController(officersRepository)

    def "should create a new financial officer"() {
        given:
        def officer = givenOfficer()
        officersRepository.save(officer) >> Mono.just(officer)

        when:
        def result = projectController.addFinancialOfficer(officer).block()

        then:
        result.id == officer.id
    }

    def "should create a new financial officer using test client"() {
        given:
        def officer = Mono.just(givenOfficer())

        when:
        def result = webTestClient
                .post()
                .uri("/financial-officers")
                .body(officer, FinancialOfficer)
                .exchange()

        then:
        result.expectStatus().is2xxSuccessful()
    }


    private static givenOfficer(def id = UUID.randomUUID(),
                         def firstName = randomAlphabetic(10),
                         def lastName = randomAlphabetic(10)
    ) {
        return new FinancialOfficer(id, firstName, lastName)
    }


    private class OfficerRepositoryStub implements FinancialOfficerRepository {

        private List dataStore = new ArrayList()

        @Override
        Mono<FinancialOfficer> save(@NotNull FinancialOfficer officer) {
            dataStore.add(officer)
            return Mono.just(officer)

        }

        @Override
        Flux<FinancialOfficer> findAll() {
            return Flux.fromIterable(dataStore)
        }
    }

}
