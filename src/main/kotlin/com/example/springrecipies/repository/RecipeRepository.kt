package com.example.springrecipies.repository

import com.example.springrecipies.domain.Recipe
import org.springframework.data.repository.CrudRepository

interface RecipeRepository : CrudRepository<Recipe, Long>