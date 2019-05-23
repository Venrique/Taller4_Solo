package com.venrique.taller4.Database.dao

import android.nfc.Tag
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TagsDao {

    @Insert
    suspend fun insert(tag: Tag)

    @Query("SELECT * from tags")
    fun getAllTags()

    @Query("SELECT * from tags where Tid=:id")
    fun getOneTag(id: Int)
}