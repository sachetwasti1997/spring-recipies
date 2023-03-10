package com.example.springrecipies.controllers

import com.example.springrecipies.domain.Recipe
import com.example.springrecipies.service.RecipeService
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity

class RecipeControllerTest{

    private lateinit var recipeController: RecipeController
    private val recipeService: RecipeService = Mockito.mock(RecipeService::class.java)

    @BeforeEach
    fun setUp() {
        recipeController = RecipeController(recipeService)
    }
    @Test
    fun getAll() {
        val recipes = HashSet<Recipe>()
        recipes.add(Recipe())
        Mockito.`when`(recipeService.findAll()).thenReturn(recipes)
        val res = recipeController.getAll()
        assertNotNull(res)
        assertEquals(HttpStatus.OK, res.statusCode)
        assertEquals(1, res.body?.size)
        Mockito.verify(recipeService, Mockito.times(1)).findAll()
    }
}