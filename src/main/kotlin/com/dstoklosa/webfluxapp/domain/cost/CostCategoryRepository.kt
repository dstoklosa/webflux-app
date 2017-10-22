package com.dstoklosa.webfluxapp.domain.cost

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface CostCategoryRepository {

    fun save(cost: CostCategory): Mono<CostCategory>

    fun findAll(): Flux<CostCategory>
}