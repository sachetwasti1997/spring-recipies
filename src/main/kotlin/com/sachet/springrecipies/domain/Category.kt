package com.sachet.springrecipies.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,
    var description: String ?= null,
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @JsonIgnore
    var recipes: MutableSet<com.sachet.springrecipies.domain.Recipe> = HashSet()
)