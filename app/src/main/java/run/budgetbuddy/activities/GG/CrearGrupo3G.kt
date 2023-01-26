package run.budgetbuddy.activities.GG

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.databinding.GpCrearGrupoBinding
import run.budgetbuddy.databinding.MainView3gBinding

class CrearGrupo3G : AppCompatActivity() {
    private lateinit var binding: GpCrearGrupoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GpCrearGrupoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.coinSelector.setOnClickListener {
            Toast.makeText(
                this, "Seleccion de Divisa", Toast.LENGTH_LONG
            ).show()
        }

        binding.participanteAdd.setOnClickListener {
            Toast.makeText(
                this, "Se ha añadido un Participante", Toast.LENGTH_LONG
            ).show()
        }

        binding.verParticipante.setOnClickListener {
            Toast.makeText(
                this, "Dialogo para ver los participantes", Toast.LENGTH_LONG
            ).show()
        }

        binding.butAceptar.setOnClickListener {
            SystemClock.sleep(2000)
            Toast.makeText(
                this, "Se ha creado el Grupo", Toast.LENGTH_LONG
            ).show()
            val intent = Intent(this, Principal3G::class.java)
            startActivity(intent)
            finish()
        }

        binding.butVolver.setOnClickListener {
            val intent = Intent(this, Principal3G::class.java)
            startActivity(intent)
            finish()
        }

    }

}