package run.budgetbuddy.activities.app

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.CategoriasBinding
import run.budgetbuddy.databinding.LoadScreenBinding

class CargaInicio : AppCompatActivity() {
    private lateinit var binding: LoadScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoadScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
