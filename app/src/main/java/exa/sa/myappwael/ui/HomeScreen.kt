package exa.sa.myappwael.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearch: () -> Unit
) {
    TextField(
        value = query,
        onValueChange = onQueryChanged,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = { Text("ابحث عن منتج...") },
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = onSearch) {
                Icon(Icons.Default.Search, contentDescription = "بحث")
            }
        }
    )
}

@Composable
fun ProductCategories(onCategoryClick: (String) -> Unit) {
    val categories = listOf("خضار", "فواكه", "لحوم", "مستلزمات الأطفال")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("تصفح المنتجات", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        categories.forEach { category ->
            Button(
                onClick = { onCategoryClick(category) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(text = category)
            }
        }
    }
}

@Composable
fun HomeScreen(onCategoryClick: (String) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // محرك البحث
        SearchBar(
            query = searchQuery,
            onQueryChanged = { searchQuery = it },
            onSearch = {
                println("بحث عن: $searchQuery")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // قائمة المجموعات
        ProductCategories(onCategoryClick = onCategoryClick)
    }
}

@Composable
fun DetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome to Details Screen!", style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome to Settings Screen!", style = MaterialTheme.typography.headlineSmall)
    }
}
