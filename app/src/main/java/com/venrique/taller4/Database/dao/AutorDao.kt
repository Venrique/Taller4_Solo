package com.venrique.taller4.Database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.venrique.taller4.Database.Autor

@Dao
interface AutorDao {

    @Insert
    suspend fun insert(autor: Autor)

    @Query("DELETE from autor")
    fun deleteAll()

    @Query("DELETE from autor where Aid=:id")
    fun deleteOne(id:Int)

    @Query("SELECT * from autor")
    fun selectAll()

    @Query("SELECT * from autor where Aid=:id")
    fun selectOne(id: Int)
}