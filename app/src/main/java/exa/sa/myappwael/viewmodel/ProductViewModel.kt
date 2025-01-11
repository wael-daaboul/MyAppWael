package exa.sa.myappwael.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import exa.sa.myappwael.data.Product
import exa.sa.myappwael.data.ProductDao
import kotlinx.coroutines.launch


class ProductViewModel(private val productDao: ProductDao) : ViewModel() {
    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()
}


    fun insertProduct(product: Product) {
        viewModelScope.launch {
            productDao.insertProduct(product)
        }
    }

