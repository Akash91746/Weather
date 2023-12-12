package com.akash.weather.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akash.weather.R

abstract class AppLocalDatabase: RoomDatabase() {

    companion object {

        @Volatile
        private var INSTANCE: AppLocalDatabase? = null

        fun getInstance(context: Context): AppLocalDatabase {
            var instance = INSTANCE

            if (instance == null) {
                val databaseName = context.getString(R.string.local_database_id)
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppLocalDatabase::class.java,
                    databaseName
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }

            return instance
        }
    }
}