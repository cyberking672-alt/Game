/**
 * Sri Lankan Secret Recipes - Interactive Cooking App Logic
 * 2026 Trend Color System Architecture
 */

const SECRET_RECIPES = [
  {
    id: "jaffna-crab-curry",
    title: "Jaffna Spicy Mud Crab Curry",
    sinhala: "යාපනය කකුළු කරිය (Nandu Curry)",
    category: "Curries",
    origin: "Jaffna Peninsula",
    time: "45 mins",
    servings: 4,
    spiceLevel: 4,
    emoji: "🦀",
    themeClass: "crab-curry",
    secretTip: "Rahas Kramaya: Crush fresh Murunga (drumstick) leaves into the simmering gravy in the final 5 minutes, and roast the cumin-coriander Jaffna curry powder until deeply dark reddish-brown before pouring thick coconut cream.",
    ingredients: [
      "1 kg Fresh Mud Crab (cleaned & cracked)",
      "3 tbsp Roasted Jaffna Curry Powder (Thool)",
      "1.5 cups Thick Coconut Milk",
      "1 cup Thin Coconut Milk",
      "1 cup Fresh Murunga (Drumstick) Leaves",
      "1 tbsp Tamarind pulp extracted in warm water",
      "1 tsp Fenugreek seeds & cumin seeds",
      "10 Shallots & 6 Garlic cloves (sliced)",
      "2 sprigs Fresh Curry leaves & 3 Green chilies"
    ],
    steps: [
      "Clean crabs thoroughly and lightly crack claws to allow deep spice penetration.",
      "Heat virgin coconut oil in a clay pot; temper fenugreek, shallots, garlic, ginger, and curry leaves until aromatic.",
      "Add thin coconut milk, tamarind juice, turmeric, and the signature dark Jaffna thool. Bring to a rolling boil.",
      "Add the prepared crab pieces, cover and simmer on medium flame for 15 minutes.",
      "Pour thick coconut milk and gently swirl the pot without breaking crab shells.",
      "Stir in fresh Murunga leaves; cook for 4 more minutes until oil floats to the top."
    ],
    tags: ["Mud Crab", "Jaffna Thool", "Murunga Leaves", "Coconut Milk"]
  },
  {
    id: "black-pork-curry",
    title: "Ceylon Roasted Black Pork Curry",
    sinhala: "කළු පොල් ඌරු මස් කරිය (Kalu Pol Uru Mas)",
    category: "Curries",
    origin: "Southern Highlands",
    time: "60 mins",
    servings: 6,
    spiceLevel: 3,
    emoji: "🥘",
    themeClass: "black-pork",
    secretTip: "Rahas Kramaya: Toast freshly grated coconut in a dry pan until deeply blackened (without burning). Grind it with soaked Goraka (Garcinia cambogia) into a glistening black paste to seal the succulent pork pieces.",
    ingredients: [
      "1 kg Pork shoulder/belly (cut into 1-inch cubes)",
      "4 tbsp Freshly grated coconut (dry roasted to dark black-brown)",
      "4 pieces Dried Goraka (soaked in warm water and pounded)",
      "2.5 tbsp Dark Roasted Sri Lankan Curry Powder",
      "1.5 tbsp Coarsely crushed Black Peppercorns",
      "1 stalk Lemongrass (bruised) & 2 pieces Pandan leaf (Rampe)",
      "1 Ceylon Cinnamon quill",
      "8 Shallots & 1 tbsp Ginger-garlic paste"
    ],
    steps: [
      "Pound soaked goraka and dark-roasted coconut into an obsidian oily paste.",
      "Marinate pork cubes with the black paste, roasted curry powder, crushed black pepper, and sea salt for at least 30 minutes.",
      "In a seasoned clay pot (chattiyak), sauté sliced shallots, curry leaves, lemongrass, and rampe in a dash of oil.",
      "Add marinated pork and brown the meat on high heat for 7 minutes to release natural fats.",
      "Add 1 cup of water, cover tightly with a clay lid, and slow-braise on low ember for 45 minutes until tender and dark."
    ],
    tags: ["Roasted Coconut", "Goraka", "Black Pepper", "Clay Pot"]
  },
  {
    id: "egg-kottu-roti",
    title: "Colombo Night Market Egg Kottu",
    sinhala: "බිත්තර කොත්තු රොටි (Street Style)",
    category: "Street Food",
    origin: "Colombo Galle Face",
    time: "25 mins",
    servings: 2,
    spiceLevel: 3,
    emoji: "🍳",
    themeClass: "kottu",
    secretTip: "Rahas Kramaya: Slice godamba roti into airy ribbons and steam them on the hot griddle with a ladle of rich spicy curry gravy before folding in eggs and finely shredded crisp leeks.",
    ingredients: [
      "4 Godamba flatbreads (sliced into ribbons)",
      "3 Farm fresh eggs",
      "1 cup Shredded leeks & carrots",
      "1 cup Finely shredded green cabbage",
      "0.75 cup Rich spiced chicken or vegetable curry gravy",
      "3 Green chilies & 1 large onion (chopped)",
      "2 tbsp Ghee or coconut oil",
      "1 tsp Crushed chili flakes (kochu miris)"
    ],
    steps: [
      "Heat a wide cast iron tawa or skillet until sizzling hot.",
      "Add ghee, onions, green chilies, and curry leaves; stir-fry rapidly for 1 minute.",
      "Toss in sliced vegetables and stir-fry on high heat to keep them crunchy.",
      "Push veggies to side, crack eggs onto griddle, scramble quickly until soft.",
      "Add shredded roti ribbons, pour spicy curry gravy over, and chop rhythmically with two spatulas for 3 minutes."
    ],
    tags: ["Godamba Roti", "Leeks", "Curry Gravy", "Street Wok"]
  },
  {
    id: "egg-hopper",
    title: "Crisp-Lace Egg Hopper with Seeni Sambol",
    sinhala: "බිත්තර ආප්ප සහ සීනි සම්බෝල (Biththara Appa)",
    category: "Heritage",
    origin: "South-West Coast",
    time: "35 mins",
    servings: 4,
    spiceLevel: 2,
    emoji: "🍳",
    themeClass: "hopper",
    secretTip: "Rahas Kramaya: Ferment rice flour batter overnight with active coconut water or yeast. Swirl in an appachatti pan for paper-thin crispy bowl frills while the center remains a pillowy cloud around a runny egg yolk.",
    ingredients: [
      "2 cups Fine white rice flour (sifted)",
      "1 tsp Active dry yeast & 1 tsp Sugar",
      "1.5 cups Fresh coconut water & coconut milk",
      "4 Farm fresh eggs",
      "Coarsely cracked black pepper & sea salt",
      "Seeni Sambol (slow-caramelized spicy onion relish)"
    ],
    steps: [
      "Blend rice flour, yeast, sugar, and coconut water. Let ferment in a warm dark spot for 6-8 hours.",
      "Before cooking, stir in thick coconut milk and pinch of salt to achieve pouring cream consistency.",
      "Heat miniature curved hopper pan (appachatti), pour one ladle of batter and swiftly swirl 360 degrees.",
      "Crack a whole fresh egg into the bubbling center, sprinkle black pepper.",
      "Cover and steam for 3 minutes until outer frills turn golden-crisp and egg white is set with a soft yolk."
    ],
    tags: ["Rice Flour", "Coconut Water", "Crispy Edge", "Seeni Sambol"]
  },
  {
    id: "royal-watalappan",
    title: "Royal Kandy Spiced Watalappan",
    sinhala: "නියම වටලප්පන් (Kitul Jaggery Pudding)",
    category: "Desserts",
    origin: "Kandy Royal Court",
    time: "50 mins",
    servings: 6,
    spiceLevel: 0,
    emoji: "🍯",
    themeClass: "watalappan",
    secretTip: "Rahas Kramaya: Use genuine dark Kitul jaggery syrup scraped by hand, whip with first-press thick coconut cream, and infuse with freshly grated whole nutmeg and crushed green cardamom for a spongy honeycomb crumb.",
    ingredients: [
      "350g Pure dark Kitul jaggery (shaved fine)",
      "6 Large free-range eggs",
      "1.25 cups First-press pure coconut cream",
      "0.5 tsp Freshly grated nutmeg",
      "0.5 tsp Green cardamom pods (freshly crushed seeds)",
      "1 tbsp Rose water & 1 tsp Vanilla extract",
      "0.5 cup Toasted split cashew nuts"
    ],
    steps: [
      "Melt shaved jaggery in 3 tbsp of warm water over low flame until a rich dark syrup forms; cool to room temp.",
      "Whisk eggs gently (avoid over-frothing) and stir in jaggery syrup and fresh thick coconut cream.",
      "Fold in grated nutmeg, crushed cardamom, and rose water.",
      "Strain mixture twice through a fine muslin cloth into heatproof ceramic dish.",
      "Cover tightly with banana leaf or parchment; steam in double boiler on medium-low for 40 minutes.",
      "Garnish generously with toasted cashews and chill before slicing."
    ],
    tags: ["Kitul Jaggery", "Coconut Cream", "Nutmeg", "Cardamom"]
  },
  {
    id: "fish-ambul-thiyal",
    title: "Southern Sour Fish Ambul Thiyal",
    sinhala: "මාළු ඇඹුල් තියල් (Galle Heritage)",
    category: "Curries",
    origin: "Galle Southern Coast",
    time: "40 mins",
    servings: 6,
    spiceLevel: 3,
    emoji: "🐟",
    themeClass: "ambul-thiyal",
    secretTip: "Rahas Kramaya: Boil dried Goraka with black peppercorns, roasted cumin, and garlic, then grind to a dense ebony paste. Line the clay pot with banana leaves so the fish steams completely dry without burning.",
    ingredients: [
      "800g Fresh Yellowfin Tuna (Kelawalla), cut into firm 1.5-inch cubes",
      "6 pieces Dried Goraka (Gamboge)",
      "2 tbsp Black peppercorns (freshly roasted and crushed)",
      "1 tsp Roasted cumin seeds",
      "6 Garlic cloves & 1 thumb Ginger",
      "Fresh Banana leaf (for lining pot)",
      "Cinnamon stick & Curry leaves"
    ],
    steps: [
      "Boil goraka pieces in 0.5 cup water for 10 minutes until soft; grind with black pepper, garlic, ginger, and cumin into a dark sticky paste.",
      "Toss tuna cubes gently in the paste until every piece is uniformly coated in black.",
      "Line the bottom of a clay pot with fresh banana leaves.",
      "Arrange fish cubes in a single layer with cinnamon and curry leaves on top.",
      "Simmer on low heat with 0.5 cup water until all moisture evaporates, leaving firm, tangy, spice-crusted fish that keeps for weeks."
    ],
    tags: ["Yellowfin Tuna", "Goraka", "Black Pepper", "Banana Leaf"]
  },
  {
    id: "pol-roti-lunu-miris",
    title: "Coconut Pol Roti with Fiery Lunu Miris",
    sinhala: "පොල් රොටී සහ ලුණු මිරිස්",
    category: "Sambols",
    origin: "Village Hearth Style",
    time: "20 mins",
    servings: 4,
    spiceLevel: 4,
    emoji: "🥥",
    themeClass: "pol-roti",
    secretTip: "Rahas Kramaya: Do not over-knead the dough. Fold fresh scraped coconut with chopped shallots, green chilies, and tempered curry leaves before hand-patting onto a dry, screaming-hot cast-iron pan.",
    ingredients: [
      "2 cups Fresh grated coconut",
      "2 cups All-purpose or whole wheat flour",
      "6 Red shallots (finely diced)",
      "2 Green chilies & 1 sprig Curry leaves (chopped)",
      "1 tsp Sea salt & warm water to bind",
      "Lunu Miris: 12 dried red chilies, shallots, Maldon salt, Maldive fish flakes, fresh lime juice"
    ],
    steps: [
      "In a mixing bowl, rub coconut, shallots, green chilies, curry leaves, and salt together to release aromatics.",
      "Add flour and gradually sprinkle warm water; knead lightly for 2 minutes into a soft, textured ball.",
      "Divide into golf-ball sized rounds; flatten by hand into 0.5-inch thick discs on a banana leaf.",
      "Toast on a dry heavy cast-iron skillet on medium heat for 3-4 minutes per side until charred spots appear.",
      "Crush dried red chilies, shallots, and salt in a stone mortar (miris gala), splash lime juice and serve warm."
    ],
    tags: ["Fresh Coconut", "Miris Gala", "Cast Iron", "Fiery Sambol"]
  },
  {
    id: "creamy-ceylon-dhal",
    title: "Tempered Coconut Dhal Curry (Parippu)",
    sinhala: "පරිප්පු තෙම්පරාදුව (Ceylon Comfort)",
    category: "Heritage",
    origin: "Central Ceylon",
    time: "25 mins",
    servings: 4,
    spiceLevel: 1,
    emoji: "🥣",
    themeClass: "dhal",
    secretTip: "Rahas Kramaya: Cook red lentils with turmeric and pandan leaf, stir in thick coconut milk, and finish with a sizzling 'Theldala' (splutter mustard seeds, dried whole red chilies, shallots, and curry leaves in hot coconut oil and pour immediately over the pot).",
    ingredients: [
      "1.5 cups Red split lentils (Masoor dhal, rinsed)",
      "1 tsp Ground turmeric & 1 tsp Raw curry powder",
      "1 stalk Pandan leaf (Rampe) & 1 Green chili",
      "1.25 cups Thick coconut milk",
      "Theldala: 1.5 tbsp Coconut oil, 1 tsp Black mustard seeds, 2 dried red chilies, 5 shallots sliced, fresh curry leaves"
    ],
    steps: [
      "In a clay pot, combine washed lentils, turmeric, raw curry powder, green chili, and pandan leaf with 2 cups water.",
      "Simmer until lentils are tender and golden yellow (about 12 minutes).",
      "Pour thick coconut milk and salt; simmer on gentle low flame for 4 minutes until rich and velvety.",
      "In a small pan, heat coconut oil. Splutter mustard seeds, then brown shallots, whole red chilies, and curry leaves.",
      "Pour the sizzling tempered oil directly into the dhal pot and cover immediately for 2 minutes to trap the aroma."
    ],
    tags: ["Red Lentils", "Theldala", "Pandan Leaf", "Mustard Seeds"]
  }
];

