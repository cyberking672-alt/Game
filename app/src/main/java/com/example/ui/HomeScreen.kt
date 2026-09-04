package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.Recipe
import com.example.data.RecipeRepository
import com.example.ui.theme.TrendChiliRed
import com.example.ui.theme.TrendSaffron
import com.example.ui.theme.TrendSaffronGlow
import com.example.ui.theme.TrendTealGlow
import com.example.ui.theme.TrendTealLight
import com.example.ui.theme.TrendTealPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    var appModeIndex by remember { mutableIntStateOf(0) } // 0: Native App View, 1: HTML/CSS/JS Template
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    var selectedSpiceFilter by remember { mutableIntStateOf(0) } // 0: All, 1: Mild, 2: Med, 3: Hot, 4: Fiery
    var showFavoritesOnly by remember { mutableStateOf(false) }

    val favoritesList = remember { mutableStateListOf<String>() }
    var activeRecipeForDetail by remember { mutableStateOf<Recipe?>(null) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val filteredRecipes by remember {
        derivedStateOf {
            RecipeRepository.recipes.filter { recipe ->
                // Category match
                val matchesCategory = when (selectedCategory) {
                    "All" -> true
                    "Curries" -> recipe.category == "Curries"
                    "Street Food" -> recipe.category == "Street Food"
                    "Heritage" -> recipe.category == "Heritage"
                    "Sambols" -> recipe.category == "Sambols"
                    "Desserts" -> recipe.category == "Desserts"
                    else -> true
                }

                // Spice filter
                val matchesSpice = if (selectedSpiceFilter == 0) true else recipe.spiceLevel == selectedSpiceFilter

                // Favorites filter
                val matchesFav = if (showFavoritesOnly) favoritesList.contains(recipe.id) else true

                // Search query
                val q = searchQuery.trim().lowercase()
                val matchesSearch = if (q.isEmpty()) true else {
                    recipe.title.lowercase().contains(q) ||
                    recipe.sinhalaName.lowercase().contains(q) ||
                    recipe.secretTip.lowercase().contains(q) ||
                    recipe.origin.lowercase().contains(q) ||
                    recipe.ingredients.any { it.name.lowercase().contains(q) } ||
                    recipe.tags.any { it.lowercase().contains(q) }
                }

                matchesCategory && matchesSpice && matchesFav && matchesSearch
            }
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                // Main App Branding Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Icon
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    brush = Brush.linearGradient(
                                        listOf(TrendTealPrimary, TrendSaffron)
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🏺", fontSize = 22.sp)
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Surface(
                                shape = RoundedCornerShape(50),
                                color = TrendTealPrimary.copy(alpha = 0.15f),
                                border = androidx.compose.foundation.BorderStroke(1.dp, TrendTealLight.copy(alpha = 0.3f))
                            ) {
                                Text(
                                    text = "2026 Trend Color System",
                                    color = TrendTealLight,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                            Text(
                                text = "Sri Lankan Secret Recipes",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    // Random Recipe Button
                    IconButton(
                        onClick = {
                            val random = RecipeRepository.recipes.random()
                            activeRecipeForDetail = random
                        },
                        modifier = Modifier
                            .size(38.dp)
                            .background(TrendSaffron.copy(alpha = 0.15f), CircleShape)
                            .testTag("surprise_recipe_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = "Random Secret Recipe",
                            tint = TrendSaffronGlow,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                // View Mode Switcher: Native App vs Web Template (HTML/CSS/JS)
                TabRow(
                    selectedTabIndex = appModeIndex,
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    contentColor = TrendTealPrimary
                ) {
                    Tab(
                        selected = appModeIndex == 0,
                        onClick = { appModeIndex = 0 },
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.PhoneAndroid, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Native App", fontWeight = FontWeight.Bold)
                            }
                        },
                        modifier = Modifier.testTag("tab_native_app")
                    )
                    Tab(
                        selected = appModeIndex == 1,
                        onClick = { appModeIndex = 1 },
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Language, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Web Template (HTML/CSS/JS)", fontWeight = FontWeight.Bold)
                            }
                        },
                        modifier = Modifier.testTag("tab_web_template")
                    )
                }
            }
        }
    ) { innerPadding ->
        if (appModeIndex == 1) {
            // Live HTML/CSS/JS Template Viewer + Source Code Inspector
            WebTemplateViewer(
                modifier = Modifier.padding(innerPadding)
            )
        } else {
            // Native Android Jetpack Compose Experience
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .testTag("recipe_list_column"),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Hero Banner
                item {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .border(1.dp, TrendTealLight.copy(alpha = 0.25f), RoundedCornerShape(20.dp)),
                        color = Color.Black
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = painterResource(id = R.drawable.hero_sri_lankan_cooking),
                                contentDescription = "Sri Lankan Traditional Cooking",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            // Gradient overlay
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(
                                                Color.Black.copy(alpha = 0.25f),
                                                Color.Black.copy(alpha = 0.85f)
                                            )
                                        )
                                    )
                            )
                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "රහස් ක්‍රමය • Rahas Kramaya",
                                    color = TrendSaffronGlow,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Centuries of Ceylon Spice Secrets",
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }
                    }
                }

                // Search Bar
                item {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("recipe_search_input"),
                        placeholder = {
                            Text(
                                "Search secret spices, goraka, coconut, crab...",
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search icon",
                                tint = TrendTealLight
                            )
                        },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(
                                    onClick = { searchQuery = "" },
                                    modifier = Modifier.testTag("clear_search_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Clear search",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = TrendTealGlow,
                            unfocusedBorderColor = TrendTealLight.copy(alpha = 0.3f),
                            focusedContainerColor = MaterialTheme.colorScheme.surface,
                            unfocusedContainerColor = MaterialTheme.colorScheme.surface
                        )
                    )
                }

                // Category Chips Scroll
                item {
                    val categoryScrollState = rememberScrollState()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(categoryScrollState),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        RecipeRepository.categories.forEach { category ->
                            val isSelected = selectedCategory == category
                            FilterChip(
                                selected = isSelected,
                                onClick = { selectedCategory = category },
                                label = {
                                    val emoji = when (category) {
                                        "Curries" -> "🌶️ "
                                        "Street Food" -> "🔥 "
                                        "Heritage" -> "🏺 "
                                        "Sambols" -> "🥥 "
                                        "Desserts" -> "🍯 "
                                        else -> "✨ "
                                    }
                                    Text(
                                        text = "$emoji$category",
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        fontSize = 12.sp
                                    )
                                },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = TrendTealPrimary,
                                    selectedLabelColor = Color.White
                                ),
                                border = FilterChipDefaults.filterChipBorder(
                                    borderColor = if (isSelected) TrendTealLight else TrendTealLight.copy(alpha = 0.2f),
                                    enabled = true,
                                    selected = isSelected
                                ),
                                shape = RoundedCornerShape(50),
                                modifier = Modifier.testTag("category_chip_$category")
                            )
                        }
                    }
                }

                // Secondary Filter Controls (Spice Level & Favorites)
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Heat filter toggles
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text("Heat:", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)

                            listOf(0 to "All", 1 to "Mild", 2 to "Med", 3 to "Hot", 4 to "Fiery").forEach { (level, label) ->
                                val active = selectedSpiceFilter == level
                                Surface(
                                    shape = RoundedCornerShape(50),
                                    color = if (active) TrendChiliRed.copy(alpha = 0.25f) else Color.Transparent,
                                    border = if (active) androidx.compose.foundation.BorderStroke(1.dp, TrendChiliRed) else null,
                                    modifier = Modifier
                                        .clickable { selectedSpiceFilter = level }
                                        .padding(horizontal = 6.dp, vertical = 4.dp)
                                ) {
                                    Text(
                                        text = label,
                                        fontSize = 11.sp,
                                        fontWeight = if (active) FontWeight.Bold else FontWeight.Normal,
                                        color = if (active) TrendChiliRed else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }

                        // Favorites Filter Toggle
                        Surface(
                            shape = RoundedCornerShape(50),
                            color = if (showFavoritesOnly) TrendSaffron.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surfaceVariant,
                            border = if (showFavoritesOnly) androidx.compose.foundation.BorderStroke(1.dp, TrendSaffronGlow) else null,
                            modifier = Modifier
                                .clickable { showFavoritesOnly = !showFavoritesOnly }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("favorites_filter_toggle")
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = if (showFavoritesOnly) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                    contentDescription = null,
                                    tint = if (showFavoritesOnly) TrendSaffronGlow else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (favoritesList.isNotEmpty()) "Saved (${favoritesList.size})" else "Saved",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (showFavoritesOnly) TrendSaffronGlow else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }

                // Results Counter
                item {
                    Text(
                        text = if (filteredRecipes.size == RecipeRepository.recipes.size) {
                            "Showing all ${filteredRecipes.size} secret recipes"
                        } else {
                            "Found ${filteredRecipes.size} matching recipe${if (filteredRecipes.size == 1) "" else "s"}"
                        },
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Empty State
                if (filteredRecipes.isEmpty()) {
                    item {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            shape = RoundedCornerShape(20.dp),
                            color = MaterialTheme.colorScheme.surface,
                            border = androidx.compose.foundation.BorderStroke(1.dp, TrendTealLight.copy(alpha = 0.2f))
                        ) {
                            Column(
                                modifier = Modifier.padding(32.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("🍃", fontSize = 48.sp)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "No secret recipes found",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Try clearing your search or removing active filters.",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
                                )
                                ElevatedButton(
                                    onClick = {
                                        searchQuery = ""
                                        selectedCategory = "All"
                                        selectedSpiceFilter = 0
                                        showFavoritesOnly = false
                                    },
                                    colors = ButtonDefaults.elevatedButtonColors(
                                        containerColor = TrendTealPrimary,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text("Reset All Filters")
                                }
                            }
                        }
                    }
                }

                // Recipe Cards
                items(
                    items = filteredRecipes,
                    key = { it.id }
                ) { recipe ->
                    val isFav = favoritesList.contains(recipe.id)
                    RecipeCard(
                        recipe = recipe,
                        isFavorite = isFav,
                        onFavoriteToggle = {
                            if (isFav) favoritesList.remove(recipe.id) else favoritesList.add(recipe.id)
                        },
                        onClick = {
                            activeRecipeForDetail = recipe
                        }
                    )
                }
            }
        }

        // Detail BottomSheet
        activeRecipeForDetail?.let { recipe ->
            val isFav = favoritesList.contains(recipe.id)
            RecipeDetailSheet(
                recipe = recipe,
                isFavorite = isFav,
                onFavoriteToggle = {
                    if (isFav) favoritesList.remove(recipe.id) else favoritesList.add(recipe.id)
                },
                onDismiss = {
                    activeRecipeForDetail = null
                },
                sheetState = sheetState
            )
        }
    }
}
