package com.dstoklosa.webfluxapp.infrastructure.mongo

import com.dstoklosa.webfluxapp.domain.team.ProjectLead
import com.dstoklosa.webfluxapp.domain.team.ProjectLeadRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProjectLeadMongo : ProjectLeadRepository, ReactiveCrudRepository<ProjectLead, UUID> {
}