// Application State
let currentCategory = "all";
let currentSearchQuery = "";
let currentSpiceFilter = "all";
let showFavoritesOnly = false;
let favorites = JSON.parse(localStorage.getItem("sl_recipe_favorites") || "[]");

// DOM Elements
const searchInput = document.getElementById("search-input");
const clearSearchBtn = document.getElementById("clear-search-btn");
const categoryFilters = document.getElementById("category-filters");
const spiceFilter = document.getElementById("spice-filter");
const toggleFavBtn = document.getElementById("toggle-favorites-filter");
const recipeGrid = document.getElementById("recipe-grid");
const emptyState = document.getElementById("empty-state");
const resetFiltersBtn = document.getElementById("reset-filters-btn");
const resultsCountText = document.getElementById("results-count-text");
const favoritesCountEl = document.getElementById("favorites-count");
const totalRecipesCountEl = document.getElementById("total-recipes-count");

// Modal Elements
const recipeModal = document.getElementById("recipe-modal");
const modalContent = document.getElementById("modal-content");
const modalCloseBtn = document.getElementById("modal-close-btn");

// Initialize
document.addEventListener("DOMContentLoaded", () => {
  totalRecipesCountEl.textContent = SECRET_RECIPES.length;
  updateFavoritesCount();
  setupEventListeners();
  renderRecipes();
});

