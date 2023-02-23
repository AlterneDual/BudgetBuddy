package run.budgetbuddy.adapter

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import run.budgetbuddy.R
import run.budgetbuddy.model.Ingreso
import java.text.SimpleDateFormat

class myListAdapter_ingreso(context: Context, ingresos: List<Ingreso>, colores: List<Int>) :
    BaseAdapter() {

    private val mContext: Context = context
    private val mIng: List<Ingreso> = ingresos
    private val mColores: List<Int> = colores
    override fun getCount(): Int {
        return mIng.size
    }

    override fun getItem(position: Int): Any {
        return mIng[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val ingreso = mIng[position]
        val color = mColores[position]
        val view: View = convertView ?: LayoutInflater.from(mContext)
            .inflate(R.layout.mg_inicio_ingreso_row, parent, false)

        val ingNombre = view.findViewById<TextView>(R.id.tvNombre1)
        val ingFecha = view.findViewById<TextView>(R.id.textDescripcion)
        val cantIng = view.findViewById<TextView>(R.id.textTotal)
        val color_view = view.findViewById<Button>(R.id.color)


        val format = SimpleDateFormat("dd/MM/yyyy")
        var date = format.format(ingreso.fecha);

        ingNombre.text = ingreso.descripcion
        ingFecha.text = date
        cantIng.text = ingreso.importe.toString() + " €"
        val back = color_view.background as GradientDrawable
//        val gBack = back.getStateDrawable(1) as GradientDrawable
        back.setColor(color)
        return view
    }
}
