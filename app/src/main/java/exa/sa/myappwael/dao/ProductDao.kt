package exa.sa.myappwael.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import exa.sa.myappwael.data.Product

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM product_table")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("DELETE FROM product_table WHERE id = :productId")
    suspend fun deleteProductById(productId: Long)
}
