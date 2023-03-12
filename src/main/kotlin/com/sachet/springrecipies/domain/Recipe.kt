package com.sachet.springrecipies.domain

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
    @Lob
    var directions: String ?= null,
    @Lob
    var image: ByteArray ?= null,

    @OneToOne(cascade = [CascadeType.ALL])
    var notes: com.sachet.springrecipies.domain.Notes?= null,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "recipe")
    var ingredients: MutableSet<com.sachet.springrecipies.domain.Ingredient> = HashSet(),

    @Enumerated(value = EnumType.STRING)
    var difficulty: com.sachet.springrecipies.domain.Difficulty?= null,

    @ManyToMany
    @JoinTable(
        name = "recipe_category",
        joinColumns = [JoinColumn(name = "recipe_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: MutableSet<com.sachet.springrecipies.domain.Category> ?= HashSet()
) {
    fun setNotesRecipe(notes: com.sachet.springrecipies.domain.Notes) {
        this.notes = notes
        notes.recipe = this
    }

    fun addIngredients(ingredient: com.sachet.springrecipies.domain.Ingredient) {
        ingredient.recipe = this
        this.ingredients.add(ingredient)
    }
}