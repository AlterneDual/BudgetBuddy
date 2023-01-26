package run.budgetbuddy.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import run.budgetbuddy.activities.MG.MgAnadirGasto
import run.budgetbuddy.databinding.ActivityMenuLateral1Binding

class MenuLateralMG : AppCompatActivity() {

    private lateinit var binding: ActivityMenuLateral1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuLateral1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnAjustes = binding.icHome
        btnAjustes.setOnClickListener {
            val intent = Intent(this, Ajustes::class.java)
            startActivity(intent)

        }
        val btnInicio = binding.icHome
        btnInicio.setOnClickListener {
            val intent = Intent(this, MgAnadirGasto::class.java)
            startActivity(intent)

        }
    }
}