function setupEventListeners() {
  // Search input
  searchInput.addEventListener("input", (e) => {
    currentSearchQuery = e.target.value.trim().toLowerCase();
    clearSearchBtn.style.display = currentSearchQuery ? "flex" : "none";
    renderRecipes();
  });

  clearSearchBtn.addEventListener("click", () => {
    searchInput.value = "";
    currentSearchQuery = "";
    clearSearchBtn.style.display = "none";
    searchInput.focus();
    renderRecipes();
  });

  // Category filters
  categoryFilters.addEventListener("click", (e) => {
    const btn = e.target.closest(".cat-pill");
    if (!btn) return;

    document.querySelectorAll(".cat-pill").forEach(p => p.classList.remove("active"));
    btn.classList.add("active");
    currentCategory = btn.getAttribute("data-cat");
    renderRecipes();
  });

  // Spice level filter
  spiceFilter.addEventListener("change", (e) => {
    currentSpiceFilter = e.target.value;
    renderRecipes();
  });

  // Favorites toggle
  toggleFavBtn.addEventListener("click", () => {
    showFavoritesOnly = !showFavoritesOnly;
    toggleFavBtn.classList.toggle("active", showFavoritesOnly);
    renderRecipes();
  });

  // Reset filters
  resetFiltersBtn.addEventListener("click", () => {
    searchInput.value = "";
    currentSearchQuery = "";
    clearSearchBtn.style.display = "none";
    currentCategory = "all";
    currentSpiceFilter = "all";
    showFavoritesOnly = false;
    toggleFavBtn.classList.remove("active");
    spiceFilter.value = "all";
    document.querySelectorAll(".cat-pill").forEach((p, idx) => {
      p.classList.toggle("active", idx === 0);
    });
    renderRecipes();
  });

  // Modal close
  modalCloseBtn.addEventListener("click", closeModal);
  recipeModal.addEventListener("click", (e) => {
    if (e.target === recipeModal) closeModal();
  });

  document.addEventListener("keydown", (e) => {
    if (e.key === "Escape" && recipeModal.style.display === "flex") {
      closeModal();
    }
  });
}

