package com.dstoklosa.webfluxapp.infrastructure.mongo

import com.dstoklosa.webfluxapp.domain.team.ProjectPartner
import com.dstoklosa.webfluxapp.domain.team.ProjectPartnerRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProjectPartnerMongo : ProjectPartnerRepository, ReactiveCrudRepository<ProjectPartner, UUID> {
}