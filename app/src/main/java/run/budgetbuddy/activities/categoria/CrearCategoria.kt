package run.budgetbuddy.activities.categoria

import adapter.myListAdapter_categorias
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import models.ItemGenerico
import run.budgetbuddy.R
import run.budgetbuddy.databinding.CrearCategoriaBinding

class CrearCategoria : AppCompatActivity() {
    private lateinit var binding: CrearCategoriaBinding
    private lateinit var adapterList: myListAdapter_categorias
    private lateinit var grid_view: GridView
    private lateinit var listaIconos: MutableList<ItemGenerico>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CrearCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaIconos = crearIconos()
        inicializarAdapter()

        binding.btnAnadir2.setOnClickListener {

            SystemClock.sleep(5000)
            Toast.makeText(
                this,
                "Se ha añadido una Categoria",
                Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, Categorias::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, AddCategoria::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun inicializarAdapter() {

        grid_view = findViewById<GridView>(R.id.grid_view)
        adapterList = myListAdapter_categorias(this, R.layout.custom_grid_categorias, listaIconos)
        grid_view.adapter = adapterList
        registerForContextMenu(grid_view)
    }

    private fun crearIconos(): MutableList<ItemGenerico> {

        val listaAjustes = mutableListOf<ItemGenerico>(

            ItemGenerico("", "", R.drawable.cat_avion),
            ItemGenerico("", "", R.drawable.cat_cine),
            ItemGenerico("", "", R.drawable.cat_bolos),
            ItemGenerico("", "", R.drawable.cat_coctel),
            ItemGenerico("", "", R.drawable.cat_compras1),
            ItemGenerico("", "", R.drawable.cat_compras2),
            ItemGenerico("", "", R.drawable.cat_compras3),
            ItemGenerico("", "", R.drawable.cat_compras4),
            ItemGenerico("", "", R.drawable.cat_hotel),
            ItemGenerico("", "", R.drawable.cat_limpieza),
            ItemGenerico("", "", R.drawable.cat_regalo),
            ItemGenerico("", "", R.drawable.cat_restaurante),
            ItemGenerico("", "", R.drawable.cat_videojuego)


        )

        return listaAjustes
    }
}