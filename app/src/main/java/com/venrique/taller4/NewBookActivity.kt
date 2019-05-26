package com.venrique.taller4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.venrique.taller4.Database.Entities.Libro
import com.venrique.taller4.ViewModel.LibrosViewModel

class NewBookActivity : AppCompatActivity() {

    private lateinit var btnGuardar: Button
    private lateinit var nombre: EditText
    private lateinit var lenguaje: EditText
    private lateinit var editorial: EditText
    private lateinit var autor: EditText
    private lateinit var tag: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)

        btnGuardar = findViewById(R.id.btn_Save)
        nombre = findViewById(R.id.et_nombre)
        lenguaje = findViewById(R.id.et_idioma)
        editorial = findViewById(R.id.et_editorial)
        autor = findViewById(R.id.et_autor)
        tag = findViewById(R.id.et_tag)

        val viewModel = ViewModelProviders.of(this).get(LibrosViewModel::class.java)
        var cantidad = 0

        viewModel.getBooks().observe(this, Observer { libros->
            cantidad = libros.size
        })

        btnGuardar.setOnClickListener {

            Log.d("LISTA DE REPOS",cantidad.toString())

            viewModel.insertLibro(Libro(cantidad,nombre.text.toString(),lenguaje.text.toString(),editorial.text.toString(),autor.text.toString().toInt()))
        }

    }
}
