package com.example.springrecipies.controllers

import com.example.springrecipies.domain.Recipe
import com.example.springrecipies.service.RecipeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/recipe")
class RecipeController(
    val recipeService: RecipeService
) {

    @GetMapping("/all")
    fun getAll() = ResponseEntity(recipeService.findAll(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getRecipeById(@PathVariable id: Long): ResponseEntity<Any> = ResponseEntity.ok(recipeService.getRecipeById(id))

}