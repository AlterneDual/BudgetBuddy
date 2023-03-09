package run.budgetbuddy.activities.ajustes

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ListView
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import models.ItemGenerico
import run.budgetbuddy.R
import run.budgetbuddy.activities.MG.MgInicio
import run.budgetbuddy.activities.categoria.Categorias
import run.budgetbuddy.adapter.myListAdapter
import run.budgetbuddy.databinding.ActivityAjustesBinding
import run.budgetbuddy.databinding.DialogInfoInicioBinding
import run.budgetbuddy.model.languageEnable
import java.util.*

class Ajustes : AppCompatActivity() {

    private lateinit var adapterList: myListAdapter
    private lateinit var list_view: ListView
    private lateinit var listaOpciones: MutableList<ItemGenerico>
    private var posActual: Int = 0
    lateinit var binding: ActivityAjustesBinding
    lateinit var binding_info_inicio: DialogInfoInicioBinding
    private var trabajar_ingresos = 1

    //----------------------------------Atributos y metodos Menu lateral----------------------------------
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    //----------------------------------Atributos y metodos Menu lateral----------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAjustesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //-------------------------------------------Menu lateral-------------------------------------------
        //Inicializar drawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Declarar la toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        // Configurar la toolbar
        setSupportActionBar(toolbar)

        // Agregar el icono de hamburguesa y quitar titulo
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menu_button)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // El icono menu abre el desplegable
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val menu = navigationView.menu
        val nav_home1 = menu.findItem(R.id.nav_home)
        val nav_cat1 = menu.findItem(R.id.nav_edit_cat)
        val nav_ajustes1 = menu.findItem(R.id.nav_ajustes)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                nav_home1.itemId -> {
                    val intent = Intent(this, MgInicio::class.java)
                    startActivity(intent)
                    true
                }

                nav_cat1.itemId -> {
                    val intent = Intent(this, Categorias::class.java)
                    startActivity(intent)
                    true
                }

                nav_ajustes1.itemId -> {
                    val intent = Intent(this, Ajustes::class.java)
                    startActivity(intent)
                    true
                }

                else -> false

            }
        }


        //-------------------------------------------Menu lateral-------------------------------------------


        listaOpciones = crearAjustes(trabajar_ingresos)
        inicializarAdapter()
        abrirOpcion()
    }

    private fun inicializarAdapter() {

        list_view = binding.listView
        adapterList = myListAdapter(this, R.layout.custom_list_ajustes, listaOpciones)
        list_view.adapter = adapterList
        registerForContextMenu(list_view)
    }

    private fun crearAjustes(value: Int): MutableList<ItemGenerico> {
        var listaAjustes = mutableListOf<ItemGenerico>()
        var idioma = ""
        if (languageEnable.spanishEnable) idioma = "Español"
        else idioma = "English"
        if (value == 0) {
            listaAjustes = mutableListOf<ItemGenerico>(

                ItemGenerico("Idioma", idioma, R.drawable.idioma),
//            ItemGenerico("Tema por defecto", "Predeterminado", R.drawable.tema),
//                ItemGenerico("Pantalla inicio", "Mis Gastos ", R.drawable.individual),
                ItemGenerico("Ver el saldo de mi cuenta", "Activado", R.drawable.group),
                ItemGenerico("Eliminar datos", "Borrar todos los datos", R.drawable.eliminar)
            )
        } else {
            listaAjustes = mutableListOf<ItemGenerico>(

                ItemGenerico("Idioma", idioma, R.drawable.idioma),
//            ItemGenerico("Tema por defecto", "Predeterminado", R.drawable.tema),
//                ItemGenerico("Pantalla inicio", "Mis Gastos ", R.drawable.individual),
                ItemGenerico("Ver el saldo de mi cuenta", "Desactivado", R.drawable.group),
                ItemGenerico("Eliminar datos", "Borrar todos los datos", R.drawable.eliminar)
            )
        }

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
                    var enableEspañol = null

                    if (languageEnable.spanishEnable){
                        btnEspañol.isChecked = true
                        btnIngles.isChecked = false
                    } else{
                        btnEspañol.isChecked = false
                        btnIngles.isChecked = true
                    }

                    btnAceptar.setOnClickListener {
                        if (btnEspañol.isChecked) {
                            val toast = Toast.makeText(
                                applicationContext,
                                "Español seleccionado",
                                Toast.LENGTH_SHORT
                            )
                            toast.show()
                            languageEnable.spanishEnable = true
                            setLocale(this, "es")
                            finish()
                            startActivity(intent)

                        } else if (btnIngles.isChecked) {
                            val toast = Toast.makeText(
                                applicationContext,
                                "Ingles seleccionado",
                                Toast.LENGTH_SHORT
                            )
                            toast.show()
                            languageEnable.spanishEnable = false
                            btnIngles.isChecked = true
                            btnEspañol.isChecked = false
                            setLocale(this, "en")
                            finish()
                            startActivity(intent)
                        }
                        dialog.dismiss()
                    }
                    btnCancelar.setOnClickListener {
                        dialog.dismiss()
                    }
                    dialog.show()
                }

//                3 -> {
//                    val builder = AlertDialog.Builder(this)
//                    val inflater = layoutInflater
//                    builder.setView(inflater.inflate(R.layout.dialog_tema, null))
//
//                    builder.show()
//
//
//                }

//                4 -> {
//                    val builder = AlertDialog.Builder(this)
//                    val inflater = layoutInflater
//                    builder.setView(inflater.inflate(R.layout.dialog_cambio_inicio, null))
//
//                    builder.show()
//
//
//                }

                1 -> {
                    val builder = AlertDialog.Builder(this)
                    val inflater = layoutInflater
                    builder.setView(inflater.inflate(R.layout.dialog_info_inicio, null))
                    builder.show()

//                    binding_info_inicio.btnActivar.setOnClickListener {
//                        trabajar_ingresos = 0
//                    }
//                    binding_info_inicio.btnDesactivar.setOnClickListener {
//                        trabajar_ingresos = 1
//                    }
                }

                2 -> {
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