function updateFavoritesCount() {
  favoritesCountEl.textContent = favorites.length;
}

function toggleFavorite(id, event) {
  if (event) event.stopPropagation();
  const index = favorites.indexOf(id);
  if (index > -1) {
    favorites.splice(index, 1);
  } else {
    favorites.push(id);
  }
  localStorage.setItem("sl_recipe_favorites", JSON.stringify(favorites));
  updateFavoritesCount();
  renderRecipes();
}

function getFilteredRecipes() {
  return SECRET_RECIPES.filter(recipe => {
    // Category match
    if (currentCategory !== "all") {
      if (currentCategory === "Curries" && recipe.category !== "Curries") return false;
      if (currentCategory === "Street Food" && recipe.category !== "Street Food") return false;
      if (currentCategory === "Heritage" && recipe.category !== "Heritage") return false;
      if (currentCategory === "Sambols" && recipe.category !== "Sambols") return false;
      if (currentCategory === "Desserts" && recipe.category !== "Desserts") return false;
    }

    // Spice filter
    if (currentSpiceFilter !== "all" && recipe.spiceLevel !== parseInt(currentSpiceFilter, 10)) {
      return false;
    }

    // Favorites only
    if (showFavoritesOnly && !favorites.includes(recipe.id)) {
      return false;
    }

    // Search query match
    if (currentSearchQuery) {
      const matchTitle = recipe.title.toLowerCase().includes(currentSearchQuery);
      const matchSinhala = recipe.sinhala.toLowerCase().includes(currentSearchQuery);
      const matchSecret = recipe.secretTip.toLowerCase().includes(currentSearchQuery);
      const matchOrigin = recipe.origin.toLowerCase().includes(currentSearchQuery);
      const matchIng = recipe.ingredients.some(i => i.toLowerCase().includes(currentSearchQuery));
      const matchTags = recipe.tags.some(t => t.toLowerCase().includes(currentSearchQuery));
      if (!matchTitle && !matchSinhala && !matchSecret && !matchOrigin && !matchIng && !matchTags) {
        return false;
      }
    }

    return true;
  });
}

