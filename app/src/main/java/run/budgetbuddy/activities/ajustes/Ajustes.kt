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
import run.budgetbuddy.activities.divisa.Divisas
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

    //----------------------------------Atributos y metodos Menu lateral----------------------------------
    lateinit var drawerLayout : DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
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
        val nav_div1 = menu.findItem(R.id.nav_divisa)
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
                nav_div1.itemId -> {
                    val intent = Intent(this, Divisas::class.java)
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



        listaOpciones = crearAjustes()

        inicializarAdapter()

        abrirOpcion()


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