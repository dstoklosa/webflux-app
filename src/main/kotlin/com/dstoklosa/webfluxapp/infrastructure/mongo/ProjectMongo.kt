package com.dstoklosa.webfluxapp.infrastructure.mongo

import com.dstoklosa.webfluxapp.domain.project.Project
import com.dstoklosa.webfluxapp.domain.project.ProjectRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProjectMongo : ProjectRepository, ReactiveCrudRepository<Project, UUID>