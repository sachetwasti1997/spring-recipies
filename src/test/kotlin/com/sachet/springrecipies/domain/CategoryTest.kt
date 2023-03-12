package com.sachet.springrecipies.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CategoryTest {

    private var category: com.sachet.springrecipies.domain.Category? = null

    @BeforeEach
    fun setUp() {
        category = com.sachet.springrecipies.domain.Category()
    }

    @Test
    fun getId() {
        val idValue = 4L
        category?.id = idValue
        assertEquals(4L, category?.id)
    }

    @Test
    fun getDescription() {
    }

    @Test
    fun getRecipes() {
    }
}