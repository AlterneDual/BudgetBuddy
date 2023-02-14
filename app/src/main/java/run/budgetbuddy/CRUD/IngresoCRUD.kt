package CRUD

import io.realm.*
import io.realm.kotlin.where
import models.Divisa
import run.budgetbuddy.model.Ingreso
import java.util.Date

open class IngresoCRUD {

    var realm: Realm = Realm.getDefaultInstance()

    fun addIngreso(ingreso: Ingreso): Int {
        var keyIngreso = getKey()


        realm.executeTransaction { r: Realm ->
            var ingresoR = r.createObject(ingreso::class.java, keyIngreso)

            ingresoR.importe = ingreso.importe
            ingresoR.fecha = ingreso.fecha
            ingresoR.divisa = ingreso.divisa
            ingresoR.descripcion = ingreso.descripcion


            realm.insertOrUpdate(ingresoR)
        }
        return keyIngreso
    }

    fun getKey(): Int {

        return try {
            val number: Number? = realm.where<Ingreso>().max("id")
            if (number != null) {
                number.toInt() + 1
            } else {
                0
            }

        } catch (e: ArrayIndexOutOfBoundsException) {
            0
        }
    }


    fun getingreso(id: Int): Ingreso? {

        return realm.where(Ingreso::class.java).equalTo("id", id).findFirst()

    }

    fun updateingreso(
        id: Int,
        new_importe: Double?,
        new_fecha: Date?,
        new_desc: String?,
        new_divisa: Divisa?
    ) {
        var ingreso = getingreso(id)
        realm.executeTransaction {
            if (new_importe != null) {
                ingreso?.importe = new_importe
            }
            if (new_fecha != null) {
                ingreso?.fecha = new_fecha
            }
            if (new_desc != null) {
                ingreso?.descripcion = new_desc
            }
            if (new_divisa != null) {
                ingreso?.divisa = new_divisa
            }
            realm.insertOrUpdate(ingreso)
        }
    }

    fun deleteingreso(id: Int) {

        val ingreso = getingreso(id)
        realm.executeTransaction {
            ingreso!!.deleteFromRealm()
        }
    }

    fun cleanAll() {

        realm.executeTransaction { r: Realm ->
            r.delete(Ingreso::class.java)
        }
    }

    fun getAllingresos(): MutableList<Ingreso> {

        var list = mutableListOf<Ingreso>()
        var ingreso_list = realm.where(Ingreso::class.java).findAll()
        list.addAll(ingreso_list)
        return list
    }


}
