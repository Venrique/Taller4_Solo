package com.venrique.taller4.Repository

import android.nfc.Tag
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.venrique.taller4.Database.Entities.Autor
import com.venrique.taller4.Database.Entities.Libro
import com.venrique.taller4.Database.Entities.LibroTagJoin
import com.venrique.taller4.Database.Entities.Tags
import com.venrique.taller4.Database.dao.AutorDao
import com.venrique.taller4.Database.dao.LibroDao
import com.venrique.taller4.Database.dao.LibroTagJoinDao
import com.venrique.taller4.Database.dao.TagsDao

class LibroRepository(private val autorDao: AutorDao,private val libroDao: LibroDao,private val tagsDao: TagsDao, private val libroTagJoinDao: LibroTagJoinDao) {

    // Opciones del autor
    @WorkerThread
    suspend fun insertAutor(autor: Autor){
        autorDao.insert(autor)
    }

    fun destroyAutors(){
        autorDao.deleteAll()
    }

    fun selectAutor(autor: Int){
        autorDao.selectOne(autor)
    }

    fun selectAllAutors(): LiveData<List<Autor>>{
        return autorDao.selectAll()
    }

    // Opciones del tag
    @WorkerThread
    suspend fun insertTag(tag: Tags){
        tagsDao.insert(tag)
    }

    fun getTag(tagId: Int){
        tagsDao.getOneTag(tagId)
    }

    // Opciones del libro
    @WorkerThread
    suspend fun insertLibro(libro: Libro){
        libroDao.insert(libro)
    }

    fun getAllBooks(): LiveData<List<Libro>>{
        return libroDao.getAllBooks()
    }

    fun getBookByAutor(autor: Int){
        libroDao.getBookByAutor(autor)
    }

    fun getBookByName(libro: String){
        libroDao.getBookByName(libro)
    }

    fun deleteBooks(){
        libroDao.deleteBook()
    }

    // Opciones del libro y tag
    fun getBooksByTag(tagId: Int){
        libroTagJoinDao.getBooksByTag(tagId)
    }

    @WorkerThread
    suspend fun insertBookTagRelation(relation: LibroTagJoin){
        libroTagJoinDao.insert(relation)
    }
}