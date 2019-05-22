package com.venrique.taller4.Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "book",
    foreignKeys = arrayOf(ForeignKey(entity = Autor::class,parentColumns = arrayOf("Aid"),childColumns = arrayOf("autor_id"),onDelete = ForeignKey.CASCADE)))
data class Libro(@ColumnInfo(name="book_name") val name: String,
                 @ColumnInfo(name = "language") val lang: String,
                 @ColumnInfo(name = "editorial") val editorial: String,
                 @ColumnInfo(name = "autor_id") val autor: Int){
    @PrimaryKey(autoGenerate = true)
    var Bid:Int = 0
}