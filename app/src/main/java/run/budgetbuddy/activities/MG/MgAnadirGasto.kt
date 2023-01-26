package run.budgetbuddy.activities.MG

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.activities.categoria.Categorias
import run.budgetbuddy.databinding.MgAnadirGastoBinding
import run.budgetbuddy.databinding.MgInicioGastosBinding

class MgAnadirGasto : AppCompatActivity() {

    private lateinit var binding: MgAnadirGastoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgAnadirGastoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnIngreso = binding.tvIngresos
        btnIngreso.setOnClickListener {
            val intent = Intent(this, MgAnadirIngreso::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAnadir.setOnClickListener {
            SystemClock.sleep(5000)
            Toast.makeText(
                this, "Se ha añadido un nuevo gasto", Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAtras3.setOnClickListener {
            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCalendario.setOnClickListener {
            Toast.makeText(
                this, "Se muestra una pantalla de seleccion de Fecha", Toast.LENGTH_LONG
            ).show()
        }

        binding.btnFecha1.setOnClickListener {
            Toast.makeText(
                this, "Seleccionada la fecha N - 1 ", Toast.LENGTH_LONG
            ).show()
        }

        binding.btnFecha2.setOnClickListener {
            Toast.makeText(
                this, "Seleccionada la fecha N", Toast.LENGTH_LONG
            ).show()
        }

        binding.btnFecha3.setOnClickListener {
            Toast.makeText(
                this, "Seleccionada la fecha N + 1", Toast.LENGTH_LONG
            ).show()
        }


    }
}