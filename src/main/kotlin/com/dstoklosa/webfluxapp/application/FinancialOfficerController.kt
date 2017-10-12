package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.team.FinancialOfficer
import com.dstoklosa.webfluxapp.domain.team.FinancialOfficerRepository
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/")
class FinancialOfficerController(
    private val financialOfficerRepository: FinancialOfficerRepository
) {

    @PostMapping("/financial-officers")
    fun addFinancialOfficer(
        @RequestBody
        @Valid
        @NotNull
        officer: FinancialOfficer
    ) = financialOfficerRepository.save(officer)


    @GetMapping("/financial-officers")
    fun getFinancialOfficers() = financialOfficerRepository.findAll()
}


