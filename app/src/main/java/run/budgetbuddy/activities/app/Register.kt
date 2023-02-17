package run.budgetbuddy.activities.app

import CRUD.UsuarioCRUD

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import models.Usuario
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.databinding.RegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: RegisterBinding
    private lateinit var usuarioCRUD: UsuarioCRUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuarioCRUD = UsuarioCRUD()

        binding.btnMenu1.setOnClickListener {
            val intent = Intent(this, MenuLateralMG::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCrearUsuario.setOnClickListener {

            val nombre = binding.etNombre.text.toString()
            val password = binding.etPsw.text.toString()
            val email = binding.etEmail2.text.toString()

            if (nombre.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty()) {
                val nuevoUsuario = Usuario()
                nuevoUsuario.nombre = nombre
                nuevoUsuario.password = password
                nuevoUsuario.email = email

                val id = usuarioCRUD.addUser(nuevoUsuario)

                // Recuperar el usuario recién creado de la base de datos
                val x = usuarioCRUD.getUser(usuarioCRUD.getKey())

                // Imprimir el usuario en la consola
                println("Se ha creado un nuevo usuario: $nuevoUsuario")

                Toast.makeText(
                    this, "Se ha creado un nuevo usuario con ID: $id", Toast.LENGTH_LONG
                ).show()

                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this, "Por favor, complete todos los campos.", Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}