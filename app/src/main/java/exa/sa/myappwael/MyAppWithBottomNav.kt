package exa.sa.myappwael

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import exa.sa.myappwael.ui.ProductsScreen
import exa.sa.myappwael.viewmodel.ProductViewModel

@Composable
fun MyAppWithBottomNav(productViewModel: ProductViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "products") {
        composable("products") {
            ProductsScreen(productViewModel = productViewModel)
        }
    }
}