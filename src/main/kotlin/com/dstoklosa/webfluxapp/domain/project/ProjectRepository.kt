package com.dstoklosa.webfluxapp.domain.project

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface ProjectRepository {

    fun save(project: Project): Mono<Project>

    fun findAll(): Flux<Project>
}