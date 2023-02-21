package run.budgetbuddy.activities.menu

import adapter.myListAdapter_menu_Lateral
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import run.budgetbuddy.activities.ajustes.Ajustes
import run.budgetbuddy.activities.divisa.Divisas
import models.ItemGenerico
import run.budgetbuddy.R
import run.budgetbuddy.activities.MG.MgInicio
import run.budgetbuddy.activities.app.Register
import run.budgetbuddy.activities.categoria.Categorias

class MenuLateralMG : AppCompatActivity() {

    private lateinit var adapterList: myListAdapter_menu_Lateral
    private lateinit var list_view: ListView
    private lateinit var listaOpciones: MutableList<ItemGenerico>
    private var posActual: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_lateral_1)

        listaOpciones = crearAjustes()
        inicializarAdapter()
        abrirOpcion()

    }

    private fun inicializarAdapter() {

        list_view = findViewById<ListView>(R.id.listView_menu)
        adapterList =
            myListAdapter_menu_Lateral(this, R.layout.custom_list_menu_lateral, listaOpciones)
        list_view.adapter = adapterList
        registerForContextMenu(list_view)
    }

    private fun crearAjustes(): MutableList<ItemGenerico> {

        val listaAjustes = mutableListOf<ItemGenerico>(

            ItemGenerico("Home", "", R.drawable.home),
            ItemGenerico("Editar Categorias", "", R.drawable.editar),
            ItemGenerico("Divisa", "", R.drawable.divisa),
            ItemGenerico("Ajustes", "", R.drawable.ajustes),
            ItemGenerico("Registro", "", R.drawable.group)

        )

        return listaAjustes
    }

    fun abrirOpcion() {

        list_view.setOnItemClickListener() { adapterView, view, position, id ->

            var opcion = position
            when (opcion) {
                0 -> {
                    val intent = Intent(this, MgInicio::class.java)
                    startActivity(intent)
                }

                1 -> {
                    val intent = Intent(this, Categorias::class.java)
                    startActivity(intent)

                }

                2 -> {
                    val intent = Intent(this, Divisas::class.java)
                    startActivity(intent)
                }

                3 -> {
                    val intent = Intent(this, Ajustes::class.java)
                    startActivity(intent)

                }

                4 -> {
                   val intent = Intent(this, Register::class.java)
                  startActivity(intent)
                   finish()

                }

            }
        }
        registerForContextMenu(list_view)
    }

}