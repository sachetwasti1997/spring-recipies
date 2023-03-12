package com.sachet.springrecipies.service

import com.sachet.springrecipies.domain.Recipe
import com.sachet.springrecipies.repository.RecipeRepository
import org.springframework.stereotype.Service

interface RecipeService {
    fun findAll(): Set<com.sachet.springrecipies.domain.Recipe>
    fun getRecipeById(id: Long): com.sachet.springrecipies.domain.Recipe?
}