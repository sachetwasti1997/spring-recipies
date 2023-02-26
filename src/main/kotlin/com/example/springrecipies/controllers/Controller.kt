package com.example.springrecipies.controllers

import com.example.springrecipies.domain.Category
import com.example.springrecipies.repository.CategoryRepository
import com.example.springrecipies.repository.UnitOfMeasureRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/cont")
class Controller(
    val categoryRepository: CategoryRepository,
    val unitOfMeasureRepository: UnitOfMeasureRepository
) {
    @GetMapping("/category")
    fun getCategories(): MutableIterable<Category> {
        return categoryRepository.findAll();
    }
}