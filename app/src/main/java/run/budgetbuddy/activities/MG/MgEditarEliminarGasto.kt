package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.GastoCRUD
import adapter.MyRecycler_Adapter
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.Categoria
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.adapter.OnItemClickListener
import run.budgetbuddy.databinding.MgEditarGastosBinding

class MgEditarEliminarGasto : AppCompatActivity() {
    private lateinit var binding: MgEditarGastosBinding
    private var gastoCRUD: GastoCRUD = GastoCRUD()
    private lateinit var listaCategorias: MutableList<Categoria>
    var categoriaAtributo: Categoria? = null
    private lateinit var recycler_view: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<MyRecycler_Adapter.ViewHolder>
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    var categoriaCRUD: CategoriaCRUD = CategoriaCRUD()
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
    var fechaGasto = selectedDate.time

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgEditarGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", 0)
        var gasto = gastoCRUD.getGasto(id)

        listaCategorias = categoriaCRUD.getAllCategoria()

        if (gasto != null) {
            binding.etNombreGasto.setText(gasto.descripcion)
            binding.etCantidad.setText(gasto.importe.toString())
            categoriaAtributo = gasto.categoria
            inicializarAdapter()
            var cont = 0
            for (cat in listaCategorias) {
                if (cat.id == categoriaAtributo?.id) {
                    MyRecycler_Adapter.selectedItem = cont
                    mAdapter.notifyDataSetChanged()
                }
                cont++
            }
        }

        valoresAyerHoyPredeterminados()

        var tvFechaSeleccionada = binding.tvFechaActual
        var btnFecha1 = binding.btnFecha1
        var btnFecha2 = binding.btnFecha2
        var btnFecha3 = binding.btnFecha3

        nombreMes = nombreMeses(todayMonth.plus(1))[0]
        tvFechaSeleccionada.setText("$todayDay de $nombreMes de $todayYear")

        nombreMes = nombreMeses(todayMonth.plus(1))[1]
        btnFecha1.setText("$yesterdayDay/$nombreMes")
        btnFecha2.setText("$todayDay/$nombreMes")
        btnFecha3.setText("$tomorrowDay/$nombreMes")

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

        binding.btnAtras2.setOnClickListener {
            val intent = Intent(this, MgInfo::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnEditar.setOnClickListener {
            val nombreGasto = binding.etNombreGasto.text.toString()
            val cantidad = binding.etCantidad.text.toString().toDoubleOrNull()
            var gastoTemp = Gasto()
            if (nombreGasto.isNotBlank() && cantidad != null && categoriaAtributo != null) {
                if (gasto != null) {
                    gastoTemp.descripcion = nombreGasto
                    gastoTemp.importe = cantidad
                    gastoTemp.categoria = categoriaAtributo
                    gastoTemp.fecha = fechaGasto
                    gastoCRUD.updateGasto(gastoTemp)
                    val intent = Intent(this, MgInfo::class.java)
                    startActivity(intent)
                    finish()
                }

            } else {
                Toast.makeText(
                    this,
                    "Por favor, introduce un nombre y una cantidad válida",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnEliminar1.setOnClickListener {
            gastoCRUD.deleteGasto(id)

            val intent = Intent(this, MgInfo::class.java)
            startActivity(intent)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateFecha(new_fecha: Calendar) {
        fechaGasto = new_fecha.time
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

}
