package com.example.springrecipies.repository

import com.example.springrecipies.domain.Category
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface CategoryRepository : CrudRepository<Category, Long> {
    fun findByDescription(description: String): Optional<Category>
}