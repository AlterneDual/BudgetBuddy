package run.budgetbuddy.activities.GG

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.GpCrearGrupoBinding

class UnirGrupo3G : AppCompatActivity() {
    private lateinit var binding: GpCrearGrupoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GpCrearGrupoBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}