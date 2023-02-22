package CRUD

import io.realm.*
import io.realm.kotlin.where
import models.Divisa
import models.Gasto
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

    fun updateingreso(ingreso: Ingreso) {

        var ing = getingreso(ingreso.id)
        realm.executeTransaction {
            if (ingreso!!.importe != null) {
                ing?.importe = ingreso!!.importe
            }
            if (ingreso.fecha != null) {
                ing?.fecha = ingreso.fecha
            }
            if (ingreso.descripcion != null) {
                ing?.descripcion = ingreso.descripcion
            }
            if (ingreso.divisa != null) {
                ing?.divisa = ingreso.divisa
            }
            realm.insertOrUpdate(ing)
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
    fun getAllByDates(
        fecha_inicio: Date,
        fecha_fin: Date
    ): MutableList<Ingreso> {
        var ingreso = mutableListOf<Ingreso>()
        var gastos_realm = realm.where<Ingreso>().between("fecha", fecha_inicio, fecha_fin).findAll()
        for (g in gastos_realm) {
            ingreso.add(g)
        }
        return ingreso
    }


}
