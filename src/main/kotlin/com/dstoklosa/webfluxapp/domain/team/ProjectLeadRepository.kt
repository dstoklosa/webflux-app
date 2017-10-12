package com.dstoklosa.webfluxapp.domain.team

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface ProjectLeadRepository {

    fun save(projectLead: ProjectLead): Mono<ProjectLead>

    fun findAll(): Flux<ProjectLead>
}