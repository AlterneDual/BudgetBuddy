package run.budgetbuddy.activities.ajustes

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.RadioButton
import android.widget.Toast
import models.ItemGenerico
import run.budgetbuddy.R
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.adapter.myListAdapter
import run.budgetbuddy.databinding.ActivityAjustesBinding
import java.util.*

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
            ItemGenerico("Tema por defecto", "Predeterminado", R.drawable.tema),
            ItemGenerico("Pantalla inicio", "Mis Gastos ", R.drawable.individual),
            ItemGenerico("Pantalla inicial MyGestor", "Semanal", R.drawable.group),
            ItemGenerico("Eliminar datos", "Borrar todos los datos", R.drawable.eliminar)
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
                    val dialogLayout = inflater.inflate(R.layout.dialog_idioma, null)
                    builder.setView(dialogLayout)
                    val dialog = builder.create()

                    val btnEspañol = dialogLayout.findViewById<RadioButton>(R.id.rbEspañol)
                    val btnIngles = dialogLayout.findViewById<RadioButton>(R.id.rbEnglish)
                    val btnAceptar = dialogLayout.findViewById<Button>(R.id.btnAceptarr)
                    val btnCancelar = dialogLayout.findViewById<Button>(R.id.btnCancelar)
                    btnAceptar.setOnClickListener{
                        if(btnEspañol.isChecked){
                            val toast = Toast.makeText(applicationContext, "Español seleccionado", Toast.LENGTH_SHORT)
                            toast.show()
                            setLocale(this, "es")
                            finish()
                            startActivity(intent)

                        }else if(btnIngles.isChecked){
                            val toast = Toast.makeText(applicationContext, "Ingles seleccionado", Toast.LENGTH_SHORT)
                            toast.show()
                            setLocale(this, "en")
                            finish()
                            startActivity(intent)
                        }
                        dialog.dismiss()
                    }
                    btnCancelar.setOnClickListener{
                        dialog.dismiss()
                    }
                    dialog.show()
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

    fun setLocale(activity: Activity, langCode: String) {
        val locale = Locale(langCode)
        Locale.setDefault(locale)
        val resources = activity.resources
        val configuration = resources.configuration
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}