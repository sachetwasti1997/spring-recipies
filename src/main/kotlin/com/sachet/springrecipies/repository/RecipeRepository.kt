package com.sachet.springrecipies.repository

import com.sachet.springrecipies.domain.Recipe
import org.springframework.data.repository.CrudRepository

interface RecipeRepository : CrudRepository<com.sachet.springrecipies.domain.Recipe, Long>