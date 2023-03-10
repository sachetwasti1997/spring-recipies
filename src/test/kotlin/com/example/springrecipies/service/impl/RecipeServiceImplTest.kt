package com.example.springrecipies.service.impl

import com.example.springrecipies.domain.Recipe
import com.example.springrecipies.repository.RecipeRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mock
import org.mockito.Mockito

class RecipeServiceImplTest{


    @Mock
    val recipeRepository: RecipeRepository  = Mockito.mock(RecipeRepository::class.java)
    private var recipeServiceImpl: RecipeServiceImpl? = null
    @BeforeEach
    fun setUp() {
        recipeServiceImpl = RecipeServiceImpl(recipeRepository)
    }

    @Test
    fun findAll() {
        val recipe1 = Recipe()
        val recipes = HashSet<Recipe>()
        recipes.add(recipe1)
        Mockito.`when`(recipeRepository.findAll()).thenReturn(recipes)
        val result = recipeServiceImpl?.findAll()
        assertNotNull(result)
        assertEquals(1, result?.size)
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll()
    }
}