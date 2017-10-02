package com.dstoklosa.webfluxapp.domain

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FinancialOfficerRepository : ReactiveCrudRepository<FinancialOfficer, UUID>