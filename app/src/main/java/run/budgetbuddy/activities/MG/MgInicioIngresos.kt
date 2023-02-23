package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.IngresoCRUD
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.GestureDetector
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF
import com.google.android.material.navigation.NavigationView
import models.Categoria
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.activities.ajustes.Ajustes
import run.budgetbuddy.activities.categoria.Categorias
import run.budgetbuddy.activities.divisa.Divisas
import run.budgetbuddy.activities.menu.MenuLateralMG
import run.budgetbuddy.adapter.myListAdapter_gasto
import run.budgetbuddy.adapter.myListAdapter_ingreso
import run.budgetbuddy.databinding.MgInicioGastosBinding
import run.budgetbuddy.databinding.MgInicioIngresosBinding
import run.budgetbuddy.model.Ingreso
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar
import java.util.Locale

class MgInicioIngresos : AppCompatActivity() {

    private lateinit var binding: MgInicioIngresosBinding
    private lateinit var adapter: myListAdapter_ingreso
    private var listaIngresosBD = mutableListOf<Ingreso>()
    var ic = IngresoCRUD()
    private var seleccionado: Int = 0;
    private lateinit var gestos: GestureDetector

    //    private var lista_colores: ArrayList<Int> = ArrayList()
    //----------------------------------Atributos y metodos Menu lateral----------------------------------
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    //----------------------------------Atributos y metodos Menu lateral----------------------------------

    val color_list = mutableListOf<Int>(
        Color.parseColor("#4eb4e4"),
        Color.parseColor("#791eed"),
        Color.parseColor("#56b73c"),
        Color.parseColor("#83e8d3"),
        Color.parseColor("#7899a3"),
        Color.parseColor("#c054ec"),
        Color.parseColor("#8c00a4"),
        Color.parseColor("#0b01c2"),
        Color.parseColor("#bfbb13"),
        Color.parseColor("#5c5ae5"),
        Color.parseColor("#d08b2e"),
        Color.parseColor("#6c719b"),
        Color.parseColor("#f7bc91"),
        Color.parseColor("#6b5d6e"),
        Color.parseColor("#c30c7f"),
        Color.parseColor("#de12f8"),
        Color.parseColor("#2c56e2"),
        Color.parseColor("#a40c88"),
        Color.parseColor("#09b8f9"),
        Color.parseColor("#03e524"),
        Color.parseColor("#ab20c4"),
        Color.parseColor("#e4c4f4"),
        Color.parseColor("#4a2c4e"),
        Color.parseColor("#f2c9d1"),
        Color.parseColor("#0a0c60"),
        Color.parseColor("#bc1667"),
        Color.parseColor("#84c0d3"),
        Color.parseColor("#e0e3f3"),
        Color.parseColor("#9d9776"),
        Color.parseColor("#7b85f3"),
        Color.parseColor("#3c2e08"),
        Color.parseColor("#d5f5d5"),
        Color.parseColor("#c98f95"),
        Color.parseColor("#e7d5dc"),
        Color.parseColor("#5b50f6"),
        Color.parseColor("#a6bced"),
        Color.parseColor("#c0ff1d"),
        Color.parseColor("#caed84"),
        Color.parseColor("#48a8a8"),
        Color.parseColor("#6b7c0a"),
        Color.parseColor("#757772"),
        Color.parseColor("#3d3d04"),
        Color.parseColor("#71c52a"),
        Color.parseColor("#b56e6d"),
        Color.parseColor("#0f7f9e"),
        Color.parseColor("#18245f"),
        Color.parseColor("#8ee2a1"),
        Color.parseColor("#84c6f7"),
        Color.parseColor("#734c8a"),
        Color.parseColor("#87645a"),
        Color.parseColor("#853676"),
        Color.parseColor("#6b3f3b"),
        Color.parseColor("#6e3012"),
        Color.parseColor("#f1d69b"),
        Color.parseColor("#e7d6af"),
        Color.parseColor("#1972aa"),
        Color.parseColor("#dfc8e7"),
        Color.parseColor("#93787a"),
        Color.parseColor("#f7aa67"),
        Color.parseColor("#3d3877"),
        Color.parseColor("#9eb1a4"),
        Color.parseColor("#e4b8e4"),
        Color.parseColor("#4a5c97"),
        Color.parseColor("#40a0d8"),
        Color.parseColor("#5f5a9a"),
        Color.parseColor("#b5e4c4"),
        Color.parseColor("#4d4b95"),
        Color.parseColor("#5e5fc5"),
        Color.parseColor("#8f2e1b"),
        Color.parseColor("#c2be79"),
        Color.parseColor("#f8c7af"),
        Color.parseColor("#eebeca")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInicioIngresosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //-------------------------------------------Menu lateral-------------------------------------------
        //Inicializar drawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Declarar la toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbarA)

        // Configurar la toolbar
        setSupportActionBar(toolbar)

        // Agregar el icono de hamburguesa y quitar titulo
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menu_button)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // El icono menu abre el desplegable
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val menu = navigationView.menu
        val nav_home1 = menu.findItem(R.id.nav_home)
        val nav_cat1 = menu.findItem(R.id.nav_edit_cat)
        val nav_div1 = menu.findItem(R.id.nav_divisa)
        val nav_ajustes1 = menu.findItem(R.id.nav_ajustes)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                nav_home1.itemId -> {
                    val intent = Intent(this, MgInicio::class.java)
                    startActivity(intent)
                    true
                }

