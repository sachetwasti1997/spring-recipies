package com.example.springrecipies.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,
    var description: String ?= null,
    @ManyToMany(mappedBy = "categories")
    var recipes: MutableSet<Recipe> = HashSet()
)