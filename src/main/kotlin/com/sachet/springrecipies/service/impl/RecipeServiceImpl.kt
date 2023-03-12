package com.sachet.springrecipies.service.impl

import com.sachet.springrecipies.domain.Recipe
import com.sachet.springrecipies.exception.NotFoundException
import com.sachet.springrecipies.repository.RecipeRepository
import com.sachet.springrecipies.service.RecipeService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl(
    val recipeRepository: com.sachet.springrecipies.repository.RecipeRepository
) : com.sachet.springrecipies.service.RecipeService {
    override fun findAll(): Set<com.sachet.springrecipies.domain.Recipe> {
//        val recipes = HashSet<Recipe>()
        return recipeRepository.findAll()
            .toCollection(HashSet<com.sachet.springrecipies.domain.Recipe>())
    }

    override fun getRecipeById(id: Long): com.sachet.springrecipies.domain.Recipe? {
        return recipeRepository.findByIdOrNull(id)
            ?: throw com.sachet.springrecipies.exception.NotFoundException("Recipe with Id: $id Not Found")
    }
}