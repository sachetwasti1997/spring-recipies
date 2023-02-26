package com.example.springrecipies.repository

import com.example.springrecipies.domain.UnitOfMeasure
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface UnitOfMeasureRepository : CrudRepository<UnitOfMeasure, Long> {
    fun findByUom(uom: String): Optional<UnitOfMeasure>
}