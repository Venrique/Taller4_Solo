package com.venrique.taller4.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.venrique.taller4.Database.Entities.Autor
import com.venrique.taller4.Database.Entities.Libro
import com.venrique.taller4.Database.Entities.LibroTagJoin
import com.venrique.taller4.Database.Entities.Tags
import com.venrique.taller4.Database.dao.AutorDao
import com.venrique.taller4.Database.dao.LibroDao
import com.venrique.taller4.Database.dao.LibroTagJoinDao
import com.venrique.taller4.Database.dao.TagsDao

@Database(entities = [Autor::class,Libro::class,Tags::class,LibroTagJoin::class],version = 1,exportSchema = false)
abstract class RoomDB: RoomDatabase(){
    abstract fun autorDao(): AutorDao
    abstract fun libroDao(): LibroDao
    abstract fun tagDao(): TagsDao
    abstract fun LibroTagJoinDao(): LibroTagJoinDao

    companion object {
        private var INSTANCE: RoomDB? = null
        fun getIntace(Appcontext: Context): RoomDB{
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(Appcontext,RoomDB::class.java, "LibroDB").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}