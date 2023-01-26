package run.budgetbuddy.activities.categoria

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.activities.MenuLateralMG
import run.budgetbuddy.databinding.CategoriasBinding

class Categorias : AppCompatActivity() {
    private lateinit var binding: CategoriasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddCategoria2.setOnClickListener {
            val intent = Intent(this, AddCategoria::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAtras1.setOnClickListener {
            val intent = Intent(this, MenuLateralMG::class.java)
            startActivity(intent)
            finish()
        }
    }
}