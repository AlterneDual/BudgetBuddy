package run.budgetbuddy.activities.categoria

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.CrearCategoriaBinding

class CrearCategoria : AppCompatActivity() {
    private lateinit var binding: CrearCategoriaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CrearCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnadir2.setOnClickListener {

            SystemClock.sleep(5000)
            Toast.makeText(
                this,
                "Se ha añadido una Categoria",
                Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, Categorias::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, AddCategoria::class.java)
            startActivity(intent)
            finish()
        }
    }
}