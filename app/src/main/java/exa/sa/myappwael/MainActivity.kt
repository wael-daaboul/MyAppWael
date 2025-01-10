package exa.sa.myappwael

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import exa.sa.myappwael.ui.theme.MyAppWaelTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import exa.sa.myappwael.data.Product
import exa.sa.myappwael.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppWaelTheme {
                MyAppWithBottomNav()
            }
        }
    }
}

@Composable
fun MyAppWithBottomNav() {
    val productViewModel: ProductViewModel = viewModel()

    // إضافة منتج جديد
    val newProduct = Product(
        name = "Product 1",
        description = "Description of product",
        price = 100.0,
        category = "Electronics",
        stockQuantity = 10
    )
    productViewModel.insertProduct(newProduct)

    // عرض المنتجات
    DisplayProducts(productViewModel = productViewModel)
}

@Composable
fun DisplayProducts(productViewModel: ProductViewModel) {
    val products = productViewModel.getAllProducts().collectAsState(initial = emptyList())

    LazyColumn {
        items(products.value) { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column {
        BasicText(text = "Name: ${product.name}")
        BasicText(text = "Description: ${product.description}")
        BasicText(text = "Price: ${product.price}")
        BasicText(text = "Category: ${product.category}")
        BasicText(text = "Stock Quantity: ${product.stockQuantity}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppWaelTheme {
        MyAppWithBottomNav()
    }
}
