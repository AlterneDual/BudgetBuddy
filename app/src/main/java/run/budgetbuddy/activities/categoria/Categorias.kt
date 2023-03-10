package run.budgetbuddy.activities.categoria

import CRUD.CategoriaCRUD
import adapter.myListAdapter_categorias
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import models.Categoria
import run.budgetbuddy.R
import run.budgetbuddy.activities.MG.MgInicio
import run.budgetbuddy.activities.ajustes.Ajustes
import run.budgetbuddy.databinding.CategoriasBinding

class Categorias : AppCompatActivity() {
    private lateinit var binding: CategoriasBinding
    private lateinit var adapterList: myListAdapter_categorias
    private lateinit var grid_view: GridView
    private lateinit var listaCategorias: MutableList<Categoria>
    var categoriaCRUD: CategoriaCRUD = CategoriaCRUD()
    private var posicion: Int = 0

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
        binding = CategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //-------------------------------------------Menu lateral-------------------------------------------
        //Inicializar drawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Declarar la toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar3)

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

        listaCategorias = categoriaCRUD.getAllCategoria()
        inicializarAdapter()

        binding.btnAddCategoria2.setOnClickListener {
            val intent = Intent(this, CrearCategoria::class.java)
            startActivity(intent)
        }

    }

    private fun inicializarAdapter() {

        grid_view = binding.GVCategoria
        adapterList = myListAdapter_categorias(this, R.layout.custom_grid_categorias, listaCategorias)
        grid_view.adapter = adapterList
        registerForContextMenu(grid_view)
    }

    private fun crearCategorias(): MutableList<Categoria> {

        val listaCategorias = mutableListOf<Categoria>(

            Categoria("Avion", R.drawable.circulo_naranja, R.drawable.cat_avion, "#FF9D0A"),
            Categoria("Cine", R.drawable.circulo_verde, R.drawable.cat_cine, "#2ACD1B"),
            Categoria("Bolos", R.drawable.circulo_rojo, R.drawable.cat_bolos, "#EF5757"),
            Categoria("Coctel", R.drawable.circulo_amarillo, R.drawable.cat_coctel, "#F4D35E"),
            Categoria("Compras", R.drawable.circulo_turquesa, R.drawable.cat_compras, "#00ffff"),
            Categoria("Hotele", R.drawable.circulo_celeste, R.drawable.cat_hotel, "##97b5fe"),
            Categoria("Limpieza", R.drawable.circulo_azul, R.drawable.cat_limpieza, "#010efe"),
            Categoria("Regalos", R.drawable.circulo_rosa, R.drawable.cat_regalo, "#f610fe"),
            Categoria(
                "Restaurante",
                R.drawable.circulo_celeste,
                R.drawable.cat_restaurante,
                "#97b5fe"
            ),
            Categoria(
                "Videojuegos",
                R.drawable.circulo_naranja,
                R.drawable.cat_videojuego,
                "#FF9D0A"
            )

        )

        return listaCategorias
    }

    private fun vaciar_bd_categorias() {
        for (categoria in categoriaCRUD.getAllCategoria()) {
            categoriaCRUD.deleteCategoria(categoria.id)
        }
    }

    private fun rellenar_bd_categorias(){
        if(categoriaCRUD.getAllCategoria().isEmpty()){
            for(categoria in listaCategorias){
                categoriaCRUD.addCategoria(categoria)
            }
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        posicion = info.position
        menu?.setHeaderTitle(listaCategorias[posicion!!].nombre)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        posicion = info.position

        return when (item.itemId) {
            R.id.eliminar -> {
                val dialogo = AlertDialog.Builder(this)
                    .setTitle("Eliminar " + listaCategorias[posicion!!].nombre)
                    .setMessage("¿Estás seguro de que quieres eliminar " + listaCategorias[posicion!!].nombre + "?")
                    .setPositiveButton("ACEPTAR")
                    { dialogInterface, i ->
                        categoriaCRUD.deleteCategoria(listaCategorias[posicion!!].id)
                        adapterList.notifyDataSetChanged()
                        recargarBDD()}
                    .setNegativeButton("CANCELAR") { dialogInterface, i -> dialogInterface.cancel() }
                    .create()
                dialogo.show()

                true


            }

            else -> super.onContextItemSelected(item)
        }
    }

    private fun recargarBDD(): Boolean {
        listaCategorias.clear()
        listaCategorias.addAll(categoriaCRUD.getAllCategoria())
        adapterList.notifyDataSetChanged()
        Toast.makeText(this, "Has recargado la lista", Toast.LENGTH_SHORT).show()
        return true
    }
}