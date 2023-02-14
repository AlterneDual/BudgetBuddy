package run.budgetbuddy.adapter

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

class myListAdapter_gasto(context: Context, gastos: List<Categoria>, cantidades: List<Float>) :
    BaseAdapter() {

    private val mContext: Context = context
    private val mGastos: List<Categoria> = gastos
    private val mCantidades: List<Float> = cantidades
    override fun getCount(): Int {
        return mGastos.size
    }

    override fun getItem(position: Int): Any {
        return mGastos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categotia = mGastos[position]
        val view: View = convertView ?: LayoutInflater.from(mContext)
            .inflate(R.layout.mg_row_lista_gasto, parent, false)

        val categoriaIcono = view.findViewById<ImageView>(R.id.ivIconoCategoria)
        val colorCategoria = view.findViewById<ImageView>(R.id.ivColorCategoria)
        val gastoNombre = view.findViewById<TextView>(R.id.tvListaGasto)
        val cantGasto = view.findViewById<TextView>(R.id.tvCantGasto)

        categotia.let { categoriaIcono.setImageResource(it.icono) }
        categotia.let { colorCategoria.setImageResource(it.color) }
        cantGasto.text = mCantidades[position].toString() + " €"
        gastoNombre.text = categotia.nombre ?: "null"

        return view
    }
}