function renderRecipes() {
  const filtered = getFilteredRecipes();

  // Results text
  if (filtered.length === SECRET_RECIPES.length) {
    resultsCountText.textContent = `Showing all ${filtered.length} secret recipes`;
  } else {
    resultsCountText.textContent = `Found ${filtered.length} recipe${filtered.length === 1 ? '' : 's'}`;
  }

  if (filtered.length === 0) {
    recipeGrid.innerHTML = "";
    emptyState.style.display = "block";
    return;
  }

  emptyState.style.display = "none";
  recipeGrid.innerHTML = filtered.map(recipe => createRecipeCardHTML(recipe)).join("");

  // Attach card event listeners
  document.querySelectorAll(".recipe-card").forEach(card => {
    const id = card.getAttribute("data-id");
    card.addEventListener("click", () => openRecipeModal(id));
  });

  document.querySelectorAll(".card-fav-btn").forEach(btn => {
    btn.addEventListener("click", (e) => {
      const id = btn.getAttribute("data-id");
      toggleFavorite(id, e);
    });
  });
}

function createRecipeCardHTML(recipe) {
  const isFav = favorites.includes(recipe.id);

  // Chili dots generator
  const chiliDots = Array.from({ length: 4 }).map((_, i) => {
    const lit = i < recipe.spiceLevel ? "lit" : "";
    return `<span class="chili-dot ${lit}">🌶️</span>`;
  }).join("");

  // Tags generator
  const tagsHTML = recipe.tags.map(tag => `<span class="ing-chip">${tag}</span>`).join("");

  return `
    <article class="recipe-card" data-id="${recipe.id}">
      <div class="card-header-visual ${recipe.themeClass}">
        <div class="card-visual-overlay"></div>
        <div class="card-top-badges">
          <span class="category-tag">${recipe.category}</span>
          <button class="card-fav-btn ${isFav ? 'is-fav' : ''}" data-id="${recipe.id}" title="${isFav ? 'Remove favorite' : 'Add favorite'}">
            ♥
          </button>
        </div>
        <div class="card-emoji-icon">${recipe.emoji}</div>
      </div>

      <div class="card-content">
        <span class="card-origin">📍 ${recipe.origin}</span>
        <h2 class="card-title">${recipe.title}</h2>
        <p class="card-sinhala">${recipe.sinhala}</p>

        <div class="card-meta-row">
          <div class="meta-item">
            <span>⏱️ ${recipe.time}</span>
          </div>
          <div class="meta-item">
            <span>👥 ${recipe.servings} Servings</span>
          </div>
          <div class="meta-item heat-meter" title="Heat level: ${recipe.spiceLevel}/4">
            ${chiliDots}
          </div>
        </div>

        <div class="secret-highlight-box">
          <div class="secret-label">
            <span>✨ Rahas Kramaya (Secret Tip)</span>
          </div>
          <p class="secret-snippet">${recipe.secretTip}</p>
        </div>

        <div class="card-tags">
          ${tagsHTML}
        </div>

        <button class="view-recipe-btn" type="button">
          <span>Reveal Secret Method</span>
          <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round">
            <polyline points="9 18 15 12 9 6"></polyline>
          </svg>
        </button>
      </div>
    </article>
  `;
}

