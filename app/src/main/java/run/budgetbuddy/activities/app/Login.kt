package run.budgetbuddy.activities.app

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.activities.MenuLateralMG
import run.budgetbuddy.activities.GG.Principal3G
import run.budgetbuddy.databinding.LoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInicioSesion.setOnClickListener {
            SystemClock.sleep(3000)
            Toast.makeText(
                this, "Has iniciado sesion", Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, Principal3G::class.java)
            startActivity(intent)
            finish()
        }


        binding.btnMenu1.setOnClickListener {
            val intent = Intent(this, MenuLateralMG::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnRegistrar.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }



    }
}