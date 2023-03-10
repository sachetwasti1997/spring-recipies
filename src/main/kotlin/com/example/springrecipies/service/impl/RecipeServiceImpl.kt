package com.example.springrecipies.service.impl

import com.example.springrecipies.domain.Recipe
import com.example.springrecipies.repository.RecipeRepository
import com.example.springrecipies.service.RecipeService
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl(
    val recipeRepository: RecipeRepository
) : RecipeService {
    override fun findAll(): Set<Recipe> {
//        val recipes = HashSet<Recipe>()
        return recipeRepository.findAll()
            .toCollection(HashSet<Recipe>())
    }
}