                nav_cat1.itemId -> {
                    val intent = Intent(this, Categorias::class.java)
                    startActivity(intent)
                    true
                }

                nav_div1.itemId -> {
                    val intent = Intent(this, Divisas::class.java)
                    startActivity(intent)
                    true
                }

                nav_ajustes1.itemId -> {
                    val intent = Intent(this, Ajustes::class.java)
                    startActivity(intent)
                    true
                }

                else -> false

            }
        }


        //-------------------------------------------Menu lateral-------------------------------------------
        check()
        gestos = GestureDetector(this, EscuchaGestos())

        var btnGasto = binding.tvGastos
        btnGasto.setOnClickListener {
            val intent = Intent(this, MgInicio::class.java)
            startActivity(intent)
            overridePendingTransition(R.drawable.slide_out_left, R.drawable.slide_out_right)
        }

        var btnAnadirGasto = binding.btnAddGroup3
        btnAnadirGasto.setOnClickListener {
            val intent = Intent(this, MgAnadirIngreso::class.java)
            startActivity(intent)
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
            val intent = Intent(this, MgInfo::class.java)
            startActivity(intent)
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun verGrafico(ingresos: MutableList<Ingreso>) {
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
        pieChart.holeRadius = 50F

        pieChart.setDrawCenterText(true)

        var total: Float = 0.0F
        for (ing in ingresos) {
            total += (ing.importe).toFloat()
        }

        pieChart.centerText = "$total €"
        pieChart.setCenterTextColor(Color.parseColor("#FFFFFF"))
        pieChart.setCenterTextSize(20f)
        val tf: Typeface? = ResourcesCompat.getFont(this, R.font.oswald)
        pieChart.setCenterTextTypeface(tf)
        pieChart.rotationAngle = 0f
        pieChart.isRotationEnabled = false
        pieChart.isHighlightPerTapEnabled = false
        pieChart.animateY(1000, Easing.EaseInOutQuad)
        pieChart.legend.isEnabled = false
        pieChart.setEntryLabelColor(ContextCompat.getColor(this, R.color.transparent))
        pieChart.setEntryLabelTextSize(20f)

        val pieEntries = mutableListOf<PieEntry>()

        for (ing in listaIngresosBD) {
            pieEntries.add(PieEntry(ing.importe.toFloat(), ing.descripcion.toString()))
        }

        val dataSet = PieDataSet(pieEntries, "")
        dataSet.setDrawIcons(false)
        dataSet.setDrawValues(false)

        // Ajustes de Slice
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(10f, 40f)
        dataSet.selectionShift = 20f

        dataSet.colors = color_list

        val data = PieData(dataSet)
        data.setDrawValues(false)
        data.setValueFormatter(null)
        data.setValueTextSize(20.0F)

        data.setValueTypeface(Typeface.SANS_SERIF)
        data.setValueTextColor(Color.BLACK)
        pieChart.data = data

        pieChart.data = data
        pieChart.invalidate()
    }

    private fun IniciarAdapter() {
        val listView = binding.lvInicioIngreso
        listView.selector = ColorDrawable(Color.TRANSPARENT)

        adapter = myListAdapter_ingreso(this, listaIngresosBD, color_list)
        listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun verInfoDia(fecha_hoy: Date): MutableList<Ingreso> {
        var lista_gastos = ic.getAllingresos()
        var nueva_lista: MutableList<Ingreso> = mutableListOf()

        val format = SimpleDateFormat("dd/MM/yyyy")
        var date = format.format(fecha_hoy);

        for (g in lista_gastos) {
            val format = SimpleDateFormat("dd/MM/yyyy")
            var guardada = format.format(g.fecha);
            if (guardada.equals(date)) {
                nueva_lista.add(g)
            }
        }
        return nueva_lista
    }

    fun verInfoSemana(
        fecha_inicio: java.util.Date,
        fecha_final: java.util.Date
    ): MutableList<Ingreso> {
        return ic.getAllByDates(fecha_inicio, fecha_final)
    }

    fun verInfoMes(fecha_inicio: Date): MutableList<Ingreso> {
        var lista_gastos = ic.getAllingresos()
        var nueva_lista: MutableList<Ingreso> = mutableListOf()

        val format = SimpleDateFormat("MM/yyyy")
        var date = format.format(fecha_inicio);
        for (g in lista_gastos) {
            val format = SimpleDateFormat("MM/yyyy")
            var guardada = format.format(g.fecha);
            if (guardada.equals(date)) {
                nueva_lista.add(g)
            }
        }
        return nueva_lista
    }

    fun verInfoAno(ano: Date): MutableList<Ingreso> {
        var lista_gastos = ic.getAllingresos()
        var nueva_lista: MutableList<Ingreso> = mutableListOf()

        val format = SimpleDateFormat("yyyy")
        var date = format.format(ano);
        for (g in lista_gastos) {
            val format = SimpleDateFormat("yyyy")
            var guardada = format.format(g.fecha);
            if (guardada.equals(date)) {
                nueva_lista.add(g)
            }
        }
        return nueva_lista
    }

    fun verInfoPeriodo(
        fecha_inicio: java.util.Date,
        fecha_final: java.util.Date
    ): MutableList<Ingreso> {
        return ic.getAllByDates(fecha_inicio, fecha_final)
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
                binding.tvResultadoFecha.text = ("All")

                var ing = ic.getAllingresos()
                inicializarIngresos(ing)
                IniciarAdapter()
                verGrafico(ing)

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
                var ing = verInfoDia(Date.valueOf(LocalDate.now().toString()))
                inicializarIngresos(ing)
                IniciarAdapter()
                verGrafico(ing)
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
                val today = java.util.Date.from(
                    LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()
                )
                val cal = Calendar.getInstance()
                cal.time = today
                cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)
                val startOfWeek = cal.time
                cal.add(Calendar.DAY_OF_WEEK, 6)
                val endOfWeek = cal.time

                var ing = verInfoSemana(
                    startOfWeek,
                    endOfWeek
                )
                inicializarIngresos(ing)
                IniciarAdapter()
                verGrafico(ing)
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
                var ing = verInfoMes(Date.valueOf(LocalDate.now().toString()))
                inicializarIngresos(ing)
                IniciarAdapter()
                verGrafico(ing)

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
                var ing = verInfoAno(Date.valueOf(LocalDate.now().toString()))
                inicializarIngresos(ing)
                IniciarAdapter()
                verGrafico(ing)
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
//                var ing = verInfoPeriodo(Date.valueOf(LocalDate.now().toString()))
//                inicializarIngresos(ing)
//                IniciarAdapter()
//                verGrafico(ing)
//                adapter.notifyDataSetChanged()
            }

            else -> println("Default")
        }
    }


    private fun showDatePicker() {
        var startDate: Calendar? = null
        var endDate: Calendar? = null
        var startDateReal: Calendar? = null

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
                    set(Calendar.DAY_OF_MONTH, selectedDay.minus(1))
                }
                startDateReal = Calendar.getInstance().apply {
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
                                start = format.format(startDateReal!!.time)
                                end = format.format(endDate!!.time)


                                var ing = verInfoPeriodo(
                                    startDate!!.time,
                                    endDate!!.time
                                )
                                inicializarIngresos(ing)
                                IniciarAdapter()
                                verGrafico(ing)

                                binding.tvResultadoFecha.text =
                                    ("${start.toString()} - ${end.toString()}")
                            } else {
                                Toast.makeText(
                                    this,
                                    "Introduzca un Periodo que tenga sentido: Primero fecha inicial y Segundo fecha final",
                                    Toast.LENGTH_LONG
                                ).show()

                            }
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

    fun inicializarIngresos(gastos: MutableList<Ingreso>) {
        listaIngresosBD.clear()
        listaIngresosBD = gastos
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
                val intent = Intent(this@MgInicioIngresos, MgInicio::class.java)
                startActivity(intent)
                overridePendingTransition(0, R.drawable.slide_out_right)
                finish()
            }
            return true
        }
    }

}