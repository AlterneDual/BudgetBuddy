package run.budgetbuddy.activities.GG.reembolso

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.GpReembolsoBinding
import run.budgetbuddy.databinding.GpReembolsoListBinding

class AllReembolsos:AppCompatActivity() {
    private lateinit var binding: GpReembolsoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GpReembolsoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}