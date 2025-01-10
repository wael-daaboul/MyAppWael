package exa.sa.myappwael.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import exa.sa.myappwael.data.AppDatabase
import exa.sa.myappwael.data.Product
import exa.sa.myappwael.data.ProductDao
import exa.sa.myappwael.data.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val _allProducts = MutableStateFlow<List<Product>>(emptyList())
    val allProducts: StateFlow<List<Product>> = _allProducts

    private val productDao: ProductDao = AppDatabase.getDatabase(application).productDao()


    init {
        repository = ProductRepository(productDao)
    }

    fun insertProduct(product: Product) {
        viewModelScope.launch {
            repository.insertProduct(product)
        }
    }

    fun getAllProducts(): LiveData<List<Product>> {
        return repository.getAllProducts()
    }

    fun deleteProductById(productId: Long) {
        viewModelScope.launch {
            repository.deleteProductById(productId)
        }
    }
}
