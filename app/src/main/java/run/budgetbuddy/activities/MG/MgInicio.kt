package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.DivisaCRUD
import CRUD.GastoCRUD
import CRUD.UsuarioCRUD
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.mikephil.charting.data.PieEntry
import io.realm.Realm
import io.realm.RealmList
import models.Categoria
import models.Divisa
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.activities.MenuLateralMG
import run.budgetbuddy.adapter.myListAdapter_gasto
import run.budgetbuddy.databinding.MgInicioGastosBinding

class MgInicio : AppCompatActivity() {

    private lateinit var binding: MgInicioGastosBinding
    private lateinit var adapter: myListAdapter_gasto
    var categoriaCRUD : CategoriaCRUD = CategoriaCRUD()
    var divisaCRUD : DivisaCRUD = DivisaCRUD()
    var gastoCRUD : GastoCRUD = GastoCRUD()
    var usuarioCRUD : UsuarioCRUD = UsuarioCRUD()
    var listagastos: RealmList<Gasto> = RealmList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MgInicioGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val listView = binding.lvInicioGastos
        adapter = myListAdapter_gasto(this, listagastos)
        listView.adapter = adapter

        crearGasto()

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
            val intent = Intent(this, MgInfo::class.java)
            startActivity(intent)
            finish()
        }


    }


    private fun crearGasto() {
        var div1 = Divisa()
        div1.nombre = "Euro"
        var keydivisa = divisaCRUD.addDivisa(div1)

        var cat1 = Categoria()
        cat1.nombre = "Ocio"
        cat1.icono = R.drawable.cat_cine
        var keycat = categoriaCRUD.addCategoria(cat1)

        var gasto1 = Gasto()
        gasto1.importe = 20.00
        var div = divisaCRUD.getDivisa(keydivisa)
        gasto1.divisa = div
        var cat = categoriaCRUD.getCategoria(keycat)
        gasto1.categoria = cat

        var keyGasto = gastoCRUD.addGasto(gasto1)
        listagastos.add(gastoCRUD.getGasto(keyGasto))
        adapter.notifyDataSetChanged()
    }

}