package com.dstoklosa.webfluxapp.integration

import com.dstoklosa.webfluxapp.domain.project.Project
import com.dstoklosa.webfluxapp.helper.ProjectBuilder
import reactor.core.publisher.Mono
import spock.lang.Ignore

class ProjectControllerSpec extends AbstractIntegrationSpec {


    def "should create a project with basic data"() {
        given:
        def project = givenProject()

        when:
        def result = createProject(project)

        then:
        result.expectStatus().is2xxSuccessful()
        result.expectBodyList(Project).contains(project)
    }

    @Ignore
    def "should return list of project leads"() {
        given:
        def project1  = givenProject()
        def project2  = givenProject()
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


    private Project givenProject() {
        ProjectBuilder.newInstance().build()
    }

}
