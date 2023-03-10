package com.example.springrecipies.repository

import com.example.springrecipies.domain.*
import com.example.springrecipies.shared.BootStrapTests
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
    private lateinit var unitOfMeasureRepository: UnitOfMeasureRepository
    @Autowired
    private lateinit var categoryRepository: CategoryRepository
    @Autowired
    private lateinit var recipeRepository: RecipeRepository

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