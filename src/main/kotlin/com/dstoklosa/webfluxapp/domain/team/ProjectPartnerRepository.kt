package com.dstoklosa.webfluxapp.domain.team

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface ProjectPartnerRepository {

    fun save(projectPartner: ProjectPartner): Mono<ProjectPartner>

    fun findAll(): Flux<ProjectPartner>
}