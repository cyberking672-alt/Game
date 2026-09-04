package com.example.data

data class Recipe(
    val id: String,
    val title: String,
    val sinhala: String,
    val category: String,
    val origin: String,
    val timeMinutes: Int,
    val baseServings: Int,
    val spiceLevel: Int, // 1: Mild, 2: Medium, 3: Hot, 4: Jaffna Fiery
    val emoji: String,
    val secretTip: String,
    val ingredients: List<IngredientItem>,
    val steps: List<String>,
    val tags: List<String>,
    val primaryColorHex: Long = 0xFF0D9488
) {
    val sinhalaName: String get() = sinhala
}

data class IngredientItem(
    val name: String,
    val baseAmount: Double,
    val unit: String
) {
    fun getFormattedAmount(scaleFactor: Double): String {
        val scaled = baseAmount * scaleFactor
        val formatted = if (scaled % 1.0 == 0.0) {
            scaled.toInt().toString()
        } else {
            String.format("%.1f", scaled)
        }
        return if (unit.isNotEmpty()) "$formatted $unit $name" else "$formatted $name"
    }
}

object RecipeRepository {
    val recipes = listOf(
        Recipe(
            id = "jaffna-crab-curry",
            title = "Jaffna Spicy Mud Crab Curry",
            sinhala = "යාපනය කකුළු කරිය (Nandu Curry)",
            category = "Curries",
            origin = "Jaffna Peninsula",
            timeMinutes = 45,
            baseServings = 4,
            spiceLevel = 4,
            emoji = "🦀",
            secretTip = "Crush fresh Murunga (drumstick) leaves into the simmering gravy in the final 5 minutes, and roast the cumin-coriander Jaffna curry powder until deeply dark reddish-brown before pouring thick coconut cream.",
            ingredients = listOf(
                IngredientItem("Fresh Mud Crab (cleaned & cracked)", 1.0, "kg"),
                IngredientItem("Roasted Jaffna Curry Powder (Thool)", 3.0, "tbsp"),
                IngredientItem("Thick Coconut Milk", 1.5, "cups"),
                IngredientItem("Thin Coconut Milk", 1.0, "cup"),
                IngredientItem("Fresh Murunga Leaves", 1.0, "cup"),
                IngredientItem("Tamarind Pulp (soaked)", 1.0, "tbsp"),
                IngredientItem("Fenugreek & Cumin Seeds", 1.0, "tsp"),
                IngredientItem("Shallots & Garlic cloves", 10.0, "pcs"),
                IngredientItem("Green Chilies & Curry Leaves", 3.0, "sprigs")
            ),
            steps = listOf(
                "Clean crabs thoroughly and lightly crack claws to allow the intense spice infusion.",
                "Heat virgin coconut oil in a traditional clay pot; temper fenugreek, shallots, garlic, and curry leaves.",
                "Add thin coconut milk, tamarind pulp juice, and dark roasted Jaffna thool. Bring to a fragrant boil.",
                "Submerge crab pieces, cover, and simmer on medium flame for 15 minutes.",
                "Pour thick first-press coconut milk and gently swirl the pot without breaking crab shells.",
                "Fold in fresh Murunga leaves; cook for 4 more minutes until aromatic red oil floats to the surface."
            ),
            tags = listOf("Mud Crab", "Jaffna Thool", "Murunga Leaves", "Clay Pot"),
            primaryColorHex = 0xFFB91C1C
        ),
        Recipe(
            id = "black-pork-curry",
            title = "Ceylon Roasted Black Pork Curry",
            sinhala = "කළු පොල් ඌරු මස් කරිය (Kalu Pol Uru Mas)",
            category = "Curries",
            origin = "Southern Highlands",
            timeMinutes = 60,
            baseServings = 6,
            spiceLevel = 3,
            emoji = "🥘",
            secretTip = "Toast freshly grated coconut in a dry pan until dark mahogany black (without burning). Grind with soaked Goraka into a dense, oily paste to coat the pork before slow-braising.",
            ingredients = listOf(
                IngredientItem("Pork Shoulder or Belly (cubed)", 1.0, "kg"),
                IngredientItem("Freshly Grated Coconut (roasted black)", 4.0, "tbsp"),
                IngredientItem("Dried Goraka (soaked & pounded)", 4.0, "pcs"),
                IngredientItem("Dark Roasted Sri Lankan Curry Powder", 2.5, "tbsp"),
                IngredientItem("Coarsely Crushed Black Pepper", 1.5, "tbsp"),
                IngredientItem("Lemongrass & Pandan Leaf (Rampe)", 2.0, "stalks"),
                IngredientItem("Ceylon Cinnamon Quill", 1.0, "piece"),
                IngredientItem("Shallots & Ginger-Garlic paste", 2.0, "tbsp")
            ),
            steps = listOf(
                "Pound soaked goraka and dry-roasted dark coconut in a mortar into an obsidian paste.",
                "Marinate pork cubes with the black paste, roasted curry powder, cracked black pepper, and salt for 30 minutes.",
                "Sauté shallots, lemongrass, pandan leaf, and curry leaves in a hot clay pot (chattiyak).",
                "Add pork and sear on high heat for 7 minutes to render natural succulent fats.",
                "Add 1 cup of hot water, cover tightly, and slow-braise on low ember for 45 minutes until meltingly tender."
            ),
            tags = listOf("Roasted Coconut", "Goraka", "Black Pepper", "Slow Braise"),
            primaryColorHex = 0xFF78350F
        ),
        Recipe(
            id = "egg-kottu-roti",
            title = "Colombo Night Market Egg Kottu",
            sinhala = "බිත්තර කොත්තු රොටි (Galle Face Style)",
            category = "Street Food",
            origin = "Colombo Galle Face",
            timeMinutes = 25,
            baseServings = 2,
            spiceLevel = 3,
            emoji = "🍳",
            secretTip = "Slice godamba flatbread into airy ribbons and steam them on the screaming-hot iron griddle with a ladle of rich spicy curry gravy before folding in eggs and finely shredded crisp leeks.",
            ingredients = listOf(
                IngredientItem("Godamba Flatbreads (sliced into ribbons)", 4.0, "pcs"),
                IngredientItem("Farm Fresh Eggs", 3.0, "pcs"),
                IngredientItem("Shredded Leeks & Carrots", 1.0, "cup"),
                IngredientItem("Finely Shredded Green Cabbage", 1.0, "cup"),
                IngredientItem("Rich Spiced Chicken/Veg Gravy", 0.75, "cup"),
                IngredientItem("Chopped Green Chilies & Onions", 1.0, "cup"),
                IngredientItem("Ghee or Coconut Oil", 2.0, "tbsp"),
                IngredientItem("Crushed Chili Flakes (Kochchi)", 1.0, "tsp")
            ),
            steps = listOf(
                "Heat a wide cast iron skillet or flat tawa until shimmering hot.",
                "Add ghee, onions, green chilies, and curry leaves; stir-fry rapidly for 1 minute.",
                "Toss in crisp leeks and cabbage, keeping them vibrant and crunchy.",
                "Push vegetables to the perimeter, scramble eggs softly in the center.",
                "Toss in sliced roti ribbons, drench in curry gravy, and chop rhythmically for 3 minutes until infused."
            ),
            tags = listOf("Godamba Roti", "Leeks", "Spiced Gravy", "Street Wok"),
            primaryColorHex = 0xFFEA580C
        ),
        Recipe(
            id = "egg-hopper",
            title = "Crisp-Lace Egg Hopper with Seeni Sambol",
            sinhala = "බිත්තර ආප්ප සහ සීනි සම්බෝල (Biththara Appa)",
            category = "Heritage",
            origin = "South-West Coast",
            timeMinutes = 35,
            baseServings = 4,
            spiceLevel = 2,
            emoji = "🥞",
            secretTip = "Ferment rice flour batter overnight with active coconut water or yeast. Swirl in an appachatti pan for paper-thin crispy bowl frills while the center remains a pillowy cloud around a runny egg yolk.",
            ingredients = listOf(
                IngredientItem("Fine White Rice Flour (sifted)", 2.0, "cups"),
                IngredientItem("Active Dry Yeast & Raw Sugar", 1.0, "tsp"),
                IngredientItem("Fresh Coconut Water & Milk", 1.5, "cups"),
                IngredientItem("Farm Fresh Eggs", 4.0, "pcs"),
                IngredientItem("Coarsely Cracked Black Pepper", 1.0, "tsp"),
                IngredientItem("Seeni Sambol (caramelized onion relish)", 4.0, "tbsp")
            ),
            steps = listOf(
                "Blend rice flour, yeast, sugar, and fresh coconut water. Ferment in a warm spot for 6-8 hours.",
                "Before cooking, stir in rich coconut cream and sea salt to pouring cream consistency.",
                "Heat miniature curved hopper pan, pour one ladle of batter, and swiftly swirl 360 degrees.",
                "Crack a whole fresh egg into the bubbling center, dust with freshly ground black pepper.",
                "Cover with curved lid and steam 3 minutes until outer lace edges turn golden-crisp with a runny yolk."
            ),
            tags = listOf("Rice Flour", "Coconut Water", "Crispy Edge", "Seeni Sambol"),
            primaryColorHex = 0xFF0D9488
        ),
        Recipe(
            id = "royal-watalappan",
            title = "Royal Kandy Spiced Watalappan",
            sinhala = "නියම වටලප්පන් (Kitul Jaggery Pudding)",
            category = "Desserts",
            origin = "Kandy Royal Court",
            timeMinutes = 50,
            baseServings = 6,
            spiceLevel = 1,
            emoji = "🍯",
            secretTip = "Use pure dark Kitul palm jaggery shaved by hand, whisk with thick first-press coconut cream, and infuse with freshly grated whole nutmeg and green cardamom for a velvety honeycomb crumb.",
            ingredients = listOf(
                IngredientItem("Pure Dark Kitul Jaggery (shaved)", 350.0, "g"),
                IngredientItem("Large Free-Range Eggs", 6.0, "pcs"),
                IngredientItem("First-Press Pure Coconut Cream", 1.25, "cups"),
                IngredientItem("Freshly Grated Nutmeg", 0.5, "tsp"),
                IngredientItem("Crushed Green Cardamom Seeds", 0.5, "tsp"),
                IngredientItem("Rose Water & Pure Vanilla", 1.0, "tbsp"),
                IngredientItem("Toasted Split Cashew Nuts", 0.5, "cup")
            ),
            steps = listOf(
                "Dissolve shaved jaggery in 3 tbsp warm water over low flame into syrup; allow to cool completely.",
                "Whisk eggs gently (avoid air bubbles) and blend in jaggery syrup and fresh coconut cream.",
                "Fold in grated nutmeg, crushed cardamom, and fragrant rose water.",
                "Strain twice through a fine mesh muslin cloth into heatproof ceramic dishes.",
                "Cover tightly with banana leaf or foil; steam in double boiler on gentle heat for 40 minutes.",
                "Garnish with toasted cashews and chill for 2 hours before slicing."
            ),
            tags = listOf("Kitul Jaggery", "Coconut Cream", "Nutmeg", "Cardamom"),
            primaryColorHex = 0xFFB45309
        ),
        Recipe(
            id = "fish-ambul-thiyal",
            title = "Southern Sour Fish Ambul Thiyal",
            sinhala = "මාළු ඇඹුල් තියල් (Galle Heritage)",
            category = "Curries",
            origin = "Galle Southern Coast",
            timeMinutes = 40,
            baseServings = 6,
            spiceLevel = 3,
            emoji = "🐟",
            secretTip = "Boil dried Goraka with black peppercorns, roasted cumin, and garlic, then grind to a dense ebony paste. Line the clay pot with banana leaves so the fish steams completely dry without burning.",
            ingredients = listOf(
                IngredientItem("Fresh Yellowfin Tuna (Kelawalla, cubed)", 800.0, "g"),
                IngredientItem("Dried Goraka (Gamboge)", 6.0, "pcs"),
                IngredientItem("Whole Black Peppercorns (roasted)", 2.0, "tbsp"),
                IngredientItem("Roasted Cumin Seeds", 1.0, "tsp"),
                IngredientItem("Garlic cloves & Ginger", 6.0, "pcs"),
                IngredientItem("Fresh Banana Leaf (for pot lining)", 1.0, "sheet"),
                IngredientItem("Cinnamon & Curry Leaves", 2.0, "sprigs")
            ),
            steps = listOf(
                "Boil goraka pieces in water until tender, then pound with black pepper, garlic, and cumin into a paste.",
                "Coat tuna cubes gently in the paste until every piece is uniformly stained black.",
                "Line the bottom of an unglazed clay pot with fresh banana leaves.",
                "Layer fish cubes with cinnamon quill and fresh curry leaves.",
                "Simmer on very low heat until liquid completely evaporates, leaving dry, tangy fish that keeps for weeks."
            ),
            tags = listOf("Yellowfin Tuna", "Goraka", "Black Pepper", "Banana Leaf"),
            primaryColorHex = 0xFF4338CA
        ),
        Recipe(
            id = "pol-roti-lunu-miris",
            title = "Coconut Pol Roti with Fiery Lunu Miris",
            sinhala = "පොල් රොටී සහ ලුණු මිරිස්",
            category = "Sambols",
            origin = "Village Hearth Style",
            timeMinutes = 20,
            baseServings = 4,
            spiceLevel = 4,
            emoji = "🥥",
            secretTip = "Do not over-knead the dough. Fold fresh scraped coconut with chopped shallots, green chilies, and tempered curry leaves before hand-patting onto a dry, screaming-hot cast-iron pan.",
            ingredients = listOf(
                IngredientItem("Fresh Grated Coconut", 2.0, "cups"),
                IngredientItem("All-Purpose or Whole Wheat Flour", 2.0, "cups"),
                IngredientItem("Red Shallots (finely diced)", 6.0, "pcs"),
                IngredientItem("Green Chilies & Curry leaves", 2.0, "sprigs"),
                IngredientItem("Sea Salt & Warm Water", 1.0, "tsp"),
                IngredientItem("Lunu Miris (Crushed dried chilies, shallots, lime)", 4.0, "tbsp")
            ),
            steps = listOf(
                "Rub grated coconut, shallots, green chilies, and salt together in a bowl to release essential oils.",
                "Add flour and gradually sprinkle warm water; knead gently for 2 minutes into a soft textured dough.",
                "Divide into rounds and pat flat by hand into 0.5-inch discs on a banana leaf.",
                "Toast on a dry heavy cast-iron skillet on medium heat for 3 minutes per side until charred spots form.",
                "Pound dried red chilies, shallots, and salt in a stone miris gala with fresh lime juice to serve."
            ),
            tags = listOf("Fresh Coconut", "Miris Gala", "Cast Iron", "Fiery Sambol"),
            primaryColorHex = 0xFFD97706
        ),
        Recipe(
            id = "creamy-ceylon-dhal",
            title = "Tempered Coconut Dhal Curry (Parippu)",
            sinhala = "පරිප්පු තෙම්පරාදුව (Ceylon Comfort)",
            category = "Heritage",
            origin = "Central Ceylon",
            timeMinutes = 25,
            baseServings = 4,
            spiceLevel = 1,
            emoji = "🥣",
            secretTip = "Cook red lentils with turmeric and pandan leaf, stir in thick coconut milk, and finish with a sizzling 'Theldala' (splutter mustard seeds, dried whole red chilies, shallots, and curry leaves in hot coconut oil and pour immediately over the pot).",
            ingredients = listOf(
                IngredientItem("Red Split Lentils (Masoor dhal)", 1.5, "cups"),
                IngredientItem("Ground Turmeric & Raw Curry Powder", 1.0, "tsp"),
                IngredientItem("Pandan Leaf (Rampe) & Green Chili", 1.0, "stalk"),
                IngredientItem("Thick Coconut Milk", 1.25, "cups"),
                IngredientItem("Theldala (Mustard seeds, dry chilies, shallots)", 2.0, "tbsp")
            ),
            steps = listOf(
                "Simmer lentils with turmeric, curry powder, green chili, and pandan in 2 cups water until tender.",
                "Pour thick coconut milk and salt; simmer on gentle low flame for 4 minutes until velvety.",
                "In a small tempering pan, heat coconut oil and splutter mustard seeds, sliced shallots, and curry leaves.",
                "Pour the sizzling tempered aromatics directly into the dhal pot and cover immediately for 2 minutes."
            ),
            tags = listOf("Red Lentils", "Theldala", "Pandan Leaf", "Mustard Seeds"),
            primaryColorHex = 0xFFF59E0B
        )
    )

    val categories = listOf("All", "Curries", "Street Food", "Heritage", "Sambols", "Desserts")
}
