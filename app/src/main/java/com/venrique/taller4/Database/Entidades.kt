package com.venrique.taller4.Database

import androidx.room.*

@Entity(tableName = "autor")
data class Autor(@ColumnInfo(name="autor_name") val name: String, @ColumnInfo(name = "country") val country: String){
    @PrimaryKey(autoGenerate = true)
    var Aid:Long = 0
}

@Entity(tableName = "book")
data class Libro(@ColumnInfo(name="book_name") val name: String, @ColumnInfo(name = "country") val country: String){
    @PrimaryKey(autoGenerate = true)
    var Bid:Long = 0
    val autor: String = ""
}

@Entity(foreignKeys = arrayOf(ForeignKey(entity = Libro::class,
    parentColumns = arrayOf("Bid"),
    childColumns = arrayOf("Tid"),
    onDelete = ForeignKey.CASCADE)), tableName = "tags")

data class Tags(@ColumnInfo(name="tag_name") val name: String){
    @PrimaryKey(autoGenerate = true)
    var Tid:Long = 0
}