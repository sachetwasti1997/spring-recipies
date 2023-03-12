package com.sachet.springrecipies.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class UnitOfMeasure (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,
    var uom: String ?= null
)