package run.budgetbuddy.activities

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import models.ItemGenerico
import run.budgetbuddy.R
import run.budgetbuddy.adapter.myListAdapter
import run.budgetbuddy.databinding.ActivityAjustesBinding

class Ajustes : AppCompatActivity() {

    private lateinit var adapterList: myListAdapter
    private lateinit var list_view: ListView
    private lateinit var listaOpciones: MutableList<ItemGenerico>
    private var posActual: Int = 0
    lateinit var binding: ActivityAjustesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAjustesBinding.inflate(layoutInflater)
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

        list_view = binding.listView
        adapterList = myListAdapter(this, R.layout.custom_list_ajustes, listaOpciones)
        list_view.adapter = adapterList
        registerForContextMenu(list_view)
    }

    private fun crearAjustes(): MutableList<ItemGenerico> {

        val listaAjustes = mutableListOf<ItemGenerico>(

            ItemGenerico("Idioma", "Español", R.drawable.idioma),
            ItemGenerico("Periodo por defecto", "Semanal", R.drawable.calendario),
            ItemGenerico("Redondeo", "Sin redondear", R.drawable.decimal),
            ItemGenerico("Tema por defecto", "Predeterminado", R.drawable.tema),
            ItemGenerico("Pantalla inicio", "Mis Gastos ", R.drawable.individual),
            ItemGenerico("Pantalla inicial MyGestor", "Semanal", R.drawable.group),
            ItemGenerico(
                "Eliminar datos", "Borrar todos los datos", R.drawable.eliminar
            )

        )

        return listaAjustes
    }

    @SuppressLint("InflateParams")
    fun abrirOpcion() {

        list_view.setOnItemClickListener() { adapterView, view, position, id ->

            var opcion = position
            when (opcion) {
                0 -> {
                    val builder = AlertDialog.Builder(this)
                    val inflater = layoutInflater
                    builder.setView(inflater.inflate(R.layout.dialog_idioma, null))

                    builder.show()
                }

                1 -> {
                    val builder = AlertDialog.Builder(this)
                    val inflater = layoutInflater
                    builder.setView(inflater.inflate(R.layout.dialog_periodo, null))

                    builder.show()


                }

                3 -> {
                    val builder = AlertDialog.Builder(this)
                    val inflater = layoutInflater
                    builder.setView(inflater.inflate(R.layout.dialog_tema, null))

                    builder.show()


                }

                4 -> {
                    val builder = AlertDialog.Builder(this)
                    val inflater = layoutInflater
                    builder.setView(inflater.inflate(R.layout.dialog_cambio_inicio, null))

                    builder.show()


                }

                5 -> {
                    val builder = AlertDialog.Builder(this)
                    val inflater = layoutInflater
                    builder.setView(inflater.inflate(R.layout.dialog_info_inicio, null))

                    builder.show()

                }

                6 -> {
                    val builder = AlertDialog.Builder(this)
                    val inflater = layoutInflater
                    builder.setView(inflater.inflate(R.layout.dialog_borrar_datos, null))

                    builder.create()
                    builder.show()

                }

            }
        }
        registerForContextMenu(list_view)
    }
}