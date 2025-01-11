package exa.sa.myappwael.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Product::class, Category::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao
}
