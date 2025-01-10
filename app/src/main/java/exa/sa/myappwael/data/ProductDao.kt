package exa.sa.myappwael.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import exa.sa.myappwael.data.Product

@Dao
interface ProductDao {
    // دالة لإضافة منتج جديد
    @Insert
    suspend fun insertProduct(product: Product)

    // دالة لاسترجاع جميع المنتجات
    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<Product>

    // دالة لحذف منتج باستخدام الـ id
    @Query("DELETE FROM products WHERE id = :productId")
    suspend fun deleteProductById(productId: Long)
}
