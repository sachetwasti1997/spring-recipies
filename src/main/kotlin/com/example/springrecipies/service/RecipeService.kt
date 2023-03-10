package com.example.springrecipies.service

import com.example.springrecipies.domain.Recipe
import com.example.springrecipies.repository.RecipeRepository
import org.springframework.stereotype.Service

interface RecipeService {
    fun findAll(): Set<Recipe>
}