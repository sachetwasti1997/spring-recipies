package com.example.springrecipies.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import java.math.BigDecimal

@Entity
class Ingredient (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,

    var description: String ?= null,
    var amount: BigDecimal ?= null,

    @ManyToOne
    @JsonIgnore
    var recipe: Recipe ?= null,

    @OneToOne
    var unitOfMeasure: UnitOfMeasure ?= null
)