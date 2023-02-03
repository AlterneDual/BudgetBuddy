package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.DivisaCRUD
import CRUD.GastoCRUD
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import io.realm.RealmList
import models.Categoria
import models.Divisa
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.adapter.myListAdapter_gasto
import run.budgetbuddy.databinding.MgInicioGastosBinding

class MgInicio : AppCompatActivity() {

    private lateinit var binding: MgInicioGastosBinding
    private lateinit var adapter: myListAdapter_gasto
    var listagastos: RealmList<Gasto> = RealmList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInicioGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pieChart = findViewById<PieChart>(R.id.pieChart)

        val entries = listOf(
            PieEntry(30f, ""),
            PieEntry(30f, ""),
            PieEntry(40f, "")
        )

        val pieDataSet = PieDataSet(entries, "")
        pieDataSet.colors = listOf(Color.MAGENTA, Color.YELLOW, Color.GREEN)

        val pieData = PieData(pieDataSet)

        pieChart.data = pieData

        pieChart.invalidate()



        val listView = binding.lvInicioGastos
        adapter = myListAdapter_gasto(this, listagastos)
        listView.adapter = adapter

        //cargar()

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
        cat1.icono = R.drawable.cat_cine
        var k1 = categoriaCRUD.addCategoria(cat1)

        var cat2 = Categoria()
        cat2.nombre = "Alimentacion"
        cat2.icono = R.drawable.cat_coctel
        var k2 = categoriaCRUD.addCategoria(cat2)

        var cat3 = Categoria()
        cat3.nombre = "Alquiler"
        cat3.icono = R.drawable.cat_hotel
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
        cat = categoriaCRUD.getCategoria(k2)
        gasto2.categoria = cat
        gastoCRUD.addGasto(gasto2)

        var gasto3 = Gasto()
        gasto3.importe = 15.50
        div = divisaCRUD.getDivisa(keydivisa2)
        gasto3.divisa = div
        cat = categoriaCRUD.getCategoria(k3)
        gasto3.categoria = cat
        gastoCRUD.addGasto(gasto3)


        var keyGasto1 = gastoCRUD.addGasto(gasto1)
        var keyGasto2 = gastoCRUD.addGasto(gasto2)
        var keyGasto3 = gastoCRUD.addGasto(gasto3)

        listagastos.add(gastoCRUD.getGasto(keyGasto1))
        listagastos.add(gastoCRUD.getGasto(keyGasto2))
        listagastos.add(gastoCRUD.getGasto(keyGasto3))

        adapter.notifyDataSetChanged()


    }


}