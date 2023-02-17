package run.budgetbuddy.activities.app

import CRUD.UsuarioCRUD
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.activities.GG.Principal3G
import run.budgetbuddy.activities.MG.MgInicio
import run.budgetbuddy.databinding.LoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: LoginBinding
    private lateinit var usuarioCRUD: UsuarioCRUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuarioCRUD = UsuarioCRUD()

        binding.btnInicioSesion.setOnClickListener {

            val email = binding.etEmail.text.toString()
            val password = binding.etPsw.text.toString()

            val usuario = usuarioCRUD.getUserByPassword(email, password)
            if (usuario != null) {
                Toast.makeText(
                    this, "Has iniciado sesión", Toast.LENGTH_LONG
                ).show()
                val intent = Intent(this, MgInicio::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this, "Este usuario no existe", Toast.LENGTH_LONG
                ).show()
            }
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