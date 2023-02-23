package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.DivisaCRUD
import CRUD.GastoCRUD
import adapter.myListAdapter_categorias
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.GridView
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

    var categoriaCRUD: CategoriaCRUD = CategoriaCRUD()
    var divisaCrud: DivisaCRUD = DivisaCRUD()
    var gastoCrud: GastoCRUD = GastoCRUD()
    var categoriaAtributo: Categoria? = null
    private lateinit var adapterList: myListAdapter_categorias
    private lateinit var grid_view: GridView
    private lateinit var listaCategorias: MutableList<Categoria>
    var nombreMes: String = String()
    private lateinit var gestos: GestureDetector


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

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgAnadirGastoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaCategorias = categoriaCRUD.getAllCategoria()
        inicializarAdapter()
        configurarSeleccion()
        gestos = GestureDetector(this, EscuchaGestos())

        valoresAyerHoyPredeterminados()

        var tvFechaSeleccionada = binding.tvFechaSeleccionada
        var btnFecha1 = binding.btnFecha1
        var btnFecha2 = binding.btnFecha2
        var btnFecha3 = binding.btnFecha3
        var etCantidad = binding.etCantidad
        var btnIngreso = binding.tvIngresos
        var descripttion = binding.descriptionText

        nombreMes = nombreMeses(todayMonth.plus(1))[0]
        tvFechaSeleccionada.setText("$todayDay de $nombreMes de $todayYear")

        nombreMes = nombreMeses(todayMonth.plus(1))[1]
        btnFecha1.setText("$yesterdayDay/$nombreMes")
        btnFecha2.setText("$todayDay/$nombreMes")
        btnFecha3.setText("$tomorrowDay/$nombreMes")

        btnIngreso.setOnClickListener {
            val intent = Intent(this, MgAnadirIngreso::class.java)
            startActivity(intent)
            overridePendingTransition(R.drawable.slide_out_left, R.drawable.slide_out_right)
        }

        binding.btnAnadir.setOnClickListener {

            var div = Divisa()
            div.nombre = "Euro"
            div.simbolo = "€"
            var keyDiv = divisaCrud.addDivisa(div)

            var gasto = Gasto()
            if (etCantidad.text != null && fechaGasto != null && categoriaAtributo != null && descripttion.text != null) {
                if (etCantidad.text.toString() != "" && descripttion.text.toString() != "") {
                    gasto.categoria = categoriaAtributo
                    gasto.divisa = divisaCrud.getDivisa(keyDiv)
                    gasto.importe = etCantidad.text.toString().toDouble()
                    gasto.fecha = fechaGasto
                    gasto.descripcion = descripttion.text.toString()
                    gastoCrud.addGasto(gasto)
                    val intent = Intent(this, MgInicio::class.java)
                    startActivity(intent)
                    finish()
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





        }

        binding.btnAtras3.setOnClickListener {
            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
        }

        binding.btnCalendario.setOnClickListener {
            showDatePickerDialog(tvFechaSeleccionada, btnFecha1, btnFecha2, btnFecha3)
        }

        binding.btnFecha1.setOnClickListener {
            btnFecha1.setBackgroundColor(resources.getColor(R.color.vidrian_light_green))
            btnFecha2.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            btnFecha3.setBackgroundColor(resources.getColor(R.color.vidrian_green))

            updateFecha(yesterday)
            nombreMes = nombreMeses(yesterdayMonth.plus(1))[0]
            tvFechaSeleccionada.setText("$yesterdayDay de $nombreMes de $yesterdayYear")

        }

        binding.btnFecha2.setOnClickListener {
            btnFecha2.setBackgroundColor(resources.getColor(R.color.vidrian_light_green))
            btnFecha1.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            btnFecha3.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            updateFecha(today)
            nombreMes = nombreMeses(todayMonth.plus(1))[0]
            tvFechaSeleccionada.setText("$todayDay de $nombreMes de $todayYear")

        }

        binding.btnFecha3.setOnClickListener {
            btnFecha3.setBackgroundColor(resources.getColor(R.color.vidrian_light_green))
            btnFecha1.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            btnFecha2.setBackgroundColor(resources.getColor(R.color.vidrian_green))
            updateFecha(tomorrow)
            nombreMes = nombreMeses(yesterdayMonth.plus(1))[0]
            tvFechaSeleccionada.setText("$tomorrowDay de $nombreMes de $tomorrowYear")

        }

    }

    private fun inicializarAdapter() {

        grid_view = binding.gvCategorias
        adapterList =
            myListAdapter_categorias(this, R.layout.custom_grid_categorias, listaCategorias)
        grid_view.adapter = adapterList
        registerForContextMenu(grid_view)
    }

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

                nombreMes = nombreMeses(month.plus(1))[1]
                fecha1.setText("$yesterdayDay/$nombreMes")
                fecha2.setText("$todayDay/$nombreMes")
                fecha3.setText("$tomorrowDay/$nombreMes")

                nombreMes = nombreMeses(month.plus(1))[0]
                tvFechaSeleccionada.setText("$dayOfMonth de $nombreMes de $year")

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


    fun configurarSeleccion() {

        binding.gvCategorias.setOnItemClickListener() { adapterView, view, position, id ->

            adapterList.selectedItem = position

            adapterList.notifyDataSetChanged()

            categoriaAtributo = listaCategorias[position]
        }

        registerForContextMenu(binding.gvCategorias)
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
            if (e2.x < e1.x) {
                val intent = Intent(this@MgAnadirGasto, MgAnadirIngreso::class.java)
                startActivity(intent)
                overridePendingTransition(R.drawable.slide_out_left, R.drawable.slide_out_right)
            }
            return true
        }
    }
}