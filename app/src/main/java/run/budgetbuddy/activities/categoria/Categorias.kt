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
import androidx.appcompat.app.AlertDialog
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
    private var posicion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaCategorias = categoriaCRUD.getAllCategoria()
        inicializarAdapter()

        binding.btnAddCategoria2.setOnClickListener {
            val intent = Intent(this, CrearCategoria::class.java)
            startActivity(intent)
        }

        binding.btnAtras1.setOnClickListener {
            val intent = Intent(this,MenuLateralMG::class.java)
            startActivity(intent)
        }

    }

    private fun inicializarAdapter() {

        grid_view = binding.GVCategoria
        adapterList = myListAdapter_categorias(this, R.layout.custom_grid_categorias, listaCategorias)
        grid_view.adapter = adapterList
        registerForContextMenu(grid_view)
    }

    private fun vaciar_bd_categorias(){
        for(categoria in categoriaCRUD.getAllCategoria()){
            categoriaCRUD.deleteCategoria(categoria.id)
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