package exa.sa.myappwael

import android.app.Application
import androidx.room.Room
import exa.sa.myappwael.data.AppDatabase

class MyAppWaelApplication : Application() {
    lateinit var database: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "myappwael_database"
        ).build()
    }
}
