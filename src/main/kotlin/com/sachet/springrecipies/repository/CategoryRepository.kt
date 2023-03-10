package com.sachet.springrecipies.repository

import com.sachet.springrecipies.domain.Category
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface CategoryRepository : CrudRepository<com.sachet.springrecipies.domain.Category, Long> {
    fun findByDescription(description: String): Optional<com.sachet.springrecipies.domain.Category>
}