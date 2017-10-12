package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.team.ProjectPartner
import com.dstoklosa.webfluxapp.domain.team.ProjectPartnerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ProjectPartnerController(
    private val repository: ProjectPartnerRepository
) {

    @PostMapping("/project-partners")
    fun addProjectPartner(@RequestBody partner: ProjectPartner) = repository.save(partner)

    @GetMapping("/project-partners")
    fun getProjectPartners() = repository.findAll()
}