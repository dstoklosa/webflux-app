package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.FinancialOfficer
import com.dstoklosa.webfluxapp.domain.FinancialOfficerRepository
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
@RequestMapping("/")
class ProjectTeamController(
    private val financialOfficerRepository: FinancialOfficerRepository
) {

    @PostMapping("/financial-officers")
    fun addFinancialOfficer(
        @RequestBody
        @Valid
        @NotNull
        officer: FinancialOfficer
    ): Mono<FinancialOfficer>? {
        return financialOfficerRepository.save(officer)
    }

}


