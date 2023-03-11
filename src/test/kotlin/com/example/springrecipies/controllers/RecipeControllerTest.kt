package com.example.springrecipies.controllers

import com.example.springrecipies.domain.Recipe
import com.example.springrecipies.exception.NotFoundException
import com.example.springrecipies.service.RecipeService
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

    @Test
    fun getById() {
        val recipe = Recipe().apply {
            id = 1L
        }
        Mockito.`when`(recipeService.getRecipeById(1L)).thenReturn(recipe)
        val result = recipeController.getRecipeById(1L)
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
        verify(recipeService, times(1)).getRecipeById(1L)
    }

    @Test
    fun getByIdNotFound() {
        given(recipeService.getRecipeById(1L))
            .willAnswer{NotFoundException("Recipe with Id ${1L} Not Found")}

        val result: ResponseEntity<Any> = recipeController.getRecipeById(1L)
//        assertNotNull(result)
//        assertInstanceOf(NotFoundException::class.java, result.body)
    }
}