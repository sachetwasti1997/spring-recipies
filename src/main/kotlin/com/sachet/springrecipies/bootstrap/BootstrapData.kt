package com.sachet.springrecipies.bootstrap

import com.example.springrecipies.domain.*
import com.sachet.springrecipies.repository.CategoryRepository
import com.sachet.springrecipies.repository.RecipeRepository
import com.sachet.springrecipies.repository.UnitOfMeasureRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class BootstrapData(
    val recipeRepository: com.sachet.springrecipies.repository.RecipeRepository,
    val categoryRepository: com.sachet.springrecipies.repository.CategoryRepository,
    val unitOfMeasureRepository: com.sachet.springrecipies.repository.UnitOfMeasureRepository
): CommandLineRunner {

    override fun run(vararg args: String?) {
        com.sachet.springrecipies.bootstrap.FillDatabaseTable(
            recipeRepository,
            categoryRepository,
            unitOfMeasureRepository
        )
    }

}