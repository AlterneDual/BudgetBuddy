package run.budgetbuddy.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat.getColor
import models.Categoria
import models.Gasto
import run.budgetbuddy.R
import kotlin.properties.Delegates

open class myListAdapterInfoGasto(
    context: Context,
    layout: Int,
    gastos: HashMap<Categoria, Double>,
    ingreso: Boolean
) :
    BaseAdapter() {

    private val mContext: Context = context
    private val mGastos: HashMap<Categoria, Double> = gastos
    private val ingreso: Boolean = ingreso
    private var nombre = ""
    private var value = 0.0
    private var icono by Delegates.notNull<Int>()

    override fun getCount(): Int {
        return mGastos.size
    }

    override fun getItem(position: Int): HashMap<Categoria, Double>? {
        var cont = 0
        for (g in mGastos) {
            if (cont == position) {
                return mGastos
            }
            cont++
        }
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ResourceAsColor")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var cont = 0
        for (g in mGastos) {
            if (cont == position) {
                nombre = g.key.nombre
                icono = g.key.icono
                value = g.value
            }
            cont++
        }
        val view: View
        if (ingreso) {
            view = convertView ?: LayoutInflater.from(mContext)
                .inflate(R.layout.mg_info_gasto_ingreso_row_ingreso, parent, false)
        } else {
            view = convertView ?: LayoutInflater.from(mContext)
                .inflate(R.layout.mg_info_gasto_ingreso_row, parent, false)
        }


        val categoriaIcono = view.findViewById<ImageView>(R.id.ivIcono)
        val gastoNombre = view.findViewById<TextView>(R.id.tvNombre1)
        val valor = view.findViewById<TextView>(R.id.textTotal)

        categoriaIcono.setImageResource(icono)
        gastoNombre.text = nombre
        valor.text = value.toString() + " €"
        return view
    }
}
