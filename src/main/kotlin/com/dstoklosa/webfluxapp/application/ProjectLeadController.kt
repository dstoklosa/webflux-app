package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.team.ProjectLead
import com.dstoklosa.webfluxapp.domain.team.ProjectLeadRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ProjectLeadController(
    private val leadRepository: ProjectLeadRepository
) {

    @PostMapping("/project-leads")
    fun addProjectLead(@RequestBody projectLead: ProjectLead) = leadRepository.save(projectLead)

    @GetMapping("/project-leads")
    fun getProjectLeads() = leadRepository.findAll()
}