package run.budgetbuddy.activities.MG

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.MgAnadirIngresoBinding

class MgAnadirIngreso : AppCompatActivity() {

    private lateinit var binding: MgAnadirIngresoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgAnadirIngresoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnGastos = binding.tvGastos
        btnGastos.setOnClickListener {
            val intent = Intent(this, MgAnadirGasto::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAnadir.setOnClickListener {
            SystemClock.sleep(5000)
            Toast.makeText(
                this,
                "Se ha añadido un nuevo Ingreso",
                Toast.LENGTH_LONG
            ).show()
            val intent = Intent(this, MgInicioIngresos::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAtras4.setOnClickListener {
            val intent = Intent(this, MgInicioIngresos::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCalendario2.setOnClickListener {
            Toast.makeText(
                this,
                "Se muestra una pantalla de seleccion de Fecha",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.btnFecha7.setOnClickListener {
            Toast.makeText(
                this,
                "Seleccionada la fecha N ",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.btnFecha6.setOnClickListener {
            Toast.makeText(
                this,
                "Seleccionada la fecha N -1",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.btnFecha8.setOnClickListener {
            Toast.makeText(
                this,
                "Seleccionada la fecha N + 1",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}