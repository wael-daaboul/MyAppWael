package exa.sa.myappwael.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import exa.sa.myappwael.data.Product
import exa.sa.myappwael.viewmodel.ProductViewModel
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun ProductsScreen(productViewModel: ProductViewModel) {
    val products by productViewModel.allProducts.observeAsState(emptyList())

    LazyColumn {
        items(products) { product ->
            ProductItem(product = product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column {
        androidx.compose.foundation.text.BasicText(text = "Name: ${product.name}")
        androidx.compose.foundation.text.BasicText(text = "Description: ${product.description}")
        androidx.compose.foundation.text.BasicText(text = "Price: ${product.price}")
        androidx.compose.foundation.text.BasicText(text = "Category: ${product.category}")
        androidx.compose.foundation.text.BasicText(text = "Stock Quantity: ${product.stockQuantity}")
    }
}
