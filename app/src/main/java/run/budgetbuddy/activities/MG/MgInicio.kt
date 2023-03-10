package run.budgetbuddy.activities.MG

import CRUD.CategoriaCRUD
import CRUD.GastoCRUD
import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.MPPointF
import models.Categoria
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.adapter.myListAdapter_gasto
import run.budgetbuddy.databinding.MgInicioGastosBinding
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Locale
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import run.budgetbuddy.activities.ajustes.Ajustes
import run.budgetbuddy.activities.categoria.Categorias
import java.time.ZoneId
import kotlin.properties.Delegates

class MgInicio : AppCompatActivity() {

    private lateinit var binding: MgInicioGastosBinding
    private lateinit var adapter: myListAdapter_gasto
    private var listagastosBD: HashMap<Categoria, Float> = HashMap()
    var gc = GastoCRUD()
    private var seleccionado: Int = 0;
    private lateinit var gestos: GestureDetector
    private lateinit var listaCategorias: MutableList<Categoria>
    var categoriaCRUD: CategoriaCRUD = CategoriaCRUD()

    lateinit var sharedPreferences: SharedPreferences
    private val TRABAJAR_INGRESOS = "trabajarIngresos"
    private val KEY = "prefs"
    var trabajar_ingresos by Delegates.notNull<Int>()


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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MgInicioGastosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(KEY, MODE_PRIVATE)
        trabajar_ingresos = sharedPreferences.getInt(TRABAJAR_INGRESOS, MODE_PRIVATE)


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
        listaCategorias = crearCategorias()
        rellenar_bd_categorias()
        gestos = GestureDetector(this, EscuchaGestos())

