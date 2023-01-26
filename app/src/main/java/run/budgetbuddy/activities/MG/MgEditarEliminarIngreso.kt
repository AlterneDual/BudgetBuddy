package run.budgetbuddy.activities.MG

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.MgEditarGastosBinding

class MgEditarEliminarIngreso : AppCompatActivity() {
    private lateinit var binding: MgEditarGastosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgEditarGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}