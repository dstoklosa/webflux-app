package com.dstoklosa.webfluxapp.infrastructure.mongo

import com.dstoklosa.webfluxapp.domain.team.FinancialOfficer
import com.dstoklosa.webfluxapp.domain.team.FinancialOfficerRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FinancialOfficerMongo : FinancialOfficerRepository , ReactiveCrudRepository<FinancialOfficer, UUID>{
}