package run.budgetbuddy.activities.categoria

import CRUD.CategoriaCRUD
import adapter.myListAdapter_colores
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import models.Categoria
import run.budgetbuddy.R
import run.budgetbuddy.databinding.CrearCategoriaBinding

class CrearCategoria : AppCompatActivity() {
    private lateinit var binding: CrearCategoriaBinding
    private lateinit var adapterList: myListAdapter_colores
    private lateinit var adapterListColores: myListAdapter_colores
    private lateinit var grid_view: GridView
    private lateinit var txt_nombre: EditText
    private lateinit var grid_view_colores: GridView
    private lateinit var listaIconos: MutableList<Int>
    private lateinit var listaColores: MutableList<Int>
    private lateinit var lista_colores_hex: MutableList<String>
    private var categoriaSeleccionada: Int = -1
    private var colorSeleccionado: Int = -1
    private var viewActual: View? = null
    private var viewcol: View? = null
    var categoriaCRUD: CategoriaCRUD = CategoriaCRUD()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CrearCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaIconos = crearIconos()
        inicializarAdapter()

        listaColores = crearColores()
        inicializarAdapterColores()

        lista_colores_hex = colores()

        grid_view = binding.GVCategorias3
        grid_view.setOnItemClickListener() { parent, view, position, id ->
            categoriaSeleccionada = position

            if (viewActual != null && viewActual != view) {
                viewActual?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                viewcol?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                view.setBackgroundColor(Color.parseColor("#988C8C"))
            } else {
                view.setBackgroundColor(Color.parseColor("#988C8C"))
            }
            viewActual = view
        }

        txt_nombre = binding.etNombreCategoria

        grid_view_colores = binding.GVColores
        grid_view_colores.setOnItemClickListener() { parent, view, position, id ->
            colorSeleccionado = position
            if (viewcol != null && viewcol != view) {

                if (position == 0) {
                    viewcol?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                    view?.setBackgroundColor(Color.rgb(69, 119, 193))
                } else if (position == 1) {
                    viewcol?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                    view?.setBackgroundColor(Color.rgb(232, 84, 217))
                } else if (position == 2) {
                    viewcol?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                    view?.setBackgroundColor(Color.rgb(104, 201, 172))
                } else if (position == 3) {
                    viewcol?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                    view?.setBackgroundColor(Color.rgb(84, 202, 117))
                } else if (position == 4) {
                    viewcol?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                    view?.setBackgroundColor(Color.rgb(220, 45, 45))
                } else if (position == 5) {
                    viewcol?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                    view?.setBackgroundColor(Color.rgb(237, 229, 33))
                } else if (position == 6) {
                    viewcol?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                    view?.setBackgroundColor(Color.rgb(42, 205, 27))
                } else if (position == 7) {
                    viewcol?.setBackgroundColor(Color.parseColor("#00FFFFFF"))
                    view?.setBackgroundColor(Color.rgb(255, 157, 10))
                }

            } else {
                if (position == 0) {
                    view?.setBackgroundColor(Color.rgb(69, 119, 193))
                } else if (position == 1) {
                    view?.setBackgroundColor(Color.rgb(232, 84, 217))
                } else if (position == 2) {
                    view?.setBackgroundColor(Color.rgb(104, 201, 172))
                } else if (position == 3) {
                    view?.setBackgroundColor(Color.rgb(84, 202, 117))
                } else if (position == 4) {
                    view?.setBackgroundColor(Color.rgb(220, 45, 45))
                } else if (position == 5) {
                    view?.setBackgroundColor(Color.rgb(237, 229, 33))
                } else if (position == 6) {
                    view?.setBackgroundColor(Color.rgb(42, 205, 27))
                } else if (position == 7) {
                    view?.setBackgroundColor(Color.rgb(255, 157, 10))
                }
            }
            viewcol = view

            if (position == 0) {
                viewActual?.setBackgroundColor(Color.rgb(69, 119, 193))
            } else if (position == 1) {
                viewActual?.setBackgroundColor(Color.rgb(232, 84, 217))
            } else if (position == 2) {
                viewActual?.setBackgroundColor(Color.rgb(104, 201, 172))
            } else if (position == 3) {
                viewActual?.setBackgroundColor(Color.rgb(84, 202, 117))
            } else if (position == 4) {
                viewActual?.setBackgroundColor(Color.rgb(220, 45, 45))
            } else if (position == 5) {
                viewActual?.setBackgroundColor(Color.rgb(237, 229, 33))
            } else if (position == 6) {
                viewActual?.setBackgroundColor(Color.rgb(42, 205, 27))
            } else if (position == 7) {
                viewActual?.setBackgroundColor(Color.rgb(255, 157, 10))
            }
        }

        binding.btnAnadir2.setOnClickListener {

            if (txt_nombre.text.toString() != "" && categoriaSeleccionada >= 0 && colorSeleccionado >= 0
            ) {
                crearCategoria()
                Toast.makeText(
                    this,
                    "Se ha añadido una Categoria",
                    Toast.LENGTH_LONG
                ).show()

                val intent = Intent(this, Categorias::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Rellene todos los campos",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, Categorias::class.java)
            startActivity(intent)
        }
    }

    private fun crearCategoria() {

        var categoria = Categoria()
        categoria.nombre = txt_nombre.text.toString()
        categoria.icono = listaIconos[categoriaSeleccionada]
        categoria.color = listaColores[colorSeleccionado]
        categoria.color_hex = lista_colores_hex[colorSeleccionado]
        categoriaCRUD.addCategoria(categoria)
    }

    private fun inicializarAdapter() {

        grid_view = binding.GVCategorias3
        adapterList =
            myListAdapter_colores(this, R.layout.custom_grid_crear_categorias, listaIconos)
        grid_view.adapter = adapterList
        registerForContextMenu(grid_view)
    }

    private fun inicializarAdapterColores() {

        grid_view_colores = binding.GVColores
        adapterListColores = myListAdapter_colores(this, R.layout.custom_list_colores, listaColores)
        grid_view_colores.adapter = adapterListColores
        registerForContextMenu(grid_view_colores)
    }

    private fun crearIconos(): MutableList<Int> {

        val listaCategorias = mutableListOf<Int>(

            R.drawable.cat_avion_, R.drawable.cat_cine, R.drawable.cat_bolos, R.drawable.cat_coctel,
            R.drawable.cat_compras, R.drawable.cat_hotel, R.drawable.cat_limpieza,
            R.drawable.cat_regalo, R.drawable.cat_restaurante, R.drawable.cat_videojuego
        )

        return listaCategorias
    }

    private fun crearColores(): MutableList<Int> {

        val listaColores = mutableListOf<Int>(

            R.drawable.circulo_azul, R.drawable.circulo_rosa, R.drawable.circulo_celeste,
            R.drawable.circulo_turquesa, R.drawable.circulo_rojo, R.drawable.circulo_amarillo,
            R.drawable.circulo_verde, R.drawable.circulo_naranja
        )

        return listaColores
    }

    private fun colores(): MutableList<String> {
        var colores = mutableListOf<String>(
            "#010efe", "#f610fe", "#97b5fe", "#00ffff", "#EF5757", "#F4D35E", "#2ACD1B", "#FF9D0A"
        )
        return colores
    }
}