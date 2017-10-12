package com.dstoklosa.webfluxapp.domain.team

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface FinancialOfficerRepository {

    fun save(officer: FinancialOfficer): Mono<FinancialOfficer>

    fun findAll(): Flux<FinancialOfficer>
}