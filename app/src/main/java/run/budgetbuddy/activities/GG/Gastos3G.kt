package run.budgetbuddy.activities.GG

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.GpGastosBinding

class Gastos3G : AppCompatActivity() {
    private lateinit var binding: GpGastosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GpGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSaldoA.setOnClickListener{
            val intent = Intent(this, Saldos3G::class.java)
            startActivity(intent)
            finish()
        }

        binding.imageViewA.setOnClickListener{
            val intent = Intent(this, Saldos3G::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAnadir1.setOnClickListener{
            val intent = Intent(this, NuevoGasto3G::class.java)
            startActivity(intent)
            finish()
        }
    }
}