package run.budgetbuddy.activities.categoria

import adapter.myListAdapter_categorias
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import models.Categoria
import run.budgetbuddy.R
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.databinding.CategoriasBinding

class Categorias : AppCompatActivity() {
    private lateinit var binding: CategoriasBinding
    private lateinit var adapterList: myListAdapter_categorias
    private lateinit var grid_view: GridView
    private lateinit var listaIconos: MutableList<Categoria>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaIconos = crearIconos()
        inicializarAdapter()

        binding.btnAddCategoria2.setOnClickListener {
            val intent = Intent(this, AddCategoria::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAtras1.setOnClickListener {
            val intent = Intent(this,MenuLateralMG::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun inicializarAdapter() {

        grid_view = binding.GVCategoria
        adapterList = myListAdapter_categorias(this, R.layout.custom_grid_categorias, listaIconos)
        grid_view.adapter = adapterList
        registerForContextMenu(grid_view)
    }

    private fun crearIconos(): MutableList<Categoria> {

        val listaCategorias = mutableListOf<Categoria>(

            Categoria("Avion", 0, R.drawable.cat_avion),
            Categoria("Cine", 0, R.drawable.cat_cine),
            Categoria("Bolos", 0, R.drawable.cat_bolos),
            Categoria("Coctel", 0, R.drawable.cat_coctel),
            Categoria("Compras", 0, R.drawable.cat_compras1),
            Categoria("Compras", 0, R.drawable.cat_compras2),
            Categoria("Compras", 0, R.drawable.cat_compras3),
            Categoria("Compras", 0, R.drawable.cat_compras4),
            Categoria("Compras", 0, R.drawable.cat_hotel),
            Categoria("Compras", 0, R.drawable.cat_limpieza),
            Categoria("Compras", 0, R.drawable.cat_regalo),
            Categoria("Compras", 0, R.drawable.cat_restaurante),
            Categoria("Compras", 0, R.drawable.cat_videojuego)

        )

        return listaCategorias
    }
}