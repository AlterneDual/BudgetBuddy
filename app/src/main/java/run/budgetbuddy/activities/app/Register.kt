package run.budgetbuddy.activities.app

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.activities.GG.Principal3G
import run.budgetbuddy.activities.MenuLateralMG
import run.budgetbuddy.databinding.LoadScreenBinding
import run.budgetbuddy.databinding.RegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: RegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMenu1.setOnClickListener {
            val intent = Intent(this, MenuLateralMG::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCrearUsuario.setOnClickListener {
            SystemClock.sleep(2000)
            Toast.makeText(
                this, "Se ha creado un nuevo usuario", Toast.LENGTH_LONG
            ).show()
            val intent = Intent(this, Principal3G::class.java)
            startActivity(intent)
            finish()
        }
    }
}