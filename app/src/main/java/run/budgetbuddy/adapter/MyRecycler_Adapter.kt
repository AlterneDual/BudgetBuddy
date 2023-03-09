package adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import models.Categoria
import run.budgetbuddy.R
import run.budgetbuddy.adapter.OnItemClickListener

class MyRecycler_Adapter(
    private val listaOpciones: MutableList<Categoria>, var listener: OnItemClickListener
) : RecyclerView.Adapter<MyRecycler_Adapter.ViewHolder>() {

    private lateinit var listaColores: MutableList<Int>

    companion object{
        var selectedItem = -1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_grid_categorias, parent, false)
        return ViewHolder(v, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val opcionActual = listaOpciones.get(position)

        holder.icono.setImageResource(opcionActual.icono)
        holder.color.setImageResource(opcionActual.color)
        holder.nombreCategoria.text = opcionActual.nombre

        if (selectedItem == position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#988C8C"))

        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }

        if (opcionActual.color == R.drawable.circulo_azul) {
            holder.nombreCategoria.setTextColor(Color.rgb(69, 119, 193))
        } else if (opcionActual.color == R.drawable.circulo_rosa) {
            holder.nombreCategoria.setTextColor(Color.rgb(232, 84, 217))
        } else if (opcionActual.color == R.drawable.circulo_celeste) {
            holder.nombreCategoria.setTextColor(Color.rgb(104, 201, 172))
        } else if (opcionActual.color == R.drawable.circulo_turquesa) {
            holder.nombreCategoria.setTextColor(Color.rgb(84, 202, 117))
        } else if (opcionActual.color == R.drawable.circulo_rojo) {
            holder.nombreCategoria.setTextColor(Color.rgb(220, 45, 45))
        } else if (opcionActual.color == R.drawable.circulo_amarillo) {
            holder.nombreCategoria.setTextColor(Color.rgb(237, 229, 33))
        } else if (opcionActual.color == R.drawable.circulo_verde) {
            holder.nombreCategoria.setTextColor(Color.rgb(42, 205, 27))
        } else if (opcionActual.color == R.drawable.circulo_naranja) {
            holder.nombreCategoria.setTextColor(Color.rgb(255, 157, 10))
        }
    }

    override fun getItemCount(): Int {
        return listaOpciones.size
    }

    class ViewHolder(v: View, var listener: OnItemClickListener) : RecyclerView.ViewHolder(v), View.OnClickListener {
        var icono: ImageView = v.findViewById(R.id.ivIconoCategoria)
        var color: ImageView = v.findViewById(R.id.ivColorCategoria)
        var nombreCategoria: TextView = v.findViewById(R.id.nombreCategoria)

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            this.listener.OnItemClick(p0!!,adapterPosition)


        }
    }

}
