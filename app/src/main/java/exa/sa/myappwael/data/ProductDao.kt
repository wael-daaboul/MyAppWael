package exa.sa.myappwael.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM products WHERE category = :categoryName")
    suspend fun getProductsByCategory(categoryName: String): List<Product>

    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<Product>
}
