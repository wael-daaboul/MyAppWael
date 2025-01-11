package exa.sa.myappwael

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import exa.sa.myappwael.data.AppDatabase
import exa.sa.myappwael.ui.theme.MyAppWaelTheme
import exa.sa.myappwael.viewmodel.ProductViewModel
import exa.sa.myappwael.viewmodel.ProductViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // الحصول على قاعدة البيانات من التطبيق
        val database = (application as MyAppWaelApplication).database
        val productDao = database.productDao()

        setContent {
            MyAppWaelTheme {
                // تمرير ProductDao إلى ProductViewModel
                val productViewModel: ProductViewModel = viewModel(
                    factory = ProductViewModelFactory(productDao)
                )
                MyAppWithBottomNav(productViewModel)
            }
        }
    }
}
