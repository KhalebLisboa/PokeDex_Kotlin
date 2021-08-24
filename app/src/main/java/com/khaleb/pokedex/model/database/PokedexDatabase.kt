package com.khaleb.pokedex.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.khaleb.pokedex.model.Pokemon

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class PokedexDatabase : RoomDatabase() {

    abstract val dao: PokeDao

    companion object {

        @Volatile
        private var INSTANCE: PokedexDatabase? = null

        fun getInstance(context: Context): PokedexDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    PokedexDatabase::class.java,
                    "pokedex").build()
            }
            return INSTANCE!!
        }
    }
}