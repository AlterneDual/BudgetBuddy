package models


import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Categoria(var nombre : String, var color : Int, var icono : Int): RealmObject() {

    constructor(): this("", 0, 0)

    @PrimaryKey
    var id : Int = 0
    var descripcion : String = ""

    override fun toString(): String {
        return nombre
    }

}