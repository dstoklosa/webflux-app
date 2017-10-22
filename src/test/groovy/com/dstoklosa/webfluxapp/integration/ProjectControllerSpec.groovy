package com.dstoklosa.webfluxapp.integration

import com.dstoklosa.webfluxapp.domain.project.Project
import reactor.core.publisher.Mono
import spock.lang.Ignore

import static java.util.UUID.randomUUID

class ProjectControllerSpec extends AbstractIntegrationSpec {


    def "should create a project"() {
        given:
        def project = new Project(randomUUID())

        when:
        def result = createProject(project)

        then:
        result.expectStatus().is2xxSuccessful()
    }

    @Ignore
    def "should return list of project leads"() {
        given:
        def project1  = new Project(randomUUID())
        def project2  = new Project(randomUUID())
        createProject(project1)
        createProject(project2)

        when:
        def result = webTestClient
                .get()
                .uri("/projects")
                .exchange()
        then:
        result.expectStatus()
                .is2xxSuccessful()
                .expectBodyList(Project)
                .contains(project1, project2)
    }


    private createProject(def project) {
        return this.webTestClient
                .post()
                .uri("/projects")
                .body(Mono.just(project), Project)
                .exchange()
    }

}
