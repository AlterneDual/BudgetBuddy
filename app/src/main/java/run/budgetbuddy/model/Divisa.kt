package models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Divisa() : RealmObject() {

    @PrimaryKey
    var id: Int = 0
    var nombre: String? = null
    var simbolo: String? = ""
    var divOrigen: String? = nombre
    var divDestino: String? = ""

    var origen: Double? = 0.0
    var destino: Double? = 0.0

//    fun conversor(): String {
//
//        when (divOrigen) {
//
//            "Euro" -> {
//                when (divDestino) {
//
//                    "Dolar" -> {
//                        destino = origen * 1.08
//                        simbolo = "$"
//                    }
//
//                    "Libra" -> {
//                        destino = origen * 0.88
//                        simbolo = "£"
//                    }
//                }
//            }
//
//            "Dolar" -> {
//                when (divDestino) {
//
//                    "Euro" -> {
//                        destino = origen * 0.92
//                        simbolo = "€"
//                    }
//
//                    "Libra" -> {
//                        destino = origen * 0.82
//                        simbolo = "£"
//                    }
//                }
//            }
//
//            "Libra" -> {
//                when (divDestino) {
//
//                    "Euro" -> {
//                        destino = origen * 1.13
//                        simbolo = "€"
//                    }
//
//                    "Libra" -> {
//                        destino = origen * 1.23
//                        simbolo = "£"
//                    }
//                }
//            }
//        }
//
//        return "$destino $simbolo"
//    }

}

