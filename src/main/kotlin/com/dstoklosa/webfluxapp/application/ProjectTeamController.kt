package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.FinancialOfficer
import com.dstoklosa.webfluxapp.domain.FinancialOfficerRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/financial-officers")
class ProjectTeamController(
    private val financialOfficerRepository: FinancialOfficerRepository
) {

    fun addFinancialOfficer(officer: FinancialOfficer): Mono<FinancialOfficer>? {
        return financialOfficerRepository.save(officer)
    }

}


