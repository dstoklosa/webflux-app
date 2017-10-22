package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.cost.CostCategory
import com.dstoklosa.webfluxapp.domain.cost.CostCategoryRepository
import org.springframework.context.annotation.Configuration
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.config.EnableWebFlux
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import spock.lang.Specification

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic

@Configuration
@EnableWebFlux
class CostControllerSpec extends Specification {

    WebTestClient webTestClient

    CostCategoryRepository repository = Stub()

    def setup() {

        repository.save(_ as CostCategory) >> Mono.just(givenCost())
        repository.findAll() >> Flux.just(givenCost(), givenCost())

        webTestClient = WebTestClient.bindToController(
                new CostCategoryController(repository)).build()
    }


    def "should create a new financial officer using test client"() {
        given:
        def cost = Mono.just(givenCost())

        when:
        def result = webTestClient
                .post()
                .uri("/cost-categories")
                .body(cost, CostCategory)
                .exchange()

        then:
        result.expectStatus().is2xxSuccessful()
    }

    def "should get cost category list"() {
        given:

        when:
        def result = webTestClient
                .get()
                .uri('/cost-categories')
                .exchange()

        then:
        result
                .expectBodyList(CostCategory)
                .hasSize(2)
    }


    private static givenCost(def id = UUID.randomUUID(),
                             def name = randomAlphabetic(10)
    ) {
        return new CostCategory(id, name)
    }

}
