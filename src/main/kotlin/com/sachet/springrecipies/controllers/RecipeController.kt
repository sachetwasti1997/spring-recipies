package com.sachet.springrecipies.controllers

import com.sachet.springrecipies.domain.Recipe
import com.sachet.springrecipies.service.RecipeService
import com.sachet.springrecipies.shared.GenericResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/recipe")
class RecipeController(
    val recipeService: com.sachet.springrecipies.service.RecipeService
) {

    @GetMapping("/all")
    fun getAll() = ResponseEntity(recipeService.findAll(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getRecipeById(@PathVariable id: Long): ResponseEntity<GenericResponse> = ResponseEntity.
    ok(GenericResponse(recipeService.getRecipeById(id)))

}