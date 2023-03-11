package com.example.springrecipies.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.OneToOne

@Entity
class Notes (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,

    @OneToOne
    @JsonIgnore
    var recipe: Recipe ?= null,

    @Lob
    var notes: String ?= null
)