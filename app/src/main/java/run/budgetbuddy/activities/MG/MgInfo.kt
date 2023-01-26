package run.budgetbuddy.activities.MG

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.MgInfoBinding

class MgInfo : AppCompatActivity() {
    private lateinit var binding: MgInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
            finish()
        }
    }
}