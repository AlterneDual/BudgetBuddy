package run.budgetbuddy.activities.MG

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.R
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.databinding.MgInicioIngresosBinding

class MgInicioIngresos : AppCompatActivity() {

    private lateinit var binding: MgInicioIngresosBinding
    private lateinit var gestos: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInicioIngresosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gestos = GestureDetector(this, EscuchaGestos())

        var btnGastos = binding.tvGastos
        btnGastos.setOnClickListener {
            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
            overridePendingTransition(0, R.drawable.slide_out_right)
            finish()
        }

        var btnAnadirIngreso = binding.btnAddGroup3
        btnAnadirIngreso.setOnClickListener {
            val intent = Intent(this, MgAnadirIngreso::class.java)
            startActivity(intent)
            finish()
        }
        var btnAjustes = binding.btnMenu2
        btnAjustes.setOnClickListener {
            val intent = Intent(this, MenuLateralMG::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvDia.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por dia (Ingreso)",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.tvSemana.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Semana (Ingreso)",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.tvMes.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Mes (Ingreso)",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.tvAnho.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Año (Ingreso)",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.tvPeriodo.setOnClickListener {
            Toast.makeText(
                this,
                "Pulsado Boton de Ver por Periodo (Ingreso)",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.butInfo.setOnClickListener {
            val intent = Intent(this, MgInfo::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestos.onTouchEvent(event!!)
        return super.onTouchEvent(event)

    }

    inner class EscuchaGestos() : GestureDetector.SimpleOnGestureListener() {

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (e2.x > e1.x) {
                val intent = Intent(this@MgInicioIngresos, MgInicio::class.java)
                startActivity(intent)
                overridePendingTransition(0, R.drawable.slide_out_right)
                finish()
            }
            return true
        }
    }

}