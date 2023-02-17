package CRUD

import io.realm.*
import io.realm.kotlin.where
import models.Categoria
import models.Divisa
import models.Gasto
import java.util.Date

open class GastoCRUD {

    var realm: Realm = Realm.getDefaultInstance()

    fun addGasto(gasto: Gasto): Int {
        var keyGasto = getKey()


        realm.executeTransaction { r: Realm ->
            var gastoR = r.createObject(Gasto::class.java, keyGasto)

            gastoR.importe = gasto.importe
            gastoR.fecha = gasto.fecha
            gastoR.categoria = gasto.categoria
            gastoR.divisa = gasto.divisa
            gastoR.descripcion = gasto.descripcion
            gastoR.id_user = gasto.id_user


            realm.insertOrUpdate(gastoR)
        }
        return keyGasto
    }

    fun getKey(): Int {

        return try {
            val number: Number? = realm.where<Gasto>().max("id")
            if (number != null) {
                number.toInt() + 1
            } else {
                0
            }

        } catch (e: ArrayIndexOutOfBoundsException) {
            0
        }
    }


    fun getGasto(id: Int): Gasto? {

        return realm.where(Gasto::class.java).equalTo("id", id).findFirst()

    }

    fun updateGasto(gasto: Gasto) {

        var gas = getGasto(gasto.id)
        realm.executeTransaction {
            if (gasto.importe != null) {
                gas?.importe = gasto.importe
            }
            if (gasto.fecha != null) {
                gas?.fecha = gasto.fecha
            }
            if (gasto.categoria != null) {
                gas?.categoria = gasto.categoria
            }
            if (gasto.descripcion != null) {
                gas?.descripcion = gasto.descripcion
            }
            if (gasto.divisa != null) {
                gas?.divisa = gasto.divisa
            }
            realm.insertOrUpdate(gas)
        }
    }

    fun deleteGasto(id: Int) {

        val gasto = getGasto(id)
        realm.executeTransaction {
            gasto!!.deleteFromRealm()
        }
    }

    fun cleanAll() {

        realm.executeTransaction { r: Realm ->
            r.delete(Gasto::class.java)
        }
    }

    fun getAllGastos(): MutableList<Gasto> {

        var list = mutableListOf<Gasto>()
        var gasto_list = realm.where(Gasto::class.java).findAll()
        list.addAll(gasto_list)
        return list
    }

    fun getAllByDates(
        fecha_inicio: Date,
        fecha_fin: Date
    ): MutableList<Gasto> {
        var gastos = mutableListOf<Gasto>()
        var gastos_realm = realm.where<Gasto>().between("fecha", fecha_inicio, fecha_fin).findAll()
        for (g in gastos_realm) {
            gastos.add(g)
        }
        return gastos
    }


}
