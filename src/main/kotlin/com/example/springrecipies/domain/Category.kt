package com.example.springrecipies.domain

import jakarta.persistence.*

@Entity
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,
    var description: String ?= null,
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    var recipes: MutableSet<Recipe> = HashSet()
)