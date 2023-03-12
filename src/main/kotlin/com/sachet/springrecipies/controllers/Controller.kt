package com.sachet.springrecipies.controllers

import com.sachet.springrecipies.domain.Category
import com.sachet.springrecipies.repository.CategoryRepository
import com.sachet.springrecipies.repository.UnitOfMeasureRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/cont")
class Controller(
    val categoryRepository: com.sachet.springrecipies.repository.CategoryRepository,
    val unitOfMeasureRepository: com.sachet.springrecipies.repository.UnitOfMeasureRepository
) {
    @GetMapping("/category")
    fun getCategories(): MutableIterable<com.sachet.springrecipies.domain.Category> {
        return categoryRepository.findAll();
    }
}