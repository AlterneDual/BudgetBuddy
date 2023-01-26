package run.budgetbuddy.activities.divisa

import adapter.myListAdapter_menu_Lateral
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import models.ItemGenerico
import run.budgetbuddy.R
import run.budgetbuddy.activities.Ajustes
import run.budgetbuddy.activities.MG.MgInicio
import run.budgetbuddy.activities.MenuLateralMG
import run.budgetbuddy.databinding.ActivityDivisasBinding

class Divisas : AppCompatActivity() {

    private lateinit var adapterList: myListAdapter_menu_Lateral
    private lateinit var list_view: ListView
    private lateinit var listaOpciones: MutableList<ItemGenerico>
    private var posActual: Int = 0
    private lateinit var binding: ActivityDivisasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDivisasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaOpciones = crearAjustes()

        inicializarAdapter()

        abrirOpcion()

        binding.btnMenu.setOnClickListener {
            val intent = Intent(this, MenuLateralMG::class.java)
            startActivity(intent)
            finish()
        }


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