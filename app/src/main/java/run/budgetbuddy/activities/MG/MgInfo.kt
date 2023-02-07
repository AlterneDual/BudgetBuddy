package run.budgetbuddy.activities.MG

import CRUD.GastoCRUD
import adapter.myListAdapter_menu_Lateral
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.widget.ListView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import models.Categoria
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.databinding.MgInfoBinding
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import run.budgetbuddy.adapter.*

class MgInfo : AppCompatActivity() {
    private lateinit var binding: MgInfoBinding
    private var seleccionado: Int = 1;
    var gc: GastoCRUD = GastoCRUD()
    private lateinit var list_view: ListView
    private lateinit var adapterList: myListAdapterInfoGasto


    //    private lateinit var sharedPreferences: SharedPreferences


    private var MYGESTORVIEWINGRESOS_SETTING = "MyGestorView"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        check()

        binding.textView.isVisible = false;
        binding.tvSaldoRestante.isVisible = false;
        binding.textView10.isVisible = false
        binding.tvIngresos.isVisible = false

//        if (sharedPreferences.getBoolean(MYGESTORVIEWINGRESOS_SETTING, false)) {
        var lista_gastos = gc.getAllGastos();
        inicializarAdapter()

        println("******************************************************************************************************************")
        for (g in lista_gastos) {
            println(g.toString())
        }
        println("******************************************************************************************************************")

        var total: Double = 0.0;
        for (l in lista_gastos) {
            total += l.importe;
        }

        binding.tvGastos.text = total.toString() + " €";
//        }


        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvDia.setOnClickListener {
            seleccionado = 1;

            check()
        }

        binding.tvSemana.setOnClickListener {
            seleccionado = 2;

            check()
        }
        binding.tvMes.setOnClickListener {
            seleccionado = 3;
            check()
        }
        binding.tvAnho.setOnClickListener {
            seleccionado = 4;
            check()
        }
        binding.tvPeriodo.setOnClickListener {
            seleccionado = 5;
            check()
        }


    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun check() {

        // Colores
        var green = resources.getColor(R.color.vidrian_green)
        var white = resources.getColor(R.color.white)

        var calendar = Calendar.getInstance()


        when (seleccionado) {
            1 -> {
                var dia_num = calendar.get(Calendar.DAY_OF_MONTH)
                var dia = calendar.getDisplayName(
                    Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()
                )
                binding.tvDia.setTextColor(green)
                binding.tvDia.paintFlags = binding.tvPeriodo.paintFlags or Paint.UNDERLINE_TEXT_FLAG

                binding.tvSemana.setTextColor(white)
                binding.tvSemana.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvMes.setTextColor(white)
                binding.tvMes.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvAnho.setTextColor(white)
                binding.tvAnho.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvPeriodo.setTextColor(white)
                binding.tvPeriodo.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
                binding.tvResultadoFecha.text = ("$dia_num $dia")

            }

            2 -> {
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
                val firstDay = calendar.get(Calendar.DAY_OF_MONTH)
                var firstDay_name = calendar.getDisplayName(
                    Calendar.MONTH, Calendar.SHORT, Locale.getDefault()
                )

                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
                val lastDay = calendar.get(Calendar.DAY_OF_MONTH)
                var lastDay_name = calendar.getDisplayName(
                    Calendar.MONTH, Calendar.SHORT, Locale.getDefault()
                )

                binding.tvResultadoFecha.text = ("$firstDay$firstDay_name - $lastDay$lastDay_name")

                binding.tvSemana.setTextColor(green)
                binding.tvSemana.paintFlags =
                    binding.tvPeriodo.paintFlags or Paint.UNDERLINE_TEXT_FLAG

                binding.tvDia.setTextColor(white)
                binding.tvDia.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvMes.setTextColor(white)
                binding.tvMes.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvAnho.setTextColor(white)
                binding.tvAnho.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvPeriodo.setTextColor(white)
                binding.tvPeriodo.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            }

            3 -> {

                var month_name = calendar.getDisplayName(
                    Calendar.MONTH, Calendar.LONG, Locale.getDefault()
                )
                binding.tvResultadoFecha.text = ("${month_name.uppercase()}")

                binding.tvMes.setTextColor(green)
                binding.tvMes.paintFlags = binding.tvPeriodo.paintFlags or Paint.UNDERLINE_TEXT_FLAG

                binding.tvDia.setTextColor(white)
                binding.tvDia.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvSemana.setTextColor(white)
                binding.tvSemana.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvAnho.setTextColor(white)
                binding.tvAnho.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvPeriodo.setTextColor(white)
                binding.tvPeriodo.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            }

            4 -> {
                var year_name = calendar.get(Calendar.YEAR)
                binding.tvResultadoFecha.text = ("${year_name.toString()}")

                binding.tvAnho.setTextColor(green)
                binding.tvAnho.paintFlags =
                    binding.tvPeriodo.paintFlags or Paint.UNDERLINE_TEXT_FLAG

                binding.tvDia.setTextColor(white)
                binding.tvDia.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvSemana.setTextColor(white)
                binding.tvSemana.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvMes.setTextColor(white)
                binding.tvMes.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvPeriodo.setTextColor(white)
                binding.tvPeriodo.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            }

            5 -> {
                showDatePicker()
                binding.tvPeriodo.setTextColor(green)
                binding.tvPeriodo.paintFlags =
                    binding.tvPeriodo.paintFlags or Paint.UNDERLINE_TEXT_FLAG

                binding.tvDia.setTextColor(white)
                binding.tvDia.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvSemana.setTextColor(white)
                binding.tvSemana.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvMes.setTextColor(white)
                binding.tvMes.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

                binding.tvAnho.setTextColor(white)
                binding.tvAnho.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            }

            else -> println("Default")
        }
    }


