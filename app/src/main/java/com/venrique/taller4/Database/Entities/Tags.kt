package com.venrique.taller4.Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "tags")
data class Tags(@ColumnInfo(name="tag_name") val name: String){
    @PrimaryKey(autoGenerate = true)
    var Tid:Long = 0
}