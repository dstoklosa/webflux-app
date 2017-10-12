package com.dstoklosa.webfluxapp.domain.team

import java.util.UUID

data class FinancialOfficer(
    val id: UUID,
    val firstName: String,
    val lastName: String
)

data class ProjectLead(
    val id: UUID,
    val firstName: String,
    val lastName: String
)

