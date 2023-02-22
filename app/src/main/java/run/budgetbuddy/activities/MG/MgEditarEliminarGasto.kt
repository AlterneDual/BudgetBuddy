package run.budgetbuddy.activities.MG

import CRUD.GastoCRUD
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import models.Gasto
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.databinding.MgEditarGastosBinding

class MgEditarEliminarGasto: AppCompatActivity() {
    private lateinit var binding: MgEditarGastosBinding
    private var gastoCRUD: GastoCRUD = GastoCRUD()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgEditarGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre")
        val importe = intent.getStringExtra("importe")
        val id = intent.getIntExtra("id", 0)

        binding.etNombreGasto.setText(nombre)
        binding.etCantidad3.setText(importe)

        binding.btnAtras2.setOnClickListener {
            val intent = Intent(this,MgInfo::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnEditar.setOnClickListener {
            val nombreGasto = binding.etNombreGasto.text.toString()
            val cantidad = binding.etCantidad3.text.toString().toDoubleOrNull()

            if (nombreGasto.isNotBlank() && cantidad != null) {
                val gasto = Gasto()
                gasto.descripcion = nombreGasto
                gasto.importe = cantidad
                gasto.id = id

                gastoCRUD.updateGasto(gasto)

                val intent = Intent(this,MgInfo::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Por favor, introduce un nombre y una cantidad válida", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnEliminar1.setOnClickListener {
            gastoCRUD.deleteGasto(id)

            val intent = Intent(this, MgInfo::class.java)
            startActivity(intent)
            finish()
        }
    }
}
