package com.dstoklosa.webfluxapp.helper

import com.dstoklosa.webfluxapp.domain.project.ProjectStaff
import com.dstoklosa.webfluxapp.domain.team.FinancialOfficer
import com.dstoklosa.webfluxapp.domain.team.ProjectLead
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

import static java.util.UUID.randomUUID
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic

@Builder(builderStrategy = SimpleStrategy, prefix = "with")
class ProjectStaffBuilder {

    FinancialOfficer financialOfficer = new FinancialOfficer(
            randomUUID(),
            randomAlphabetic(10),
            randomAlphabetic(10)
    )
    ProjectLead projectLead = new ProjectLead(
            randomUUID(),
            randomAlphabetic(10),
            randomAlphabetic(10)
    )

    def build() {
        new ProjectStaff(financialOfficer, projectLead)
    }
}
