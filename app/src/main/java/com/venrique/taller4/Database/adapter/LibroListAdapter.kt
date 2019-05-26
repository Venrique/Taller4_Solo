package com.venrique.taller4.Database.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.venrique.taller4.Database.Entities.Libro
import com.venrique.taller4.R
import kotlinx.android.synthetic.main.book_list.view.*

class LibroListAdapter: RecyclerView.Adapter<LibroListAdapter.LibrosViewHolder>(), View.OnClickListener{

    override fun onClick(v: View?) {
        if(listener!=null){
            listener?.onClick(v)
        }
    }

    private var Libros = emptyList<Libro>()
    private var listener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibrosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_list,parent,false)
        view.setOnClickListener(this)
        return LibrosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Libros.size
    }

    fun setOnClickListener(listener: View.OnClickListener){
        this.listener = listener
    }

    override fun onBindViewHolder(holder: LibrosViewHolder, position: Int) {
        val current = Libros[position]

        holder.txtNombre.text = current.name
    }

    internal fun setLibros(libros: List<Libro>){
        this.Libros = libros
        notifyDataSetChanged()
        Log.d("LISTA CAMBIO","SI")
    }

    class LibrosViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        val txtNombre: TextView = itemView.findViewById(R.id.libro_name)

    }
}