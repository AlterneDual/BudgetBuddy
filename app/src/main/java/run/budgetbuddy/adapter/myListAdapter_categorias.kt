package adapter


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import models.Categoria
import run.budgetbuddy.R
import run.budgetbuddy.activities.categoria.CrearCategoria

class myListAdapter_categorias(private val context: Context,
                               private val layout: Int,
                               private val listaOpciones: MutableList<Categoria>
)
                    : BaseAdapter(){

    private lateinit var listaColores: MutableList<Int>

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

                cView.findViewById(R.id.ivIconoCategoria),
                cView.findViewById(R.id.ivColorCategoria),
                cView.findViewById(R.id.nombreCategoria)

            )
            cView.tag = holder

        } else{
            holder = cView.tag as ViewHolder
        }

        val opcionActual = listaOpciones[position]

        holder.icono.setImageResource(opcionActual.icono)
        holder.color.setImageResource(opcionActual.color)
        holder.nombreCategoria.text = opcionActual.nombre

        if (opcionActual.color == R.drawable.circulo_azul){
            holder.nombreCategoria.setTextColor(Color.rgb(69, 119, 193))
        }else if(opcionActual.color == R.drawable.circulo_rosa){
            holder.nombreCategoria.setTextColor(Color.rgb(232, 84, 217))
        }else if(opcionActual.color == R.drawable.circulo_celeste){
            holder.nombreCategoria.setTextColor(Color.rgb(104, 201, 172))
        }else if(opcionActual.color == R.drawable.circulo_turquesa){
            holder.nombreCategoria.setTextColor(Color.rgb(84, 202, 117))
        }else if(opcionActual.color == R.drawable.circulo_rojo){
            holder.nombreCategoria.setTextColor(Color.rgb(220, 45, 45))
        }else if(opcionActual.color == R.drawable.circulo_amarillo){
            holder.nombreCategoria.setTextColor(Color.rgb(237, 229, 33))
        }else if(opcionActual.color == R.drawable.circulo_verde) {
            holder.nombreCategoria.setTextColor(Color.rgb(42, 205, 27))
        }else if(opcionActual.color == R.drawable.circulo_naranja){
            holder.nombreCategoria.setTextColor(Color.rgb(255, 157, 10))
        }
        return cView!!
    }


    internal class ViewHolder(
        var icono: ImageView,
        var color: ImageView,
        var nombreCategoria: TextView

        )

}