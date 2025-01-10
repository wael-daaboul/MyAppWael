package exa.sa.myappwael.data

import androidx.lifecycle.LiveData
import exa.sa.myappwael.dao.ProductDao

class ProductRepository(private val productDao: ProductDao) {

    suspend fun insertProduct(product: Product) {
        productDao.insertProduct(product)
    }

    fun getAllProducts(): LiveData<List<Product>> {
        return productDao.getAllProducts()
    }

    suspend fun deleteProductById(productId: Long) {
        productDao.deleteProductById(productId)
    }
}
