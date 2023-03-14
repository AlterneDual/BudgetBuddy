package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.DivisaCRUD
import CRUD.GastoCRUD
import adapter.MyRecycler_Adapter
import adapter.myListAdapter_categorias
import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.data.DataSet.Rounding
import models.Categoria
import models.Divisa
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.adapter.OnItemClickListener
import run.budgetbuddy.databinding.MgAnadirGastoBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.properties.Delegates

class MgAnadirGasto : AppCompatActivity() {

    private lateinit var binding: MgAnadirGastoBinding

    var categoriaCRUD: CategoriaCRUD = CategoriaCRUD()
    var divisaCrud: DivisaCRUD = DivisaCRUD()
    var gastoCrud: GastoCRUD = GastoCRUD()
    var categoriaAtributo: Categoria? = null
    private lateinit var recycler_view: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<MyRecycler_Adapter.ViewHolder>
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
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

    lateinit var sharedPreferences: SharedPreferences
    private val TRABAJAR_INGRESOS = "trabajarIngresos"
    private val KEY = "prefs"
    var trabajar_ingresos by Delegates.notNull<Int>()

    @RequiresApi(Build.VERSION_CODES.N)
    var fechaGasto = selectedDate.time

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgAnadirGastoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(KEY, MODE_PRIVATE)
        trabajar_ingresos = sharedPreferences.getInt(TRABAJAR_INGRESOS, 1)

        listaCategorias = categoriaCRUD.getAllCategoria()
        inicializarAdapter()
        resetSelectedItem()
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

        if (trabajar_ingresos == 0) {
            btnIngreso.setOnClickListener {
                val intent = Intent(this, MgAnadirIngreso::class.java)
                startActivity(intent)
                overridePendingTransition(R.drawable.slide_out_left, R.drawable.slide_out_right)
            }
        } else if (trabajar_ingresos == 1) {
            btnIngreso.setOnClickListener {
                Toast.makeText(
                    applicationContext,
                    "Opcion de trabajar con Ingresos no se encuentra seleccionada. Por favor acceda a Ajustes -> Ver el saldo de mi cuenta -> Activado",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        binding.btnAnadir.setOnClickListener {

            var div = Divisa()
            div.nombre = "Euro"
            div.simbolo = "€"
            var keyDiv = divisaCrud.addDivisa(div)

            var gasto = Gasto()
            if (etCantidad.text != null && fechaGasto != null && categoriaAtributo != null && descripttion.text != null) {
                if (etCantidad.text.toString() != "" && descripttion.text.toString() != "" && etCantidad.text.toString() != ".") {
                    val value_input = etCantidad.text.toString().toDouble()
                    if (value_input > 0.0) {
                        gasto.categoria = categoriaAtributo
                        gasto.divisa = divisaCrud.getDivisa(keyDiv)

                        val conf_value = (Math.round(value_input * 100) / 100.0)
                        gasto.importe = conf_value
                        gasto.fecha = fechaGasto
                        gasto.descripcion = descripttion.text.toString()
                        gastoCrud.addGasto(gasto)
                        val intent = Intent(this, MgInicio::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this,
                            "La cantidad debe ser superior a 0",
                            Toast.LENGTH_LONG
                        ).show()
                    }

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

    private fun resetSelectedItem() {
        MyRecycler_Adapter.selectedItem = -1
        mAdapter.notifyDataSetChanged()
    }

    private fun inicializarAdapter() {

        recycler_view = findViewById(R.id.rvCategorias)
        mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mAdapter = MyRecycler_Adapter(listaCategorias, object : OnItemClickListener {
            override fun OnItemClick(vista: View, position: Int) {
                categoriaAtributo = listaCategorias[position]

                MyRecycler_Adapter.selectedItem = position
                mAdapter.notifyDataSetChanged()
            }
        })

        recycler_view.adapter = mAdapter
        recycler_view.setHasFixedSize(true)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = mLayoutManager
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
            if (trabajar_ingresos == 0) {
                if (e2.x < e1.x) {
                    val intent = Intent(this@MgAnadirGasto, MgAnadirIngreso::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.drawable.slide_out_left, R.drawable.slide_out_right)
                }
            } else if (trabajar_ingresos == 1) {
                Toast.makeText(
                    applicationContext,
                    "Opcion de trabajar con Ingresos no se encuentra seleccionada. Por favor acceda a Ajustes -> Ver el saldo de mi cuenta -> Activado",
                    Toast.LENGTH_LONG
                ).show()
            }
            return true
        }
    }
}