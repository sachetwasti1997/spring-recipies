package com.sachet.springrecipies.service.impl

import com.sachet.springrecipies.domain.Recipe
import com.sachet.springrecipies.exception.NotFoundException
import com.sachet.springrecipies.repository.RecipeRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.util.*
import kotlin.collections.HashSet

class RecipeServiceImplTest{


    @Mock
    val recipeRepository: com.sachet.springrecipies.repository.RecipeRepository = Mockito.mock(com.sachet.springrecipies.repository.RecipeRepository::class.java)
    private lateinit var recipeServiceImpl: com.sachet.springrecipies.service.impl.RecipeServiceImpl
    @BeforeEach
    fun setUp() {
        recipeServiceImpl = com.sachet.springrecipies.service.impl.RecipeServiceImpl(recipeRepository)
    }

    @Test
    fun findAll() {
        val recipe1 = com.sachet.springrecipies.domain.Recipe()
        val recipes = HashSet<com.sachet.springrecipies.domain.Recipe>()
        recipes.add(recipe1)
        Mockito.`when`(recipeRepository.findAll()).thenReturn(recipes)
        val result = recipeServiceImpl.findAll()
        assertNotNull(result)
        assertEquals(1, result.size)
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll()
    }

    @Test
    fun findById() {
        val recipe = com.sachet.springrecipies.domain.Recipe().apply {
            id = 1L
        }
        Mockito.`when`(recipeRepository.findById(any())).thenReturn(Optional.of(recipe))
        val result = recipeServiceImpl.getRecipeById(1L)
        assertNotNull(result)
        assertEquals(1L, result?.id)
        verify(recipeRepository, times(1)).findById(1L)
    }

    @Test
    fun getByIdNotFound() {
       `when`(recipeRepository.findById(any())).thenReturn(Optional.empty())
        try {
            recipeServiceImpl.getRecipeById(1L)
        }catch (ex: Exception) {
            assertTrue(ex is com.sachet.springrecipies.exception.NotFoundException)
        }
    }
}