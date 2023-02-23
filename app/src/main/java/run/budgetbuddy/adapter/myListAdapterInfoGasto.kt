package run.budgetbuddy.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import models.Categoria
import models.Gasto
import run.budgetbuddy.R
import run.budgetbuddy.model.Ingreso
import java.text.SimpleDateFormat
import kotlin.properties.Delegates

open class myListAdapterInfoGasto(
    context: Context,
    elementos: MutableList<Any>
) :
    BaseAdapter() {

    private val mContext: Context = context
    private val elementos: MutableList<Any> = elementos

    override fun getCount(): Int {
        return elementos.size
    }

    override fun getItem(position: Int): Any {
        return elementos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view: View? = null
        val item = elementos[position]

        if (item is Ingreso) {
            view = convertView ?: LayoutInflater.from(mContext)
                .inflate(R.layout.mg_info_gasto_ingreso_row_ingreso, parent, false)

            val ingresoNombre = view?.findViewById<TextView>(R.id.tvNombre1)
            val valor = view?.findViewById<TextView>(R.id.textTotal)
            val fecha = view?.findViewById<TextView>(R.id.textDescripcion)

            ingresoNombre?.text = item.descripcion
            valor?.text = "+" + item.importe.toString() + " €"

            val format = SimpleDateFormat("dd/MM/yyyy")
            var date = format.format(item.fecha);

            fecha?.text = date

        }
        if (item is Gasto) {
            view = convertView ?: LayoutInflater.from(mContext)
                .inflate(R.layout.mg_info_gasto_ingreso_row, parent, false)

            val categoriaIcono = view?.findViewById<ImageView>(R.id.ivIcono)
            val categoriaColor = view?.findViewById<ImageView>(R.id.ivColor)
            val gastoNombre = view?.findViewById<TextView>(R.id.tvNombre1)
            val valor = view?.findViewById<TextView>(R.id.textTotal)
            val description = view?.findViewById<TextView>(R.id.textDescripcion)

            var category: Categoria? = item.categoria
            var value = item.importe

            category?.icono?.let { categoriaIcono?.setImageResource(it) }
            category?.color?.let { categoriaColor?.setImageResource(it) }
            gastoNombre?.text = category?.nombre
            valor?.text = "-$value €"
            description?.text = item.descripcion
        }
        return view
    }
}
