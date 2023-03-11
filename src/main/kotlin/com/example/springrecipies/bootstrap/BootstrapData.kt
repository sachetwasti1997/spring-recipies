package com.example.springrecipies.bootstrap

import com.example.springrecipies.domain.*
import com.example.springrecipies.repository.CategoryRepository
import com.example.springrecipies.repository.RecipeRepository
import com.example.springrecipies.repository.UnitOfMeasureRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class BootstrapData(
    val recipeRepository: RecipeRepository,
    val categoryRepository: CategoryRepository,
    val unitOfMeasureRepository: UnitOfMeasureRepository
): CommandLineRunner {

    override fun run(vararg args: String?) {
        FillDatabaseTable(recipeRepository, categoryRepository, unitOfMeasureRepository)
    }

}