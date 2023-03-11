package com.example.springrecipies.service.impl

import com.example.springrecipies.domain.Recipe
import com.example.springrecipies.exception.NotFoundException
import com.example.springrecipies.repository.RecipeRepository
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
    val recipeRepository: RecipeRepository  = Mockito.mock(RecipeRepository::class.java)
    private lateinit var recipeServiceImpl: RecipeServiceImpl
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
        val result = recipeServiceImpl.findAll()
        assertNotNull(result)
        assertEquals(1, result.size)
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll()
    }

    @Test
    fun findById() {
        val recipe = Recipe().apply {
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
            assertTrue(ex is NotFoundException)
        }
    }
}