function openRecipeModal(id) {
  const recipe = SECRET_RECIPES.find(r => r.id === id);
  if (!recipe) return;

  const isFav = favorites.includes(recipe.id);

  const ingredientsHTML = recipe.ingredients.map(ing => `<li>${ing}</li>`).join("");
  const stepsHTML = recipe.steps.map(step => `<li>${step}</li>`).join("");

  modalContent.innerHTML = `
    <span class="modal-header-badge">${recipe.category} • ${recipe.origin}</span>
    <h2 class="modal-title">${recipe.title}</h2>
    <p class="modal-sinhala">${recipe.sinhala}</p>

    <div class="card-meta-row" style="margin-bottom: 20px;">
      <div class="meta-item">⏱️ Total Time: <strong>${recipe.time}</strong></div>
      <div class="meta-item">👥 Serves: <strong>${recipe.servings} People</strong></div>
      <div class="meta-item">🌶️ Heat: <strong>${recipe.spiceLevel} of 4</strong></div>
    </div>

    <div class="modal-secret-box">
      <h4>🔒 Ancestral Secret Technique (රහස් ක්‍රමය)</h4>
      <p>${recipe.secretTip}</p>
    </div>

    <h3 class="modal-section-title">🥥 Authentic Ingredients & Spices</h3>
    <ul class="ingredients-list">
      ${ingredientsHTML}
    </ul>

    <h3 class="modal-section-title">🔥 Step-by-Step Heritage Method</h3>
    <ol class="steps-list">
      ${stepsHTML}
    </ol>
  `;

  recipeModal.style.display = "flex";
  document.body.style.overflow = "hidden";
}

function closeModal() {
  recipeModal.style.display = "none";
  document.body.style.overflow = "auto";
}
