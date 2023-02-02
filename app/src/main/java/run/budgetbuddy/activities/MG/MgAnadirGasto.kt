package run.budgetbuddy.activities.MG

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
import run.budgetbuddy.databinding.MgAnadirGastoBinding
import java.time.Year

class MgAnadirGasto : AppCompatActivity() {

    private lateinit var binding: MgAnadirGastoBinding

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgAnadirGastoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        valoresAyerHoyPredeterminados()


        var tvFechaSeleccionada = binding.tvFechaSeleccionada
        var btnFecha1 = binding.btnFecha1
        var btnFecha2 = binding.btnFecha2
        var btnFecha3 = binding.btnFecha3


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
            SystemClock.sleep(5000)
            Toast.makeText(
                this, "Se ha añadido un nuevo gasto", Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
            finish()
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
            }

            tvFechaSeleccionada.setText("$selectedDayManual del $selectedMonthManual de $selectedYearManual")
        }

        binding.btnFecha3.setOnClickListener {

            selectedDayManual = tomorrowDay
            selectedMonthManual = tomorrowMonth
            selectedYearManual = tomorrowYear

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

            actualizarYestardayTomorrow()


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
    private fun actualizarYestardayTomorrow(){

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