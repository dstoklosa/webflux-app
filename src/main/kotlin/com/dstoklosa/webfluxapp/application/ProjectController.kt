package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.project.Project
import com.dstoklosa.webfluxapp.domain.project.ProjectRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ProjectController(
    private val repository: ProjectRepository
) {

    @PostMapping("/projects")
    fun addProject(@RequestBody project: Project) = repository.save(project)

    @GetMapping("/projects")
    fun getProjects() = repository.findAll()
}