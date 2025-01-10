package exa.sa.myappwael

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import exa.sa.myappwael.ui.DetailsScreen
import exa.sa.myappwael.ui.HomeScreen
import exa.sa.myappwael.ui.SettingsScreen
import exa.sa.myappwael.ui.products.VegetablesScreen
import exa.sa.myappwael.ui.products.FruitsScreen // استيراد شاشة الفواكه

@Composable
fun MyAppWithBottomNav(navController: NavHostController = rememberNavController()) {
    val items = listOf(
        NavigationBarItemData("home", Icons.Filled.Home, "Home"),
        NavigationBarItemData("details", Icons.AutoMirrored.Filled.List, "Details"),
        NavigationBarItemData("settings", Icons.Filled.Settings, "Settings")
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentBackStack = navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStack.value?.destination?.route

                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(onCategoryClick = { category ->
                    when (category) {
                        "خضار" -> navController.navigate("vegetables")
                        "فواكه" -> navController.navigate("fruits")
                        else -> navController.navigate("details")
                    }
                })
            }
            composable("vegetables") {
                VegetablesScreen(onBack = { navController.popBackStack() })
            }
            composable("fruits") {
                FruitsScreen(onBack = { navController.popBackStack() })
            }
            composable("details") {
                DetailsScreen()
            }
            composable("settings") {
                SettingsScreen()
            }
        }
    }
}

data class NavigationBarItemData(
    val route: String,
    val icon: ImageVector,
    val label: String
)