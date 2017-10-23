package com.dstoklosa.webfluxapp.helper

import com.dstoklosa.webfluxapp.domain.project.Project
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic

@Builder(builderStrategy = SimpleStrategy, prefix = "with")
class ProjectBuilder {

    UUID id = UUID.randomUUID()
    String program = randomAlphabetic(10)
    String acronym = randomAlphabetic(10)
    String title = randomAlphabetic(10)

    def build() {
        new Project(id, program, acronym, title)
    }
}
