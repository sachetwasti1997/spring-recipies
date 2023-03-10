package com.example.springrecipies.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CategoryTest {

    private var category: Category? = null

    @BeforeEach
    fun setUp() {
        category = Category()
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