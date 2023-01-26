package com.example.mygestorplantillas

import adapter.myListAdapter_menu_Lateral
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import models.ItemGenerico
import run.budgetbuddy.R

class Divisas : AppCompatActivity() {

    private lateinit var adapterList: myListAdapter_menu_Lateral
    private lateinit var list_view: ListView
    private lateinit var listaOpciones: MutableList<ItemGenerico>
    private var posActual: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_divisas)

        listaOpciones = crearAjustes()

        inicializarAdapter()

        abrirOpcion()


    }

    private fun inicializarAdapter() {

        list_view = findViewById<ListView>(R.id.list_view)
        adapterList = myListAdapter_menu_Lateral(this, R.layout.custom_list_divisas, listaOpciones)
        list_view.adapter = adapterList
        registerForContextMenu(list_view)
    }

    private fun crearAjustes(): MutableList<ItemGenerico> {

        val listaAjustes = mutableListOf<ItemGenerico>(

            ItemGenerico("EURO", "", R.drawable.euro),
            ItemGenerico("DOLAR", "", R.drawable.dolar),
            ItemGenerico("LIBRA", "", R.drawable.libra)

        )

        return listaAjustes
    }

    fun abrirOpcion() {

        list_view.setOnItemClickListener() { adapterView, view, position, id ->

            var opcion = position
            when (opcion) {
                0 -> {


                }

                1 -> {


                }

                3 -> {


                }

            }
        }
        registerForContextMenu(list_view)
    }
}