package run.budgetbuddy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import models.Gasto
import run.budgetbuddy.R

class myListAdapter_gasto(context: Context, gastos: List<Gasto>) : BaseAdapter() {

    private val mContext: Context = context
    private val mGastos: List<Gasto> = gastos

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
        val gasto = mGastos[position]
        val view: View = convertView ?: LayoutInflater.from(mContext).inflate(R.layout.mg_row_gasto, parent, false)

        val categoriaIcono = view.findViewById<ImageView>(R.id.ImagenListaGasto)
        val gastoNombre = view.findViewById<TextView>(R.id.tvListaGasto)

        categoriaIcono.setImageResource(gasto.categoria!!.icono)
        gastoNombre.text = gasto.descripcion

        return view
    }
}