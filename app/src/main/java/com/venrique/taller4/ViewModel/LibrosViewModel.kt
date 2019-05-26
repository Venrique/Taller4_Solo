package com.venrique.taller4.ViewModel

import android.app.Application
import android.nfc.Tag
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.venrique.taller4.Database.Entities.Autor
import com.venrique.taller4.Database.Entities.Libro
import com.venrique.taller4.Database.Entities.LibroTagJoin
import com.venrique.taller4.Database.Entities.Tags
import com.venrique.taller4.Database.RoomDB
import com.venrique.taller4.Repository.LibroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LibrosViewModel(app: Application): AndroidViewModel(app) {

    private val repository: LibroRepository

    init {
        val autorDao = RoomDB.getDatabase(app,viewModelScope).autorDao()
        val tagDao = RoomDB.getDatabase(app,viewModelScope).tagDao()
        val libroDao = RoomDB.getDatabase(app,viewModelScope).libroDao()
        val libroTagDao = RoomDB.getDatabase(app,viewModelScope).LibroTagJoinDao()

        repository = LibroRepository(autorDao,libroDao,tagDao,libroTagDao)
    }

    //Autor
    fun insertAutor(autor: Autor) = viewModelScope.launch(Dispatchers.IO){
        repository.insertAutor(autor)
    }

    fun checkAutor(autor:Int) = repository.selectAutor(autor)

    fun deleteAutors() = repository.destroyAutors()

    fun selectAll(): LiveData<List<Autor>> = repository.selectAllAutors()

    //Tags
    fun insertTag(tag: Tags) = viewModelScope.launch(Dispatchers.IO){
        repository.insertTag(tag)
    }

    fun checkTag(tag:Int) = repository.getTag(tag)

    //Libro
    fun insertLibro(libro: Libro) = viewModelScope.launch(Dispatchers.IO){
        repository.insertLibro(libro)
    }
    fun getOneBook(libro:String) = repository.getBookByName(libro)

    fun getBookByAutor(autor: Int) = repository.getBookByAutor(autor)

    fun deleteBooks() = repository.deleteBooks()

    fun getBooks(): LiveData<List<Libro>> = repository.getAllBooks()

    //LibroTagJoin
    fun insertRel(rel: LibroTagJoin) = viewModelScope.launch(Dispatchers.IO){
        repository.insertBookTagRelation(rel)
    }

    fun getBooksByTag(tag: Int) = repository.getBooksByTag(tag)
}