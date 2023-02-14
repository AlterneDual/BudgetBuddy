package run.budgetbuddy.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import models.Divisa
import java.util.*

@RealmClass
open class Ingreso() : RealmObject() {

    @Transient
    var calendar: Calendar = Calendar.getInstance()

    @PrimaryKey
    var id: Int = 0

    var importe: Double = 0.0
    var fecha: Date = calendar.time
    var divisa: Divisa? = null
    var descripcion: String? = ""


    override fun toString(): String {
        return "ID: $id, Importe: $importe || Fecha: ${fecha.toString()} || Descripcion: $descripcion"
    }
}