package com.example.springrecipies.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne

@Entity
class Recipe (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,

    var description: String ?= null,
    var prepTime: Int ?= null,
    var cookTime: Int ?= null,
    var servings: Int ?= null,
    var source: String ?= null,
    var url: String ?= null,
    var directions: String ?= null,
    @Lob
    var image: ByteArray ?= null,

    @OneToOne(cascade = [CascadeType.ALL])
    var notes: Notes ?= null,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "recipe")
    var ingredients: MutableSet<Ingredient> = HashSet()
)