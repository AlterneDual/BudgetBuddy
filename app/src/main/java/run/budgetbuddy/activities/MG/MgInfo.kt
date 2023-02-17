package run.budgetbuddy.activities.MG

import CRUD.GastoCRUD
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
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
import java.time.LocalDate
import java.time.ZoneId

class MgInfo : AppCompatActivity() {
    private lateinit var binding: MgInfoBinding
    private var seleccionado: Int = 1;
    var gc: GastoCRUD = GastoCRUD()
    private lateinit var list_view: ListView
    private lateinit var adapterList: myListAdapterInfoGasto
    private lateinit var lista_gastos: MutableList<Gasto>
    var posActualGasto : Int = 0

    //    private lateinit var sharedPreferences: SharedPreferences

    private var MYGESTORVIEWINGRESOS_SETTING = "MyGestorView"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        check()

        binding.textView10.isVisible = false
        binding.tvIngresos.isVisible = false

        if (lista_gastos.isNotEmpty())
            inicializarAdapter(lista_gastos)


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
        binding.butAll.setOnClickListener {
            seleccionado = 0
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

                // Mostrar en la lista
                lista_gastos = gc.getAllGastos()
                inicializarAdapter(lista_gastos)
                var total: Double = 0.0;
                for (l in lista_gastos) {
                    total += l.importe;
                }
                binding.tvGastos.text = "-" + total.toString() + " €";

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

                // Mostrar en la lista
                lista_gastos = verInfoDia(Date.valueOf(LocalDate.now().toString()));
                inicializarAdapter(lista_gastos)
                var total: Double = 0.0;
                for (l in lista_gastos) {
                    total += l.importe;
                }
                binding.tvGastos.text = "-" + total.toString() + " €";

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

                lista_gastos = verInfoSemana(
                    startOfWeek,
                    endOfWeek
                )

                inicializarAdapter(lista_gastos)
                var total: Double = 0.0;
                for (l in lista_gastos) {
                    total += l.importe;
                }
                binding.tvGastos.text = "-" + total.toString() + " €";

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

                // Mostrar en la lista
                lista_gastos = verInfoMes(Date.valueOf(LocalDate.now().toString()));
                inicializarAdapter(lista_gastos)
                var total: Double = 0.0;
                for (l in lista_gastos) {
                    total += l.importe;
                }
                binding.tvGastos.text = "-" + total.toString() + " €";
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

                // Mostrar en la lista
                lista_gastos = verInfoAno(Date.valueOf(LocalDate.now().toString()));
                inicializarAdapter(lista_gastos)
                var total: Double = 0.0;
                for (l in lista_gastos) {
                    total += l.importe;
                }
                binding.tvGastos.text = "-" + total.toString() + " €"
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
                var total: Double = 0.0
                for (l in lista_gastos) {
                    total += l.importe;
                }
                binding.tvGastos.text = "-" + total.toString() + " €";

            }

            else -> println("Default")
        }
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

                            lista_gastos = verInfoPeriodo(
                                startDate!!.time,
                                endDate!!.time
                            )
                            inicializarAdapter(lista_gastos)
                            var total: Double = 0.0;
                            for (l in lista_gastos) {
                                total += l.importe;
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

    private fun inicializarAdapter(lista_gastos: MutableList<Gasto>) {

        list_view = findViewById<ListView>(R.id.lista_gastos)
        adapterList =
            myListAdapterInfoGasto(this, R.layout.mg_info_gasto_ingreso_row, lista_gastos, false)
        list_view.adapter = adapterList
        registerForContextMenu(list_view)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        menu.setHeaderTitle(lista_gastos[info.position].descripcion)
        inflater.inflate(R.menu.context_menu2, menu)
        posActualGasto = info.position


    }

    //Seleccionando elementos del menu contextual

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        posActualGasto = info.position

        return when (item.itemId) {

            R.id.btnBorrar -> {

                var gastoTemp = Gasto()
                gastoTemp.descripcion = lista_gastos[info.position].descripcion


                gc.deleteGasto((lista_gastos[info.position]).id)
                lista_gastos.clear()
                lista_gastos.addAll(gc.getAllGastos())
                adapterList.notifyDataSetChanged()

                //reiniciar vistaGastos
                var total: Double = 0.0;
                for (l in lista_gastos) {
                    total += l.importe;
                }
                binding.tvGastos.text = "-" + total.toString() + " €"


                Toast.makeText(
                    this, "Has borrado ${gastoTemp.descripcion}",
                    Toast.LENGTH_SHORT
                ).show()
                true

            }

            R.id.btnEditar -> {
//                //Aqui se envía las variables nombre y bandera a la pantalla "editar"
//                var nombre: String = listaComunidades[info.position].nombre
//                var bandera: Int = listaComunidades[info.position].bandera
//
//                val intent = Intent(this, PantallaEditar::class.java)
//                intent.putExtra("Nombre", nombre)
//                intent.putExtra("Bandera", bandera)
//                intentLaunch.launch(intent)


                true
            }
            else -> super.onContextItemSelected(item)
        }
    }


}