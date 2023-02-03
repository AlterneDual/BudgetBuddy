package run.budgetbuddy.activities.categoria

import CRUD.CategoriaCRUD
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
    private lateinit var listaCategorias: MutableList<Categoria>
    var categoriaCRUD: CategoriaCRUD = CategoriaCRUD()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaCategorias = crearCategorias()
        rellenar_bd_categorias()

        listaCategorias = categoriaCRUD.getAllCategoria()
        inicializarAdapter()

        binding.btnAddCategoria2.setOnClickListener {
            val intent = Intent(this, CrearCategoria::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAtras1.setOnClickListener {
            val intent = Intent(this, MenuLateralMG::class.java)
            startActivity(intent)
            finish()
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

            Categoria("Avion", R.drawable.circulo_naranja, R.drawable.cat_avion),
            Categoria("Cine", R.drawable.circulo_verde, R.drawable.cat_cine),
            Categoria("Bolos", R.drawable.circulo_rojo, R.drawable.cat_bolos),
            Categoria("Coctel", R.drawable.circulo_amarillo, R.drawable.cat_coctel),
            Categoria("Compras", R.drawable.circulo_turquesa, R.drawable.cat_compras),
            Categoria("Hotele", R.drawable.circulo_celeste, R.drawable.cat_hotel),
            Categoria("Limpieza", R.drawable.circulo_azul, R.drawable.cat_limpieza),
            Categoria("Regalos", R.drawable.circulo_rosa, R.drawable.cat_regalo),
            Categoria("Restaurante", R.drawable.circulo_celeste, R.drawable.cat_restaurante),
            Categoria("Videojuegos", R.drawable.circulo_naranja, R.drawable.cat_videojuego)

        )

        return listaCategorias
    }

    private fun vaciar_bd_categorias(){
        for(categoria in categoriaCRUD.getAllCategoria()){
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
}