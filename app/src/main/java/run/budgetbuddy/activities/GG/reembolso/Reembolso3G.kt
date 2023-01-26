package run.budgetbuddy.activities.GG.reembolso

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.activities.GG.Principal3G
import run.budgetbuddy.activities.GG.Saldos3G
import run.budgetbuddy.databinding.GpReembolsoBinding

class Reembolso3G : AppCompatActivity() {
    private lateinit var binding: GpReembolsoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GpReembolsoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            SystemClock.sleep(2000)
            Toast.makeText(
                this, "Se ha guardado", Toast.LENGTH_LONG
            ).show()
            val intent = Intent(this, Saldos3G::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAllReembolsos.setOnClickListener {
            val intent = Intent(this, AllReembolsos::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnPagadorSelector.setOnClickListener{
            Toast.makeText(
                this, "Elector de Pagador", Toast.LENGTH_LONG
            ).show()
        }
        binding.btnSelectorDivisa.setOnClickListener{
            Toast.makeText(
                this, "Elector de Divisa", Toast.LENGTH_LONG
            ).show()
        }
    }
}