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
import android.os.SystemClock
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import models.Categoria
import models.Divisa
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.databinding.MgAnadirGastoBinding
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class MgAnadirGasto : AppCompatActivity() {

    private lateinit var binding: MgAnadirGastoBinding

    var categoriaCrud : CategoriaCRUD = CategoriaCRUD()
    var divisaCrud : DivisaCRUD = DivisaCRUD()
    var gastoCrud : GastoCRUD = GastoCRUD()

//    @RequiresApi(Build.VERSION_CODES.O)
//    var fechaSeleccionada : LocalDate = LocalDate.now()




    @RequiresApi(Build.VERSION_CODES.N)
    private var selectedDate: Calendar = Calendar.getInstance()
    private var selectedYear: Int = 0
    private var selectedMonth: Int = 0
    private var selectedDay: Int = 0
    private var selectedDayManual: Int = 0
    private var selectedMonthManual: Int = 0
    private var selectedYearManual: Int = 0

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
    var fecha = selectedDate.time

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



        tvFechaSeleccionada.setText("$todayDay del $todayMonth de $todayYear")


        btnFecha1.setText("$yesterdayDay/$yesterdayMonth")
        btnFecha2.setText("$todayDay/$todayMonth")
        btnFecha3.setText("$tomorrowDay/$tomorrowMonth")


        var btnIngreso = binding.tvIngresos
        btnIngreso.setOnClickListener {
            val intent = Intent(this, MgAnadirIngreso::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAnadir.setOnClickListener {
//            SystemClock.sleep(5000)
            Toast.makeText(
                this, "Se ha añadido un nuevo gasto", Toast.LENGTH_SHORT
            ).show()

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
            gasto.fecha = fecha
            var keyGasto = gastoCrud.addGasto(gasto)

            for (gasto in gastoCrud.getAllGastos()){

                println(gasto)
            }







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
            showDatePickerDialog(tvFechaSeleccionada,btnFecha1,btnFecha2,btnFecha3)
        }

        binding.btnFecha1.setOnClickListener {

            selectedDayManual = yesterdayDay
            selectedMonthManual = yesterdayMonth
            selectedYearManual = yesterdayYear

            var calYesterday = yesterday
            calYesterday.set(Calendar.YEAR, selectedYearManual)
            calYesterday.set(Calendar.MONTH, selectedMonthManual)
            calYesterday.set(Calendar.DAY_OF_MONTH, selectedDayManual)

            updateFecha(yesterday)


            tvFechaSeleccionada.setText("$selectedDayManual del $selectedMonthManual de $yesterdayYear")
        }

        binding.btnFecha2.setOnClickListener {

            if (selectedDay == 0){
                selectedDayManual = todayDay
                selectedMonthManual = todayMonth
                selectedYearManual = todayYear


            } else{
                selectedDayManual = selectedDay
                selectedMonthManual = selectedMonth
                selectedYearManual = selectedYear

                today.set(Calendar.YEAR, selectedYearManual)
                today.set(Calendar.MONTH, selectedMonthManual)
                today.set(Calendar.DAY_OF_MONTH, selectedDayManual)

                updateFecha(today)
            }

            tvFechaSeleccionada.setText("$selectedDayManual del $selectedMonthManual de $selectedYearManual")
        }

        binding.btnFecha3.setOnClickListener {

            selectedDayManual = tomorrowDay
            selectedMonthManual = tomorrowMonth
            selectedYearManual = tomorrowYear

            var calTomorrow = yesterday
            calTomorrow.set(Calendar.YEAR, selectedYearManual)
            calTomorrow.set(Calendar.MONTH, selectedMonthManual)
            calTomorrow.set(Calendar.DAY_OF_MONTH, selectedDayManual)

            updateFecha(tomorrow)
//            updateFechaSeleccionada()

            tvFechaSeleccionada.setText("$selectedDayManual del $selectedMonthManual de $selectedYearManual")

        }



    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun valoresAyerHoyPredeterminados() {
        todayDay = today.get(Calendar.DAY_OF_MONTH)
        todayMonth = today.get(Calendar.MONTH) +1
        todayYear = today.get(Calendar.YEAR)

        yesterday.apply { add(Calendar.DATE, -1) }
        yesterdayDay = yesterday.get(Calendar.DAY_OF_MONTH)
        yesterdayMonth = yesterday.get(Calendar.MONTH) +1
        yesterdayYear = yesterday.get(Calendar.YEAR)

        tomorrow.apply { add(Calendar.DATE, 1) }
        tomorrowDay = tomorrow.get(Calendar.DAY_OF_MONTH)
        tomorrowMonth = tomorrow.get(Calendar.MONTH) +1
        tomorrowYear = tomorrow.get(Calendar.YEAR)

    }


    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.N)
    private fun showDatePickerDialog(tvFechaSeleccionada: TextView, fecha1 : TextView, fecha2 : TextView, fecha3 : TextView) {
        val today = Calendar.getInstance()
        val datePicker = DatePickerDialog(
                this,
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            selectedYear = year
            selectedMonth = month.plus(1)
            selectedDay = dayOfMonth
            tvFechaSeleccionada.setText("$selectedDay del $selectedMonth de $selectedYear")

            selectedDayManual = selectedDay
            selectedMonthManual = selectedMonth
            selectedYearManual = selectedYear



            selectedDate.set(Calendar.YEAR, year)
            selectedDate.set(Calendar.MONTH, month)
            selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            updateFecha(selectedDate)

            actualizarYesterdayTomorrow()


            fecha1.setText("$yesterdayDay/$yesterdayMonth")
            fecha2.setText("$selectedDay/$selectedMonth")
            fecha3.setText("$tomorrowDay/$tomorrowMonth")



        },

            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)


        )

        datePicker.show()


    }



    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateFecha(selectedDate : Calendar){
        fecha = selectedDate.time
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun actualizarYesterdayTomorrow(){

        today = selectedDate.apply { add(Calendar.DATE,0) }
        todayDay = today.get(Calendar.DAY_OF_MONTH)
        todayMonth = today.get(Calendar.MONTH) +1
        todayYear = today.get(Calendar.YEAR)


        yesterday = selectedDate.apply { add(Calendar.DATE, -1) }
        yesterdayDay = yesterday.get(Calendar.DAY_OF_MONTH)
        yesterdayMonth = yesterday.get(Calendar.MONTH) +1
        yesterdayYear = yesterday.get(Calendar.YEAR)

        tomorrow= selectedDate.apply { add(Calendar.DATE, 2) }
        tomorrowDay = tomorrow.get(Calendar.DAY_OF_MONTH)
        tomorrowMonth = tomorrow.get(Calendar.MONTH) + 1
        tomorrowYear = tomorrow.get(Calendar.YEAR)


    }




}