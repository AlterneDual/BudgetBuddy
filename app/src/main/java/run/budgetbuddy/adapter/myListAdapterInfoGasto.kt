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
import androidx.core.content.res.ResourcesCompat.getDrawable
import models.Categoria
import models.Gasto
import run.budgetbuddy.R
import kotlin.properties.Delegates

open class myListAdapterInfoGasto(
    context: Context,
    layout: Int,
    gastos: MutableList<Gasto>,
    ingreso: Boolean
) :
    BaseAdapter() {

    private val mContext: Context = context
    private val mGastos: MutableList<Gasto> = gastos
    private val ingreso: Boolean = ingreso
    private var nombre = ""
    private var descripcion = ""
    private var value = 0.0
    private var color = 0
    private var icono by Delegates.notNull<Int>()

    override fun getCount(): Int {
        return mGastos.size
    }

    override fun getItem(position: Int): MutableList<Gasto>? {
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

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var cont = 0
        for (g in mGastos) {
            if (cont == position) {
                nombre = g.categoria?.nombre ?: ""
                icono = g.categoria?.icono ?: 0
                color = g.categoria?.color!!
                value = g.importe
                descripcion = g.descripcion.toString()

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
        val categoriaColor = view.findViewById<ImageView>(R.id.ivColor)
        val gastoNombre = view.findViewById<TextView>(R.id.tvNombre1)
        val valor = view.findViewById<TextView>(R.id.textTotal)
        val description = view.findViewById<TextView>(R.id.textDescripcion)

        categoriaIcono.setImageResource(icono)
        categoriaColor.setImageResource(color)
        gastoNombre.text = nombre
        valor.text = "-$value €"
        description.text = descripcion
        return view
    }
}
