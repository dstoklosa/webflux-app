package com.dstoklosa.webfluxapp.application

import com.dstoklosa.webfluxapp.domain.cost.CostCategory
import com.dstoklosa.webfluxapp.domain.cost.CostCategoryRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class CostCategoryController(
    private val repository: CostCategoryRepository
) {

    @PostMapping("/cost-categories")
    fun addCostCategory(@RequestBody category: CostCategory) = repository.save(category)

    @GetMapping("/cost-categories")
    fun getCostCategories() = repository.findAll()
}