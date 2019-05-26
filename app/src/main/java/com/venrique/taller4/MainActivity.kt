package com.venrique.taller4

import android.content.Intent
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.venrique.taller4.Database.Entities.Autor
import com.venrique.taller4.Database.Entities.Libro
import com.venrique.taller4.Database.Entities.LibroTagJoin
import com.venrique.taller4.Database.Entities.Tags
import com.venrique.taller4.Fragments.LibroDetailFragment
import com.venrique.taller4.Fragments.LibroListaFragment
import com.venrique.taller4.ViewModel.LibrosViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LibroListaFragment.OnFragmentInteractionListener, LibroDetailFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var listaFragment: LibroListaFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        listaFragment = LibroListaFragment()
        supportFragmentManager.beginTransaction().replace(R.id.contenedorFragment,listaFragment).commit()


        fab.setOnClickListener { view ->
            val intent = Intent(this,NewBookActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
