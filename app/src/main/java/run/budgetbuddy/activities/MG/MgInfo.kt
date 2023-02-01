package run.budgetbuddy.activities.MG

import CRUD.GastoCRUD
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import io.realm.Realm
import models.Gasto
import run.budgetbuddy.databinding.MgInfoBinding
import java.sql.Date

class MgInfo : AppCompatActivity() {
    private lateinit var binding: MgInfoBinding
    private var seleccionado: Int = 0;
    var gc: GastoCRUD = GastoCRUD()


    //    private lateinit var sharedPreferences: SharedPreferences


    private var MYGESTORVIEWINGRESOS_SETTING = "MyGestorView"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.textView.isVisible = false;
        binding.tvSaldoRestante.isVisible = false;

//        if (sharedPreferences.getBoolean(MYGESTORVIEWINGRESOS_SETTING, false)) {
//            var lista_gastos = gc.getAllGastos();
//            var total: Double = 0.0;
//            for (l in lista_gastos) {
//                total += l.importe;
//            }
//
//            binding.textView.isVisible = true;
//            binding.tvSaldoRestante.isVisible = true;
//            binding.tvSaldoRestante.text = total.toString();
//        }

        when (seleccionado) {
            1 -> print("1")
            2 -> print("2")
            3 -> print("3")
            4 -> print("4")
            5 -> print("5")

            else -> print("Default")
        }


        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvDia.setOnClickListener {
            seleccionado = 1;
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por dia",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.tvSemana.setOnClickListener {
            seleccionado = 2;
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Semana",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.tvMes.setOnClickListener {
            seleccionado = 3;
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Mes",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.tvAnho.setOnClickListener {
            seleccionado = 4;
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Año",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.tvPeriodo.setOnClickListener {
            seleccionado = 5;
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Periodo",
                Toast.LENGTH_LONG
            ).show()
        }

        fun verInfoDia(fecha_hoy: Date) {

        }

        fun verInfoSemana(fecha_hoy: Date) {

        }

        fun verInfoMes(fecha_hoy: Date) {

        }

        fun verInfoAno(fecha_hoy: Date) {

        }

        fun verInfoPeriodo(fecha_hoy: Date) {

        }

    }
}