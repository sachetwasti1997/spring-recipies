package com.sachet.springrecipies.bootstrap

import java.math.BigDecimal

class FillDatabaseTable(
    private val recipeRepository: com.sachet.springrecipies.repository.RecipeRepository,
    private val categoryRepository: com.sachet.springrecipies.repository.CategoryRepository,
    private val unitOfMeasureRepository: com.sachet.springrecipies.repository.UnitOfMeasureRepository
) {

    init {
        fillTable()
    }

    private fun fillTable() {
        val american = com.sachet.springrecipies.domain.Category(description = "American")
        val italian = com.sachet.springrecipies.domain.Category(description = "Italian")
        val mexican = com.sachet.springrecipies.domain.Category(description = "Mexican")
        val fastFood = com.sachet.springrecipies.domain.Category(description = "Fast Food")

        categoryRepository.saveAll(mutableListOf(american, italian, mexican, fastFood))

        val measure1 = com.sachet.springrecipies.domain.UnitOfMeasure(uom = "Teaspoon")
        val measure2 = com.sachet.springrecipies.domain.UnitOfMeasure(uom = "TableSpoon")
        val measure3 = com.sachet.springrecipies.domain.UnitOfMeasure(uom = "Cup")
        val measure4 = com.sachet.springrecipies.domain.UnitOfMeasure(uom = "Pinch")
        val measure5 = com.sachet.springrecipies.domain.UnitOfMeasure(uom = "Ounce")
        val measure6 = com.sachet.springrecipies.domain.UnitOfMeasure(uom = "Pint")
        val measure7 = com.sachet.springrecipies.domain.UnitOfMeasure(uom = "Each")
        val measure8 = com.sachet.springrecipies.domain.UnitOfMeasure(uom = "Dash")

        unitOfMeasureRepository.saveAll(mutableListOf(measure1,
            measure2,
            measure3,
            measure4,
            measure5,
            measure6,
            measure7,
            measure8
        ))

        recipeRepository.saveAll(prepareRecipesList())
    }

    private fun prepareRecipesList(): List<com.sachet.springrecipies.domain.Recipe> {
        val eachUomOptional = unitOfMeasureRepository.findByUom("Each")
        val tableSpoonUomOptional = unitOfMeasureRepository.findByUom("TableSpoon")
        val teaSpoonUomOptional = unitOfMeasureRepository.findByUom("Teaspoon")
        val dashUomOptional = unitOfMeasureRepository.findByUom("Dash")
        val pintUomOptional = unitOfMeasureRepository.findByUom("Pint")
        val cupUomOptional = unitOfMeasureRepository.findByUom("Cup")
        if (
            !eachUomOptional.isPresent ||
            !tableSpoonUomOptional.isPresent ||
            !teaSpoonUomOptional.isPresent ||
            !dashUomOptional.isPresent ||
            !pintUomOptional.isPresent ||
            !cupUomOptional.isPresent
        ) {
            throw RuntimeException("Expected Uom Not Found")
        }
        val eachUOM = eachUomOptional.get()
        val pintUOM = pintUomOptional.get()
        val tableSpoonUom = tableSpoonUomOptional.get()
        val teaSpoonUom = teaSpoonUomOptional.get()
        val dashUom = dashUomOptional.get()
        val cupUom = cupUomOptional.get()

        val ameriCatOptional = categoryRepository.findByDescription("American")
        val mexicanCatOptional = categoryRepository.findByDescription("Mexican")

        if (
            !mexicanCatOptional.isPresent ||
            !ameriCatOptional.isPresent
        ) {
            throw RuntimeException("Expected Category Not Found")
        }

        val american = ameriCatOptional.get()
        val mexican = mexicanCatOptional.get()

        //Guac
        val guacRecipe = com.sachet.springrecipies.domain.Recipe()
        guacRecipe.description = ("Perfect Guacamole");
        guacRecipe.prepTime = (10);
        guacRecipe.cookTime = (0);
        guacRecipe.difficulty = (com.sachet.springrecipies.domain.Difficulty.EASY);
        guacRecipe.directions = ("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        val guacNotes = com.sachet.springrecipies.domain.Notes()
        guacNotes.notes = ("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        guacRecipe.setNotesRecipe(guacNotes)
        guacRecipe.addIngredients(
            com.sachet.springrecipies.domain.Ingredient(
                description = "ripe avocados",
                amount = BigDecimal(2),
                unitOfMeasure = eachUOM,
                recipe = guacRecipe
            )
        )
        guacRecipe.addIngredients(
            com.sachet.springrecipies.domain.Ingredient(
                description = "Kosher salt",
                amount = BigDecimal(".5"),
                unitOfMeasure = teaSpoonUom,
                recipe = guacRecipe
            )
        )
        guacRecipe.addIngredients(
            com.sachet.springrecipies.domain.Ingredient(
                description = "fresh lime juice or lemon juice",
                amount = BigDecimal(2),
                unitOfMeasure = tableSpoonUom,
                recipe = guacRecipe
            )
        )
        guacRecipe.addIngredients(
            com.sachet.springrecipies.domain.Ingredient(
                description = "minced red onion or thinly sliced green onion",
                amount = BigDecimal(2),
                unitOfMeasure = tableSpoonUom,
                recipe = guacRecipe
            )
        )
        guacRecipe.addIngredients(
            com.sachet.springrecipies.domain.Ingredient(
                description = "serrano chiles, stems and seeds removed, minced",
                amount = BigDecimal(2),
                unitOfMeasure = eachUOM,
                recipe = guacRecipe
            )
        )
        guacRecipe.addIngredients(
            com.sachet.springrecipies.domain.Ingredient(
                description = "Cilantro",
                amount = BigDecimal(2),
                unitOfMeasure = tableSpoonUom,
                recipe = guacRecipe
            )
        )
        guacRecipe.addIngredients(
            com.sachet.springrecipies.domain.Ingredient(
                description = "freshly grated black pepper",
                amount = BigDecimal(2),
                unitOfMeasure = dashUom,
                recipe = guacRecipe
            )
        )
        guacRecipe.addIngredients(
            com.sachet.springrecipies.domain.Ingredient(
                description = "ripe tomato, seeds and pulp removed, chopped",
                amount = BigDecimal(".5"),
                unitOfMeasure = eachUOM,
                recipe = guacRecipe
            )
        )
        guacRecipe.categories?.add(american)
        guacRecipe.categories?.add(mexican)
        return listOf(guacRecipe)
    }

}