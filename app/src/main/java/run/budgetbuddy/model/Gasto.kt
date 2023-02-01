package models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.Date
import java.util.Calendar

@RealmClass
open class Gasto() : RealmObject() {

    @Transient
    var calendar: Calendar = Calendar.getInstance()

    @PrimaryKey
    var id: Int = 0

    var importe: Double = 0.0
    var fecha: Date = calendar.time
    var categoria: Categoria? = null
    var descripcion: String = ""
    var divisa: Divisa? = null

    var id_user: Int = 0

    override fun toString(): String {
        return "ID: $id, Importe: $importe || DESC: $descripcion || Categoria: ${categoria.toString()}|| id_user: $id_user || Fecha: ${fecha.toString()}"
    }

}