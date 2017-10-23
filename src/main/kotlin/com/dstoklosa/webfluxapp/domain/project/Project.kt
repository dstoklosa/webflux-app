package com.dstoklosa.webfluxapp.domain.project

import java.util.UUID

data class Project(
    val id: UUID,
    val program: String,
    val acronym: String,
    val title: String
)