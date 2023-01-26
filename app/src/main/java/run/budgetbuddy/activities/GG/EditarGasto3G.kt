package run.budgetbuddy.activities.GG

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.GpEditarGastoAvanzadoBinding

class EditarGasto3G : AppCompatActivity() {
    private lateinit var binding: GpEditarGastoAvanzadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GpEditarGastoAvanzadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAtrasC3.setOnClickListener {
            val intent = Intent(this, Gastos3G::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCheckA.setOnClickListener {
            SystemClock.sleep(2000)
            Toast.makeText(
                this, "Se ha creado el Gasto", Toast.LENGTH_LONG
            ).show()
            val intent = Intent(this, Gastos3G::class.java)
            startActivity(intent)
            finish()
        }


    }
}