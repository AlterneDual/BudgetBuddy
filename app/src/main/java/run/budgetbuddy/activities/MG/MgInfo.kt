package run.budgetbuddy.activities.MG

import CRUD.GastoCRUD
import CRUD.IngresoCRUD
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.GradientDrawable
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
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.databinding.MgInfoBinding
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import run.budgetbuddy.adapter.*
import run.budgetbuddy.model.Ingreso
import java.time.LocalDate
import java.time.ZoneId

class MgInfo : AppCompatActivity() {
    private lateinit var binding: MgInfoBinding
    private var seleccionado: Int = 1;
    var gc: GastoCRUD = GastoCRUD()
    var ic: IngresoCRUD = IngresoCRUD()
    private lateinit var list_view: ListView
    private lateinit var adapterList: myListAdapterInfoGasto
    private lateinit var lista_gastos: MutableList<Gasto>
    private lateinit var lista_ingresos: MutableList<Ingreso>
    var elemetos = mutableListOf<Any>()

    var posActualGasto: Int = 0

    private var MYGESTORVIEWINGRESOS_SETTING = "MyGestorView"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MgInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        check()

        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, MgInicio::class.java)
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
        val back = binding.butAll.background as GradientDrawable
        back.setColor(Color.parseColor("#FF9D0A"))
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
                binding.tvResultadoFecha.text = ("All")

                // Mostrar en la lista
                lista_gastos = gc.getAllGastos()
                lista_ingresos = ic.getAllingresos()
                inicializarAdapter(lista_gastos, lista_ingresos)

                var total: Double = 0.0
                for (l in lista_gastos) {
                    total += l.importe
                }
                var total2: Double = 0.0
                for (t in lista_ingresos) {
                    total2 += t.importe
                }

                var disponible = total2 - total

                if (disponible > 0.0) {
                    binding.tvDisponible.text = "+" + disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#2ACD1B"))
                } else if (disponible < 0.0) {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#FFFFFF"))
                }


                if (total2 != 0.0) {
                    binding.tvIngresos.text = "+" + total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#2ACD1B"))
                } else {
                    binding.tvIngresos.text = total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#FFFFFF"))
                }

                if (total != 0.0) {
                    binding.tvGastos.text = "-" + total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvGastos.text = total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#FFFFFF"))
                }
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
                lista_ingresos = verInfoDiaIngreso(Date.valueOf(LocalDate.now().toString()))
                inicializarAdapter(lista_gastos, lista_ingresos)


                var total: Double = 0.0
                for (l in lista_gastos) {
                    total += l.importe
                }
                var total2: Double = 0.0
                for (t in lista_ingresos) {
                    total2 += t.importe
                }

                var disponible = total2 - total

                if (disponible > 0.0) {
                    binding.tvDisponible.text = "+" + disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#2ACD1B"))
                } else if (disponible < 0.0) {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#FFFFFF"))
                }


                if (total2 != 0.0) {
                    binding.tvIngresos.text = "+" + total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#2ACD1B"))
                } else {
                    binding.tvIngresos.text = total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#FFFFFF"))
                }

                if (total != 0.0) {
                    binding.tvGastos.text = "-" + total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvGastos.text = total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#FFFFFF"))
                }
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
                    startOfWeek, endOfWeek
                )
                lista_ingresos = verInfoSemanaIngreso(startOfWeek, endOfWeek)

                inicializarAdapter(lista_gastos, lista_ingresos)


                var total: Double = 0.0
                for (l in lista_gastos) {
                    total += l.importe
                }
                var total2: Double = 0.0
                for (t in lista_ingresos) {
                    total2 += t.importe
                }

                var disponible = total2 - total

                if (disponible > 0.0) {
                    binding.tvDisponible.text = "+" + disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#2ACD1B"))
                } else if (disponible < 0.0) {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#FFFFFF"))
                }


                if (total2 != 0.0) {
                    binding.tvIngresos.text = "+" + total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#2ACD1B"))
                } else {
                    binding.tvIngresos.text = total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#FFFFFF"))
                }

                if (total != 0.0) {
                    binding.tvGastos.text = "-" + total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvGastos.text = total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#FFFFFF"))
                }

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
                lista_ingresos = verInfoMesIngreso(Date.valueOf(LocalDate.now().toString()))
                inicializarAdapter(lista_gastos, lista_ingresos)


                var total: Double = 0.0
                for (l in lista_gastos) {
                    total += l.importe
                }
                var total2: Double = 0.0
                for (t in lista_ingresos) {
                    total2 += t.importe
                }

                var disponible = total2 - total

                if (disponible > 0.0) {
                    binding.tvDisponible.text = "+" + disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#2ACD1B"))
                } else if (disponible < 0.0) {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#FFFFFF"))
                }


                if (total2 != 0.0) {
                    binding.tvIngresos.text = "+" + total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#2ACD1B"))
                } else {
                    binding.tvIngresos.text = total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#FFFFFF"))
                }

                if (total != 0.0) {
                    binding.tvGastos.text = "-" + total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvGastos.text = total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#FFFFFF"))
                }
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
                lista_ingresos = verInfoAnoIngreso(Date.valueOf(LocalDate.now().toString()))
                inicializarAdapter(lista_gastos, lista_ingresos)


                var total: Double = 0.0
                for (l in lista_gastos) {
                    total += l.importe
                }
                var total2: Double = 0.0
                for (t in lista_ingresos) {
                    total2 += t.importe
                }

                var disponible = total2 - total

                if (disponible > 0.0) {
                    binding.tvDisponible.text = "+" + disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#2ACD1B"))
                } else if (disponible < 0.0) {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#FFFFFF"))
                }


                if (total2 != 0.0) {
                    binding.tvIngresos.text = "+" + total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#2ACD1B"))
                } else {
                    binding.tvIngresos.text = total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#FFFFFF"))
                }

                if (total != 0.0) {
                    binding.tvGastos.text = "-" + total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvGastos.text = total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#FFFFFF"))
                }
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
                    total += l.importe
                }
                var total2: Double = 0.0
                for (t in lista_ingresos) {
                    total2 += t.importe
                }

                var disponible = total2 - total

                if (disponible > 0.0) {
                    binding.tvDisponible.text = "+" + disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#2ACD1B"))
                } else if (disponible < 0.0) {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvDisponible.text = disponible.toString() + " €"
                    binding.tvDisponible.setTextColor(Color.parseColor("#FFFFFF"))
                }


                if (total2 != 0.0) {
                    binding.tvIngresos.text = "+" + total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#2ACD1B"))
                } else {
                    binding.tvIngresos.text = total2.toString() + " €"
                    binding.tvIngresos.setTextColor(Color.parseColor("#FFFFFF"))
                }

                if (total != 0.0) {
                    binding.tvGastos.text = "-" + total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#EF5757"))
                } else {
                    binding.tvGastos.text = total.toString() + " €"
                    binding.tvGastos.setTextColor(Color.parseColor("#FFFFFF"))
                }
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
        fecha_inicio: java.util.Date, fecha_final: java.util.Date
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
        fecha_inicio: java.util.Date, fecha_final: java.util.Date
    ): MutableList<Gasto> {
        return gc.getAllByDates(fecha_inicio, fecha_final)
    }

    fun verInfoDiaIngreso(fecha_hoy: Date): MutableList<Ingreso> {
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

    fun verInfoSemanaIngreso(
        fecha_inicio: java.util.Date, fecha_final: java.util.Date
    ): MutableList<Ingreso> {
        return ic.getAllByDates(fecha_inicio, fecha_final)
    }

    fun verInfoMesIngreso(fecha_inicio: Date): MutableList<Ingreso> {
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

    fun verInfoAnoIngreso(ano: Date): MutableList<Ingreso> {
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

    fun verInfoPeriodoIngreso(
        fecha_inicio: java.util.Date, fecha_final: java.util.Date
    ): MutableList<Ingreso> {
        return ic.getAllByDates(fecha_inicio, fecha_final)
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
                                startDate!!.time, endDate!!.time
                            )
                            lista_ingresos = verInfoPeriodoIngreso(
                                startDate!!.time, endDate!!.time
                            )

                            inicializarAdapter(lista_gastos, lista_ingresos)
                            binding.tvResultadoFecha.text =
                                ("${start.toString()} - ${end.toString()}")

                            var total: Double = 0.0
                            for (l in lista_gastos) {
                                total += l.importe
                            }
                            var total2: Double = 0.0
                            for (t in lista_ingresos) {
                                total2 += t.importe
                            }

                            var disponible = total2 - total

                            if (disponible > 0.0) {
                                binding.tvDisponible.text = "+" + disponible.toString() + " €"
                                binding.tvDisponible.setTextColor(Color.parseColor("#2ACD1B"))
                            } else if (disponible < 0.0) {
                                binding.tvDisponible.text = disponible.toString() + " €"
                                binding.tvDisponible.setTextColor(Color.parseColor("#EF5757"))
                            } else {
                                binding.tvDisponible.text = disponible.toString() + " €"
                                binding.tvDisponible.setTextColor(Color.parseColor("#FFFFFF"))
                            }


                            if (total2 != 0.0) {
                                binding.tvIngresos.text = "+" + total2.toString() + " €"
                                binding.tvIngresos.setTextColor(Color.parseColor("#2ACD1B"))
                            } else {
                                binding.tvIngresos.text = total2.toString() + " €"
                                binding.tvIngresos.setTextColor(Color.parseColor("#FFFFFF"))
                            }

                            if (total != 0.0) {
                                binding.tvGastos.text = "-" + total.toString() + " €"
                                binding.tvGastos.setTextColor(Color.parseColor("#EF5757"))
                            } else {
                                binding.tvGastos.text = total.toString() + " €"
                                binding.tvGastos.setTextColor(Color.parseColor("#FFFFFF"))
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

    private fun inicializarAdapter(
        lista_gastos: MutableList<Gasto>, lista_ingresos: MutableList<Ingreso>
    ) {

        list_view = findViewById<ListView>(R.id.lista_gastos)
        elemetos.clear()
        elemetos.addAll(lista_gastos)
        elemetos.addAll(lista_ingresos)
        adapterList = myListAdapterInfoGasto(this, elemetos)
        list_view.adapter = adapterList
        registerForContextMenu(list_view)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu, v: View?, menuInfo: ContextMenu.ContextMenuInfo
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        var selected = elemetos[info.position]
        if (selected is Gasto) {
            menu.setHeaderTitle(selected.descripcion)
        }
        if (selected is Ingreso) {
            menu.setHeaderTitle(selected.descripcion)
        }
        inflater.inflate(R.menu.context_menu2, menu)
        posActualGasto = info.position
    }

    //Seleccionando elementos del menu contextual

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        posActualGasto = info.position

        return when (item.itemId) {
            R.id.btnBorrar -> {
                var selected = elemetos[info.position]
                if (selected is Gasto) {
                    var gastoInfo = ""
                    gastoInfo = selected.descripcion.toString()
                    gc.deleteGasto(selected.id)
                    check()
                    Toast.makeText(
                        this, "Has borrado el gasto: ${gastoInfo}", Toast.LENGTH_SHORT
                    ).show()
                }
                if (selected is Ingreso) {
                    var ingresoInfo = ""
                    ingresoInfo = selected.descripcion.toString()
                    ic.deleteingreso(selected.id)
                    check()
                    Toast.makeText(
                        this, "Has borrado el ingreso: ${ingresoInfo}", Toast.LENGTH_SHORT
                    ).show()
                }
                true
            }

            R.id.btnEditar -> {
                var selected = elemetos[info.position]
                if (selected is Gasto) {
                    val id = selected.id

                    val intent = Intent(this, MgEditarEliminarGasto::class.java)
                    intent.putExtra("id", id)
                    startActivity(intent)
                }
                if (selected is Ingreso) {
                    val id = selected.id

                    val intent = Intent(this, MgEditarEliminarIngreso::class.java)
                    intent.putExtra("id", id)
                    startActivity(intent)
                }

                true
            }

            else -> super.onContextItemSelected(item)
        }
    }


}