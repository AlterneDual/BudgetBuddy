package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.DivisaCRUD
import CRUD.GastoCRUD
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import models.Categoria
import models.Divisa
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.databinding.MgAnadirGastoBinding

class MgAnadirGasto : AppCompatActivity() {

    private lateinit var binding: MgAnadirGastoBinding

    var categoriaCrud: CategoriaCRUD = CategoriaCRUD()
    var divisaCrud: DivisaCRUD = DivisaCRUD()
    var gastoCrud: GastoCRUD = GastoCRUD()


    @RequiresApi(Build.VERSION_CODES.N)
    private var selectedDate: Calendar = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.N)
    private var today: Calendar = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.N)
    private var yesterday: Calendar = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.N)
    private var tomorrow: Calendar = Calendar.getInstance()

    private var todayDay: Int = 0
    private var todayMonth: Int = 0
    private var todayYear: Int = 0

    private var yesterdayDay: Int = 0
    private var yesterdayYear: Int = 0
    private var yesterdayMonth: Int = 0

    private var tomorrowDay: Int = 0
    private var tomorrowMonth: Int = 0
    private var tomorrowYear: Int = 0

    @RequiresApi(Build.VERSION_CODES.N)
    var fechaGasto = selectedDate.time

    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgAnadirGastoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        valoresAyerHoyPredeterminados()


        var tvFechaSeleccionada = binding.tvFechaSeleccionada
        var btnFecha1 = binding.btnFecha1
        var btnFecha2 = binding.btnFecha2
        var btnFecha3 = binding.btnFecha3
        var etCantidad = binding.etCantidad
        var etComentario = binding.etComentario
        var btnIngreso = binding.tvIngresos

        tvFechaSeleccionada.setText("$todayDay del ${todayMonth.plus(1)} de $todayYear")
        btnFecha1.setText("$yesterdayDay/${yesterdayMonth.plus(1)}")
        btnFecha2.setText("$todayDay/${todayMonth.plus(1)}")
        btnFecha3.setText("$tomorrowDay/${tomorrowMonth.plus(1)}")


        btnIngreso.setOnClickListener {
            val intent = Intent(this, MgAnadirIngreso::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAnadir.setOnClickListener {

            for(gasto in gastoCrud.getAllGastos()){
                gastoCrud.deleteGasto(gasto.id)
            }

            var cat = Categoria()
            cat.nombre = "Ocio"
            cat.descripcion = "Cine"
            cat.icono = R.drawable.cat_cine
            var keyCat = categoriaCrud.addCategoria(cat)

            var div = Divisa()
            div.nombre = "Euro"
            div.simbolo = "€"
            var keyDiv = divisaCrud.addDivisa(div)

            var gasto = Gasto()
            gasto.categoria = categoriaCrud.getCategoria(keyCat)
            gasto.divisa = divisaCrud.getDivisa(keyDiv)
            gasto.importe = etCantidad.text.toString().toDouble()
            gasto.descripcion = etComentario.text.toString()
            gasto.fecha = fechaGasto
            var keyGasto = gastoCrud.addGasto(gasto)

            for (gasto in gastoCrud.getAllGastos()) {

                println(gasto)
            }

            Toast.makeText(
                this, "Añadido gasto con fecha: ${gasto.fecha}", Toast.LENGTH_SHORT
            ).show()


//            val intent = Intent(this, MgInicio::class.java)
//            startActivity(intent)
//            finish()
        }

        binding.btnAtras3.setOnClickListener {
            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCalendario.setOnClickListener {
            Toast.makeText(
                this, "Se muestra una pantalla de seleccion de Fecha", Toast.LENGTH_SHORT
            ).show()
            showDatePickerDialog(tvFechaSeleccionada, btnFecha1, btnFecha2, btnFecha3)
        }

        binding.btnFecha1.setOnClickListener {

            updateFecha(yesterday)
            tvFechaSeleccionada.setText("$yesterdayDay del ${yesterdayMonth.plus(1)} de $yesterdayYear")

        }

        binding.btnFecha2.setOnClickListener {

            updateFecha(today)
            tvFechaSeleccionada.setText("$todayDay del ${todayMonth.plus(1)} de $todayYear")

        }

        binding.btnFecha3.setOnClickListener {

            updateFecha(tomorrow)
            tvFechaSeleccionada.setText("$tomorrowDay del ${todayMonth.plus(1)} de $tomorrowYear")

        }

    }

    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.N)
    private fun showDatePickerDialog(
        tvFechaSeleccionada: TextView,
        fecha1: TextView,
        fecha2: TextView,
        fecha3: TextView
    ) {
        val datePicker = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->

                selectedDate.set(Calendar.YEAR, year)
                selectedDate.set(Calendar.MONTH, month)
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                updateFecha(selectedDate)
                actualizarYesterdayTomorrow()

                fecha1.setText("$yesterdayDay/${yesterdayMonth.plus(1)}")
                fecha2.setText("$todayDay/${todayMonth.plus(1)}")
                fecha3.setText("$tomorrowDay/${tomorrowMonth.plus(1)}")
                tvFechaSeleccionada.setText("$dayOfMonth del ${month.plus(1)} de $year")

            },
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)

        )
        datePicker.show()
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateFecha(new_fecha: Calendar) {
        fechaGasto = new_fecha.time

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun valoresAyerHoyPredeterminados() {
        todayDay = today.get(Calendar.DAY_OF_MONTH)
        todayMonth = today.get(Calendar.MONTH)
        todayYear = today.get(Calendar.YEAR)

        yesterday.apply { add(Calendar.DATE, -1) }
        yesterdayDay = yesterday.get(Calendar.DAY_OF_MONTH)
        yesterdayMonth = yesterday.get(Calendar.MONTH)
        yesterdayYear = yesterday.get(Calendar.YEAR)

        tomorrow.apply { add(Calendar.DATE, 1) }
        tomorrowDay = tomorrow.get(Calendar.DAY_OF_MONTH)
        tomorrowMonth = tomorrow.get(Calendar.MONTH)
        tomorrowYear = tomorrow.get(Calendar.YEAR)



    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun actualizarYesterdayTomorrow() {

        today.setTime(selectedDate.getTime())
        todayDay = today.get(Calendar.DAY_OF_MONTH)
        todayMonth = today.get(Calendar.MONTH)
        todayYear = today.get(Calendar.YEAR)

        yesterday.setTime(selectedDate.getTime())
        yesterday.add(Calendar.DATE, -1)
        yesterdayDay = yesterday.get(Calendar.DAY_OF_MONTH)
        yesterdayMonth = yesterday.get(Calendar.MONTH)
        yesterdayYear = yesterday.get(Calendar.YEAR)

        tomorrow.setTime(selectedDate.getTime())
        tomorrow.add(Calendar.DATE, 1)
        tomorrowDay = tomorrow.get(Calendar.DAY_OF_MONTH)
        tomorrowMonth = tomorrow.get(Calendar.MONTH)
        tomorrowYear = tomorrow.get(Calendar.YEAR)

    }


}