package com.dstoklosa.webfluxapp.integration

import com.dstoklosa.webfluxapp.domain.team.ProjectPartner
import reactor.core.publisher.Mono

import static java.util.UUID.randomUUID

class ProjectPartnerControllerSpec extends AbstractIntegrationSpec {


    def "should create a project partner"() {
        given:
        def partner = new ProjectPartner(randomUUID(), "some name")

        when:
        def result = createPartner(partner)

        then:
        result.expectStatus().is2xxSuccessful()
    }

    def "should return list of project leads"() {
        given:
        def partner1 = new ProjectPartner(randomUUID(), "John")
        def partner2 = new ProjectPartner(randomUUID(), "Mark")
        createPartner(partner1)
        createPartner(partner2)

        when:
        def result = webTestClient
                .get()
                .uri("/project-partners")
                .exchange()
        then:
        result.expectStatus()
                .is2xxSuccessful()
                .expectBodyList(ProjectPartner)
                .contains(partner1, partner2)
    }


    private createPartner(def partner) {
        return this.webTestClient
                .post()
                .uri("/project-partners")
                .body(Mono.just(partner), ProjectPartner)
                .exchange()
    }

}
