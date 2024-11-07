package com.example.demorecyclerview.room

import android.content.Context
import androidx.room.*
import com.example.demorecyclerview.Company
import com.example.demorecyclerview.User

@Database(entities = [User::class, Company::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "app_db.db3"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}