    fun verInfoDia(fecha_hoy: Date) {
    }

    fun verInfoSemana(fecha_inicio: Date, fecha_final: Date) {
    }

    fun verInfoMes(fecha_inicio: Date, fecha_fin: Date) {
    }

    fun verInfoAno(ano: Date) {
    }

    fun verInfoPeriodo(fecha_a: Date, fecha_b: Date) {
    }

    private fun showDatePicker() {
        var startDate: Calendar? = null
        var endDate: Calendar? = null

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val startDatePicker = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                startDate = Calendar.getInstance().apply {
                    set(Calendar.YEAR, selectedYear)
                    set(Calendar.MONTH, selectedMonth)
                    set(Calendar.DAY_OF_MONTH, selectedDay)
                }

                val endDatePicker = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                        endDate = Calendar.getInstance().apply {
                            set(Calendar.YEAR, selectedYear)
                            set(Calendar.MONTH, selectedMonth)
                            set(Calendar.DAY_OF_MONTH, selectedDay)
                        }

                        if (startDate != null && endDate != null) {
                            val format = SimpleDateFormat("dd/MM", Locale.getDefault())
                            var start = ""
                            var end = ""
                            if (startDate!!.time <= endDate!!.time) {
                                start = format.format(startDate!!.time)
                                end = format.format(endDate!!.time)
                            } else {
                                var storeData = endDate
                                endDate = startDate
                                startDate = storeData
                                start = format.format(startDate!!.time)
                                end = format.format(endDate!!.time)
                            }
                            binding.tvResultadoFecha.text =
                                ("${start.toString()} - ${end.toString()}")
                        }
                    },
                    selectedYear,
                    selectedMonth,
                    selectedDay
                )
                endDatePicker.show()
            },
            year,
            month,
            dayOfMonth
        )
        startDatePicker.show()
    }

    private fun inicializarAdapter() {
        var lista_gastos = gc.getAllGastos()
        var lista_categorias = mutableListOf<Categoria>()

        for(g in lista_gastos){
            var cat_temp = g.categoria
            for(cat in lista_categorias){

            }
        }

        list_view = findViewById<ListView>(R.id.lista_gastos)
        adapterList =
            myListAdapterInfoGasto(this, R.layout.mg_info_gasto_ingreso_row, distintos_gastos)
        list_view.adapter = adapterList
        registerForContextMenu(list_view)
    }


}