        var btnIngresos = binding.tvIngresos
        btnIngresos.setOnClickListener {
            if (trabajar_ingresos == 0) {
                val intent = Intent(this, MgInicioIngresos::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                overridePendingTransition(0, 0)
                startActivity(intent)
            } else if (trabajar_ingresos == 1) {
                Toast.makeText(
                    this,
                    "Opcion de trabajar con Ingresos no se encuentra seleccionada. Por favor acceda a Ajustes -> Ver el saldo de mi cuenta -> Activado",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        var btnAnadirGasto = binding.btnAddGroup3
        btnAnadirGasto.setOnClickListener {
            val intent = Intent(this, MgAnadirGasto::class.java)
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
    private fun verGrafico(gastos: MutableList<Gasto>) {
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
        for (g in gastos) {
            total += (g.importe).toFloat()
        }
        pieChart.setCenterTextColor(Color.parseColor("#FFFFFF"))
        val conf_value = (Math.round(total * 100) / 100.0)
        pieChart.centerText = "$conf_value ???"
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

        var elementos: HashMap<Categoria, Float> = HashMap()
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
        var colors: ArrayList<String> = ArrayList()

        for (el in elementos) {
            pieEntries.add(PieEntry(el.value, el.key.nombre))
            colors.add(el.key.color_hex)
        }

        val dataSet = PieDataSet(pieEntries, "")
        dataSet.setDrawIcons(false)
        dataSet.setDrawValues(false)

        // Ajustes de Slice
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(10f, 40f)
        dataSet.selectionShift = 20f

        var colors_parsed: ArrayList<Int> = ArrayList()
        for (col in colors) {
            colors_parsed.add(Color.parseColor(col))
        }
        dataSet.colors = colors_parsed

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
        val listView = binding.lvInicioGastos
        listView.selector = ColorDrawable(Color.TRANSPARENT)

        var gsts: ArrayList<Categoria> = ArrayList()
        var cant: ArrayList<Float> = ArrayList()
        for (g in listagastosBD) {
            gsts.add(g.key)
            cant.add(g.value)
        }
        adapter = myListAdapter_gasto(this, gsts, cant)
        listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun verInfoDia(fecha_hoy: Date): MutableList<Gasto> {
        var lista_gastos = gc.getAllGastos()
        var nueva_lista: MutableList<Gasto> = mutableListOf()

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
    ): MutableList<Gasto> {
        return gc.getAllByDates(fecha_inicio, fecha_final)

    }

    fun verInfoMes(fecha_inicio: Date): MutableList<Gasto> {
        var lista_gastos = gc.getAllGastos()
        var nueva_lista: MutableList<Gasto> = mutableListOf()

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

    fun verInfoAno(ano: Date): MutableList<Gasto> {
        var lista_gastos = gc.getAllGastos()
        var nueva_lista: MutableList<Gasto> = mutableListOf()

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
    ): MutableList<Gasto> {
        return gc.getAllByDates(fecha_inicio, fecha_final)

    }

    fun getAllDistGastos(gastos: MutableList<Gasto>) {
        listagastosBD.clear()
        for (g in gastos) {
            var cat_temp = g.categoria
            var total: Float = 0.0F
            if (listagastosBD.isNotEmpty() && listagastosBD[cat_temp] != null) {
                total = listagastosBD[cat_temp]!!
                if (cat_temp != null) {
                    listagastosBD.replace(cat_temp, (total + g.importe).toFloat())
                }
            } else {
                if (cat_temp != null) {
                    listagastosBD[cat_temp] = g.importe.toFloat()
                }
            }
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
                binding.tvResultadoFecha.text = ("All")

                // Rellenar el pieChart + Listado
                var gastos = gc.getAllGastos()
                getAllDistGastos(gastos)
                IniciarAdapter()
                verGrafico(gastos)

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
                var gastos = verInfoDia(Date.valueOf(LocalDate.now().toString()))
                getAllDistGastos(gastos)
                IniciarAdapter()
                verGrafico(gastos)
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
                cal.add(Calendar.DAY_OF_WEEK, 7)
                val endOfWeek = cal.time

                var gastos = verInfoSemana(
                    startOfWeek,
                    endOfWeek
                )
                getAllDistGastos(gastos)
                IniciarAdapter()
                verGrafico(gastos)
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
                var gastos = verInfoMes(Date.valueOf(LocalDate.now().toString()))
                getAllDistGastos(gastos)
                IniciarAdapter()
                verGrafico(gastos)

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
                var gastos = verInfoAno(Date.valueOf(LocalDate.now().toString()))
                getAllDistGastos(gastos)
                IniciarAdapter()
                verGrafico(gastos)
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
//                var gastos = verInfoPeriodo(Date.valueOf(LocalDate.now().toString()))
//                getAllDistGastos(gastos)
//                IniciarAdapter()
//                verGrafico(gastos)
//                adapter.notifyDataSetChanged()
            }

            else -> println("Default")
        }
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
                    val intent = Intent(this@MgInicio, MgInicioIngresos::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.drawable.slide_out_left, R.drawable.slide_out_right)
                    finish()
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

                                var gastos = verInfoPeriodo(
                                    startDate!!.time,
                                    endDate!!.time
                                )
                                getAllDistGastos(gastos)
                                IniciarAdapter()
                                verGrafico(gastos)

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

    private fun crearCategorias(): MutableList<Categoria> {

        val listaCategorias = mutableListOf<Categoria>(

            Categoria("Viajes", R.drawable.circulo_naranja, R.drawable.cat_avion, "#FF9D0A"),
            Categoria("Cine", R.drawable.circulo_verde, R.drawable.cat_cine, "#2ACD1B"),
            Categoria("Bolos", R.drawable.circulo_rojo, R.drawable.cat_bolos, "#EF5757"),
            Categoria("Coctel", R.drawable.circulo_amarillo, R.drawable.cat_coctel, "#F4D35E"),
            Categoria("Compras", R.drawable.circulo_turquesa, R.drawable.cat_compras, "#54CA75"),
            Categoria("Hoteles", R.drawable.circulo_celeste, R.drawable.cat_hotel, "##97b5fe"),
            Categoria("Limpieza", R.drawable.circulo_azul, R.drawable.cat_limpieza, "#010efe"),
            Categoria("Regalos", R.drawable.circulo_rosa, R.drawable.cat_regalo, "#f610fe"),
            Categoria(
                "Restaurante",
                R.drawable.circulo_celeste,
                R.drawable.cat_restaurante,
                "#97b5fe"
            ),
            Categoria(
                "Videojuegos",
                R.drawable.circulo_naranja,
                R.drawable.cat_videojuego,
                "#FF9D0A"
            )

        )

        return listaCategorias
    }

    private fun rellenar_bd_categorias() {
        if (categoriaCRUD.getAllCategoria().isEmpty()) {
            for (categoria in listaCategorias) {
                categoriaCRUD.addCategoria(categoria)
            }
        }
    }


}