package CRUD

import io.realm.*
import io.realm.kotlin.where
import models.Categoria
import models.Divisa

open class DivisaCRUD {

    var realm: Realm = Realm.getDefaultInstance()

    fun addDivisa(divisa: Divisa): Int {
        var key = getKey()

        realm.executeTransaction { r: Realm ->
            var divisaR = r.createObject(Divisa::class.java, key)
            divisaR.nombre = divisa.nombre
            divisaR.simbolo = divisa.simbolo
            divisaR.divOrigen = divisa.divOrigen
            divisaR.divDestino = divisa.divDestino


            realm.insertOrUpdate(divisaR)
        }
        return key
    }

    fun getKey(): Int {

        return try {
            val number: Number? = realm.where<Divisa>().max("id")
            if (number != null) {
                number.toInt() + 1
            } else {
                0
            }

        } catch (e: ArrayIndexOutOfBoundsException) {
            0
        }
    }

    fun getDivisa(id: Int): Divisa? {

        return realm.where(Divisa::class.java).equalTo("id", id).findFirst()

    }

    fun updateDivisa(divisa: Divisa) {

        var div = getDivisa(divisa.id)
        realm.executeTransaction {
            if (divisa.nombre != null) {
                div?.nombre = divisa.nombre
            }
            if (divisa.simbolo != null) {
                div?.simbolo = divisa.simbolo
            }
            if (divisa.divOrigen != null) {
                div?.divOrigen = divisa.divOrigen
            }
            if (divisa.divOrigen != null) {
                div?.divDestino = divisa.divOrigen
            }
            realm.insertOrUpdate(div)
        }
    }

    fun deleteCategoria(id: Int) {

        val user = getDivisa(id)
        realm.executeTransaction {
            user!!.deleteFromRealm()
        }
    }

    fun cleanAll() {

        realm.executeTransaction { r: Realm ->
            r.delete(Divisa::class.java)
        }
    }

    fun getAllDivisa(): MutableList<Divisa> {

        var list = mutableListOf<Divisa>()
        var divisa_list = realm.where(Divisa::class.java).findAll()
        list.addAll(divisa_list)
        return list
    }


}
