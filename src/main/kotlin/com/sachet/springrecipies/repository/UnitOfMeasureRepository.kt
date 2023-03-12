package com.sachet.springrecipies.repository

import com.sachet.springrecipies.domain.UnitOfMeasure
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface UnitOfMeasureRepository : CrudRepository<com.sachet.springrecipies.domain.UnitOfMeasure, Long> {
    fun findByUom(uom: String): Optional<com.sachet.springrecipies.domain.UnitOfMeasure>
}