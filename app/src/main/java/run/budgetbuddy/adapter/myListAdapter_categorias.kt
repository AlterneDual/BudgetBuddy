package adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import models.Categoria
import models.ItemGenerico
import run.budgetbuddy.R

class myListAdapter_categorias(private val context: Context,
                               private val layout: Int,
                               private val listaOpciones: MutableList<Categoria>
)
                    : BaseAdapter(){

    override fun getCount(): Int {
        return listaOpciones.size
    }

    override fun getItem(position: Int): Categoria {
        return listaOpciones[position]
    }

    override fun getItemId(id: Int): Long {
        return id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var cView = convertView
        val holder : ViewHolder
        if( cView == null){

            cView = LayoutInflater.from(context).inflate(layout,null)
            holder = ViewHolder(

                cView.findViewById(R.id.ivIconoCategoria)

            )
            cView.tag = holder

        } else{
            holder = cView.tag as ViewHolder
        }

        val opcionActual = listaOpciones[position]

        holder.icono.setImageResource(opcionActual.icono)

        return cView!!
    }

    internal class ViewHolder(
        var icono: ImageView

        )

}