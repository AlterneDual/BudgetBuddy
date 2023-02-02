package run.budgetbuddy.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import models.ItemGenerico
import run.budgetbuddy.R

class myListAdapter(
    private val context: Context,
    private val layout: Int,
    private val listaAjustes: List<ItemGenerico>
) : BaseAdapter() {

    override fun getCount(): Int {
        return listaAjustes.size
    }

    override fun getItem(position: Int): ItemGenerico {
        return listaAjustes[position]
    }

    override fun getItemId(id: Int): Long {
        return id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var cView = convertView
        val holder: ViewHolder
        if (cView == null) {

            cView = LayoutInflater.from(context).inflate(layout, null)
            holder = ViewHolder(

                cView.findViewById(R.id.tvNombre1),
                cView.findViewById(R.id.tvNombre2),
                cView.findViewById(R.id.ivIcono)

            )
            cView.tag = holder

        } else {
            holder = cView.tag as ViewHolder
        }

        val ajusteActual = listaAjustes[position]
        holder.nombre1.setText(ajusteActual.nombre1)
        holder.nombre2.setText(ajusteActual.color)
        holder.icono.setImageResource(ajusteActual.icono)


        return cView!!
    }

    internal class ViewHolder(
        var nombre1: TextView,
        var nombre2: TextView,
        var icono: ImageView

    )

}