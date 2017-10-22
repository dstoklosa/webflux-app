package com.dstoklosa.webfluxapp.infrastructure.mongo

import com.dstoklosa.webfluxapp.domain.cost.CostCategory
import com.dstoklosa.webfluxapp.domain.cost.CostCategoryRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CostCategoryMongo : CostCategoryRepository, ReactiveCrudRepository<CostCategory, UUID> {
}