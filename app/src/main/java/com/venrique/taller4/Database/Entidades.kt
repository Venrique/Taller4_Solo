package com.venrique.taller4.Database

import android.nfc.Tag
import androidx.room.*

@Entity(tableName = "autor")
data class Autor(@ColumnInfo(name="autor_name") val name: String, @ColumnInfo(name = "country") val country: String){
    @PrimaryKey(autoGenerate = true)
    var Aid:Int = 0
}

@Entity(tableName = "book",
    foreignKeys = arrayOf(ForeignKey(entity = Autor::class,parentColumns = arrayOf("Aid"),childColumns = arrayOf("autor_id"),onDelete = ForeignKey.CASCADE)))
data class Libro(@ColumnInfo(name="book_name") val name: String,
                 @ColumnInfo(name = "language") val lang: String,
                 @ColumnInfo(name = "editorial") val editorial: String,
                 @ColumnInfo(name = "autor_id") val autor: Int){
    @PrimaryKey(autoGenerate = true)
    var Bid:Int = 0
}

@Entity( tableName = "tags")
data class Tags(@ColumnInfo(name="tag_name") val name: String){
    @PrimaryKey(autoGenerate = true)
    var Tid:Long = 0
}

@Entity(tableName = "book_tag_join",foreignKeys = arrayOf(ForeignKey(entity = Libro::class,parentColumns = arrayOf("Bid"),childColumns = arrayOf("bookId")),
    ForeignKey(entity = Tags::class,parentColumns = arrayOf("Tid"),childColumns = arrayOf("tagId"))))
data class LibroTagJoin(@ColumnInfo(name = "bookId") @PrimaryKey val bookId: Int,
                        @ColumnInfo(name = "tagId") @PrimaryKey val tagId: Int)