package com.venrique.taller4.Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "autor")
data class Autor(@PrimaryKey @ColumnInfo(name="Aid") val Aid: Int, @ColumnInfo(name="autor_name") val name: String, @ColumnInfo(name = "country") val country: String)