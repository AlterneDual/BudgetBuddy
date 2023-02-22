package run.budgetbuddy.activities.divisa

import adapter.myListAdapter_menu_Lateral
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import models.ItemGenerico
import run.budgetbuddy.R
import run.budgetbuddy.activities.MG.MgInicio
import run.budgetbuddy.activities.ajustes.Ajustes
import run.budgetbuddy.activities.categoria.Categorias
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.databinding.ActivityDivisasBinding

class Divisas : AppCompatActivity() {

    private lateinit var adapterList: myListAdapter_menu_Lateral
    private lateinit var list_view: ListView
    private lateinit var listaOpciones: MutableList<ItemGenerico>
    private var posActual: Int = 0
    private lateinit var binding: ActivityDivisasBinding

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
        binding = ActivityDivisasBinding.inflate(layoutInflater)
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