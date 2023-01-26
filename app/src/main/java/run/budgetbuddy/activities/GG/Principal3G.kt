package run.budgetbuddy.activities.GG

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import run.budgetbuddy.activities.MenuLateralMG
import run.budgetbuddy.databinding.MainView3gBinding

class Principal3G : AppCompatActivity() {
    private lateinit var binding: MainView3gBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainView3gBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addGrupo.setOnClickListener {
            binding.nuevoGrupo.isVisible = true
            binding.optionsGrupo.isVisible = true
            binding.addGrupoEnlace.isVisible = true
        }

        binding.nuevoGrupo.setOnClickListener {
            binding.nuevoGrupo.isGone = true
            binding.optionsGrupo.isGone = true
            binding.addGrupoEnlace.isGone = true
        }

        binding.addGrupo.setOnClickListener {
            val intent = Intent(this, CrearGrupo3G::class.java)
            startActivity(intent)
            finish()
        }


    }
}