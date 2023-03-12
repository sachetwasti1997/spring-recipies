package com.sachet.springrecipies.controllers

import com.sachet.springrecipies.shared.GenericResponse
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity

class RecipeControllerTest{

    private lateinit var recipeController: com.sachet.springrecipies.controllers.RecipeController
    private val recipeService: com.sachet.springrecipies.service.RecipeService = Mockito.mock(com.sachet.springrecipies.service.RecipeService::class.java)

    @BeforeEach
    fun setUp() {
        recipeController = com.sachet.springrecipies.controllers.RecipeController(recipeService)
    }
    @Test
    fun getAll() {
        val recipes = HashSet<com.sachet.springrecipies.domain.Recipe>()
        recipes.add(com.sachet.springrecipies.domain.Recipe())
        Mockito.`when`(recipeService.findAll()).thenReturn(recipes)
        val res = recipeController.getAll()
        assertNotNull(res)
        assertEquals(HttpStatus.OK, res.statusCode)
        assertEquals(1, res.body?.size)
        Mockito.verify(recipeService, Mockito.times(1)).findAll()
    }

    @Test
    fun getById() {
        val recipe = com.sachet.springrecipies.domain.Recipe().apply {
            id = 1L
        }
        Mockito.`when`(recipeService.getRecipeById(1L)).thenReturn(recipe)
        val result = recipeController.getRecipeById(1L)
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
        verify(recipeService, times(1)).getRecipeById(1L)
    }


}