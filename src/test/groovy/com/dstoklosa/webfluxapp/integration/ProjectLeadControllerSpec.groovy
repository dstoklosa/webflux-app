package com.dstoklosa.webfluxapp.integration

import com.dstoklosa.webfluxapp.domain.team.ProjectLead
import reactor.core.publisher.Mono

import static java.util.UUID.randomUUID

class ProjectLeadControllerSpec extends AbstractIntegrationSpec {


    def "should create a project lead"() {
        given:
        def lead = new ProjectLead(randomUUID(), "some", "name")

        when:
        def result = createLead(lead)

        then:
        result.expectStatus().is2xxSuccessful()
    }

    def "should return list of project leads"() {
        given:
        def lead1 = new ProjectLead(randomUUID(), "John", "Brown")
        def lead2 = new ProjectLead(randomUUID(), "Mark", "New")
        createLead(lead1)
        createLead(lead2)

        when:
        def result = webTestClient
                .get()
                .uri("/project-leads")
                .exchange()
        then:
        result.expectStatus()
                .is2xxSuccessful()
                .expectBodyList(ProjectLead)
                .contains(lead1, lead2)
    }


    private createLead(def lead) {
        return this.webTestClient
                .post()
                .uri("/project-leads")
                .body(Mono.just(lead), ProjectLead)
                .exchange()
    }

}
