package run.budgetbuddy.activities.MG

import CRUD.DivisaCRUD
import CRUD.IngresoCRUD
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import run.budgetbuddy.R
import models.Divisa
import run.budgetbuddy.databinding.MgAnadirIngresoBinding
import run.budgetbuddy.model.Ingreso

class MgAnadirIngreso : AppCompatActivity() {

    private lateinit var binding: MgAnadirIngresoBinding
    private lateinit var gestos: GestureDetector

    var divisaCrud: DivisaCRUD = DivisaCRUD()
    var ingresoCrud: IngresoCRUD = IngresoCRUD()

    var nombreMes: String = String()


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
    var fechaIngreso = selectedDate.time


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgAnadirIngresoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        valoresAyerHoyPredeterminados()

        var tvFechaSeleccionada2 = binding.tvFechaSeleccionada2
        var btnFecha6 = binding.btnFecha6
        var btnFecha7 = binding.btnFecha7
        var btnFecha8 = binding.btnFecha8
        var etCantidad2 = binding.etCantidad2
        var btnIngreso = binding.tvIngresos2
        var etComentario1 = binding.etComentario1

        nombreMes = nombreMeses(todayMonth.plus(1))[0]
        tvFechaSeleccionada2.setText("$todayDay de $nombreMes de $todayYear")

        nombreMes = nombreMeses(todayMonth.plus(1))[1]
        btnFecha6.setText("$yesterdayDay/$nombreMes")
        btnFecha7.setText("$todayDay/$nombreMes")
        btnFecha8.setText("$tomorrowDay/$nombreMes")

        gestos = GestureDetector(this, EscuchaGestos())

        var btnGastos = binding.tvGastos
        btnGastos.setOnClickListener {
            val intent = Intent(this, MgAnadirGasto::class.java)
            startActivity(intent)
            overridePendingTransition(0, R.drawable.slide_out_right)
        }

        binding.etComentario1.setOnClickListener {
            etComentario1.setText("")

        }
        binding.btnAnadir.setOnClickListener {


            var div = Divisa()
            div.nombre = "Euro"
            div.simbolo = "€"
            var keyDiv = divisaCrud.addDivisa(div)

            var ingreso = Ingreso()
            if (etCantidad2.text != null && fechaIngreso != null && etComentario1.text != null) {
                if (etCantidad2.text.toString() != "" && etComentario1.text.toString() != "") {
                    ingreso.divisa = divisaCrud.getDivisa(keyDiv)
                    ingreso.importe = etCantidad2.text.toString().toDouble()
                    ingreso.fecha = fechaIngreso
                    ingreso.descripcion = etComentario1.text.toString()
                    ingresoCrud.addIngreso(ingreso)
                    Toast.makeText(
                        this, "Añadido ingreso con fecha: ${ingreso.fecha}", Toast.LENGTH_SHORT
                    ).show()
//                    val intent = Intent(this, MgInicio::class.java)
//                    startActivity(intent)
//                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Por favor, rellene correctamente la descripcion y cantidad",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } else {
                Toast.makeText(
                    this,
                    "Por favor, rellene correctamente la Cantidad, descripcion, categoria y fecha",
                    Toast.LENGTH_LONG
                ).show()
            }


            println("-------------")
            println("------------")
            for (ing in ingresoCrud.getAllingresos()){
                print(ing.toString())
            }


        }

        binding.btnAtras4.setOnClickListener {
            val intent = Intent(this, MgInicioIngresos::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCalendario2.setOnClickListener {
            showDatePickerDialog(tvFechaSeleccionada2, btnFecha6, btnFecha7, btnFecha8)
        }

        binding.btnFecha6.setOnClickListener {
            btnFecha6.setBackgroundColor(resources.getColor(R.color.vidrian_light_green))
            btnFecha7.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            btnFecha8.setBackgroundColor(resources.getColor(R.color.vidrian_green))

            updateFecha(yesterday)
            nombreMes = nombreMeses(yesterdayMonth.plus(1))[0]
            tvFechaSeleccionada2.setText("$yesterdayDay de $nombreMes de $yesterdayYear")
        }

        binding.btnFecha7.setOnClickListener {
            btnFecha7.setBackgroundColor(resources.getColor(R.color.vidrian_light_green))
            btnFecha6.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            btnFecha8.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            updateFecha(today)
            nombreMes = nombreMeses(todayMonth.plus(1))[0]
            tvFechaSeleccionada2.setText("$todayDay de $nombreMes de $todayYear")
        }

        binding.btnFecha8.setOnClickListener {
            btnFecha8.setBackgroundColor(resources.getColor(R.color.vidrian_light_green))
            btnFecha6.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            btnFecha7.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            updateFecha(tomorrow)
            nombreMes = nombreMeses(yesterdayMonth.plus(1))[0]
            tvFechaSeleccionada2.setText("$tomorrowDay de $nombreMes de $tomorrowYear")
        }
    }

    fun nombreMeses(mes: Int): ArrayList<String> {

        var mesesCortoLargos = arrayListOf<String>()

        val monthNames = arrayOf(
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
        )
        val monthNumber = mes
        val monthName = monthNames[monthNumber - 1]
        mesesCortoLargos.add(monthName)

        val monthNames2 = arrayOf(
            "En",
            "Feb",
            "Mar",
            "Abr",
            "May",
            "Jun",
            "Jul",
            "Ago",
            "Sep",
            "Oct",
            "Nov",
            "Dic"
        )
        val monthNumber2 = mes
        val monthName2 = monthNames2[monthNumber2 - 1]
        mesesCortoLargos.add(monthName2)

        return mesesCortoLargos
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
    private fun updateFecha(new_fecha: Calendar) {
        fechaIngreso = new_fecha.time

    }

    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.N)
    private fun showDatePickerDialog(
        tvFechaSeleccionada22: TextView,
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

                nombreMes = nombreMeses(month.plus(1))[1]
                fecha1.setText("$yesterdayDay/$nombreMes")
                fecha2.setText("$todayDay/$nombreMes")
                fecha3.setText("$tomorrowDay/$nombreMes")

                nombreMes = nombreMeses(month.plus(1))[0]
                tvFechaSeleccionada22.setText("$dayOfMonth de $nombreMes de $year")

            },
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)

        )
        datePicker.show()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestos.onTouchEvent(event!!)
        return super.onTouchEvent(event)

    }

    inner class EscuchaGestos() : GestureDetector.SimpleOnGestureListener() {

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (e2.x > e1.x) {
                val intent = Intent(this@MgAnadirIngreso, MgAnadirGasto::class.java)
                startActivity(intent)
                overridePendingTransition(0, R.drawable.slide_out_right)
            }
            return true
        }
    }
}