package models

import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required

@RealmClass
open class Usuario(): RealmObject() {

    @PrimaryKey
    var id: Int = 0

    @Required
    var nombre : String = ""

    @Required
    var password : String = ""

    var email : String = ""

    var rol : String = ""

    var listaGastos : RealmList<Gasto>? = RealmList<Gasto>()


    fun totalGastos(): Double {

        var sumaGastos: Double = 0.0

        for (gasto in listaGastos!!) {
            sumaGastos += gasto.importe
        }
        return sumaGastos
    }




    override fun toString(): String {
        return "USER: ID: $id, NOMBRE: $nombre, PASS: $password, GASTOS: $listaGastos"
    }
}