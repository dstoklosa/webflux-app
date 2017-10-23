package com.dstoklosa.webfluxapp.domain.project

import com.dstoklosa.webfluxapp.domain.team.FinancialOfficer
import com.dstoklosa.webfluxapp.domain.team.ProjectLead
import java.util.UUID

data class Project(
    val id: UUID,
    val program: String,
    val acronym: String,
    val title: String,
    val projectStaff: ProjectStaff
)

data class ProjectStaff(
    val financialOfficer: FinancialOfficer,
    val projectLead: ProjectLead
)
