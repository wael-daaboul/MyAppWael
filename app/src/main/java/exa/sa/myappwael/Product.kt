package exa.sa.myappwael

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products") // هذا هو اسم الجدول في قاعدة البيانات
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Long = 0, // الحقل الذي سيحدد المعرف الفريد
    val name: String, // اسم المنتج
    val description: String, // وصف المنتج
    val price: Double, // سعر المنتج
    val category: String, // فئة المنتج
    val stockQuantity: Int // الكمية المتاحة في المخزن
)
