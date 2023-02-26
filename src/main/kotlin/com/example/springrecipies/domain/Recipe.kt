package com.example.springrecipies.domain

import jakarta.persistence.*

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
    var ingredients: MutableSet<Ingredient> = HashSet(),

    @Enumerated(value = EnumType.STRING)
    var difficulty: Difficulty ?= null
)