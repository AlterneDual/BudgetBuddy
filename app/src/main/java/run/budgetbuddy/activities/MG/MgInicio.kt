package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.DivisaCRUD
import CRUD.GastoCRUD
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF
import io.realm.RealmList
import models.Categoria
import models.Divisa
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.adapter.myListAdapter_gasto
import run.budgetbuddy.databinding.MgInicioGastosBinding
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Locale

class MgInicio : AppCompatActivity() {

    private lateinit var binding: MgInicioGastosBinding
    private lateinit var adapter: myListAdapter_gasto
    var listagastosBD: RealmList<Gasto> = RealmList()
    var gastoCRUD = GastoCRUD()
    private var seleccionado: Int = 1;


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInicioGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        IniciarAdapter()
        GetAllGastos()
        verGrafico()


        var btnIngresos = binding.tvIngresos
        btnIngresos.setOnClickListener {
            val intent = Intent(this, MgInicioIngresos::class.java)
            startActivity(intent)
            finish()
        }
        var btnAnadirGasto = binding.btnAddGroup2
        btnAnadirGasto.setOnClickListener {
            val intent = Intent(this, MgAnadirGasto::class.java)
            startActivity(intent)
            finish()
        }
        var btnAjustes = binding.btnMenu1
        btnAjustes.setOnClickListener {
            val intent = Intent(this, MenuLateralMG::class.java)
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

        binding.butInfo.setOnClickListener {
            GetAllGastos()
            val intent = Intent(this, MgInfo::class.java)
            startActivity(intent)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun verGrafico() {
        val pieChart = findViewById<PieChart>(R.id.pieChart)
        pieChart.setUsePercentValues(false)
        pieChart.description.isEnabled = false
        pieChart.setExtraOffsets(0f, 0f, 0f, 0f)
        pieChart.dragDecelerationFrictionCoef = 10f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.TRANSPARENT)
        pieChart.setTransparentCircleColor(Color.TRANSPARENT)
        pieChart.setTransparentCircleAlpha(0)
        pieChart.transparentCircleRadius = 40F
        pieChart.holeRadius = 35F

        pieChart.setDrawCenterText(true)
        pieChart.centerText = "Hola"
        pieChart.rotationAngle = 0f
        pieChart.isRotationEnabled = false
        pieChart.isHighlightPerTapEnabled = false
        pieChart.animateY(1400, Easing.EaseInOutQuad)
        pieChart.legend.isEnabled = true
        pieChart.setEntryLabelColor(ContextCompat.getColor(this, R.color.transparent))
        pieChart.setEntryLabelTextSize(12f)

        var elementos: HashMap<Categoria, Float> = HashMap()
        var gastos = gastoCRUD.getAllGastos()
        for (g in gastos) {
            var cat_temp = g.categoria
            var total: Float = 0.0F
            if (elementos.isNotEmpty() && elementos[cat_temp] != null) {
                total = elementos[cat_temp]!!
                if (cat_temp != null) {
                    elementos.replace(cat_temp, (total + g.importe).toFloat())
                }

            } else {
                if (cat_temp != null) {
                    elementos[cat_temp] = g.importe.toFloat()
                }
            }
        }
        val pieEntries = mutableListOf<PieEntry>()
        val colors: ArrayList<Int> = ArrayList()

        for (el in elementos) {
            pieEntries.add(PieEntry(el.value, el.key.nombre))
            colors.add(el.key.color)
        }

        val dataSet = PieDataSet(pieEntries, "")
        dataSet.setDrawIcons(false)
        dataSet.setDrawValues(false)
        dataSet.valueTextSize = 10f

        // Ajustes de Slice
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(10f, 40f)
        dataSet.selectionShift = 10f

        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setDrawValues(true)
        data.setValueFormatter(null)
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.SANS_SERIF)
        data.setValueTextColor(Color.BLACK)
        pieChart.data = data

//        val pieDataSet = PieDataSet(pieEntries, "")
//        pieDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
//
//        val pieData = PieData(pieDataSet)

        pieChart.data = data
        pieChart.invalidate()
    }


    private fun IniciarAdapter() {


        val listView = binding.lvInicioGastos
        adapter = myListAdapter_gasto(this, listagastosBD)
        listView.adapter = adapter
    }

    private fun GetAllGastos() {
        for (gasto in gastoCRUD.getAllGastos()) {
            listagastosBD.add(gasto)
            adapter.notifyDataSetChanged()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun check() {

        // Colores
        var green = resources.getColor(R.color.vidrian_green)
        var white = resources.getColor(R.color.white)
        var calendar = Calendar.getInstance()


        when (seleccionado) {
            0 -> {
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

                binding.tvPeriodo.setTextColor(white)
                binding.tvPeriodo.paintFlags =
                    binding.tvPeriodo.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
                binding.tvResultadoFecha.text = ("Todos")


            }

            1 -> {
                var dia_num = calendar.get(Calendar.DAY_OF_MONTH)
                var dia = calendar.getDisplayName(
                    Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()
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
                binding.tvResultadoFecha.text = ("${dia.uppercase()} $dia_num")


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


}