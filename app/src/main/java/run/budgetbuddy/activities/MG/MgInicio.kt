package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.DivisaCRUD
import CRUD.GastoCRUD
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import models.Categoria
import models.Divisa
import models.Gasto
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.databinding.MgInicioGastosBinding

class MgInicio : AppCompatActivity() {

    private lateinit var binding: MgInicioGastosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInicioGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnIngresos = binding.tvIngresos
        btnIngresos.setOnClickListener {
            val intent = Intent(this, MgInicioIngresos::class.java)
            startActivity(intent)
            finish()
        }
        var btnAnadirGasto = binding.btnAddGroup2
        btnAnadirGasto.setOnClickListener {
            val intent = Intent(this, MgAnadirGasto::class.java)
            startActivity(intent)
            finish()
        }
        var btnAjustes = binding.btnMenu1
        btnAjustes.setOnClickListener {
            val intent = Intent(this, MenuLateralMG::class.java)
            startActivity(intent)
            finish()
        }
        binding.tvDia.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por dia",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.tvSemana.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Semana",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.tvMes.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Mes",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.tvAnho.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Año",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.tvPeriodo.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Periodo",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.butInfo.setOnClickListener {
            cargar()
            val intent = Intent(this, MgInfo::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun cargar() {
        var divisaCRUD = DivisaCRUD()
        var categoriaCRUD = CategoriaCRUD()
        var gastoCRUD = GastoCRUD()

        divisaCRUD.cleanAll()
        categoriaCRUD.cleanAll()
        gastoCRUD.cleanAll()

        // Creacion de las Divisas
        var div1 = Divisa()
        div1.nombre = "Euro (€)"
        var keydivisa = divisaCRUD.addDivisa(div1)

        var div2 = Divisa()
        div2.nombre = "Dollar ($)"
        var keydivisa2 = divisaCRUD.addDivisa(div2)

        // Creacion de Categorias
        var cat1 = Categoria()
        cat1.nombre = "Ocio"
        var k1 = categoriaCRUD.addCategoria(cat1)

        var cat2 = Categoria()
        cat2.nombre = "Alimentacion"
        var k2 = categoriaCRUD.addCategoria(cat2)

        var cat3 = Categoria()
        cat3.nombre = "Alquiler"
        var k3 = categoriaCRUD.addCategoria(cat3)

        // Creacion de los Gastos
        var gasto1 = Gasto()
        gasto1.importe = 20.00
        var div = divisaCRUD.getDivisa(keydivisa)
        gasto1.divisa = div
        var cat = categoriaCRUD.getCategoria(k1)
        gasto1.categoria = cat
        gastoCRUD.addGasto(gasto1)

        var gasto2 = Gasto()
        gasto2.importe = 10.00
        div = divisaCRUD.getDivisa(keydivisa2)
        gasto2.divisa = div
        cat = categoriaCRUD.getCategoria(k1)
        gasto2.categoria = cat
        gastoCRUD.addGasto(gasto2)

        var gasto3 = Gasto()
        gasto3.importe = 15.50
        div = divisaCRUD.getDivisa(keydivisa2)
        gasto3.divisa = div
        cat = categoriaCRUD.getCategoria(k2)
        gasto3.categoria = cat
        gastoCRUD.addGasto(gasto3)

        var gasto4 = Gasto()
        gasto4.importe = 50.00
        div = divisaCRUD.getDivisa(keydivisa)
        gasto4.divisa = div
        cat = categoriaCRUD.getCategoria(k2)
        gasto4.categoria = cat
        gastoCRUD.addGasto(gasto4)

        println("DIVISAS -- //////////////////////////////////////////////////////////////////////////////////////////////////////")
        for (div in divisaCRUD.getAllDivisa()) {
            println(div.toString())
        }
        println("CATEGORIAS -- //////////////////////////////////////////////////////////////////////////////////////////////////////")
        for (cat in categoriaCRUD.getAllCategoria()) {
            println(cat.toString())
        }
        println("GASTOS -- //////////////////////////////////////////////////////////////////////////////////////////////////////")
        for (g in gastoCRUD.getAllGastos()) {
            println(g.toString())
        }
    }
}