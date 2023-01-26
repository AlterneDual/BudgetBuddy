package run.budgetbuddy.activities.categoria

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.AnadirCategoriaBinding

class AddCategoria : AppCompatActivity() {
    private lateinit var binding: AnadirCategoriaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AnadirCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddCategoria.setOnClickListener{
            val intent = Intent(this, CrearCategoria::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAtras1.setOnClickListener{
            val intent = Intent(this, Categorias::class.java)
            startActivity(intent)
            finish()
        }
    }
}