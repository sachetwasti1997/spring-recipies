package com.sachet.springrecipies.repository

import com.sachet.springrecipies.shared.BootStrapTests
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.math.BigDecimal

@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    private lateinit var unitOfMeasureRepository: com.sachet.springrecipies.repository.UnitOfMeasureRepository
    @Autowired
    private lateinit var categoryRepository: com.sachet.springrecipies.repository.CategoryRepository
    @Autowired
    private lateinit var recipeRepository: com.sachet.springrecipies.repository.RecipeRepository

    @BeforeEach
    fun setUp() {
        BootStrapTests(unitOfMeasureRepository, categoryRepository, recipeRepository)
    }

    @Test
    fun getAll() {
        val uomOptional = unitOfMeasureRepository.findByUom("Teaspoon")
        assertEquals("Teaspoon", uomOptional.get().uom)
    }
}