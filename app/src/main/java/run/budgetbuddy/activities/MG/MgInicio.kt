package run.budgetbuddy.activities.MG

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import run.budgetbuddy.activities.MenuLateralMG
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
            val intent = Intent(this, MgInfo::class.java)
            startActivity(intent)
            finish()
        }


    }

}