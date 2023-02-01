package models


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Categoria() : RealmObject() {

    @PrimaryKey
    var id: Int = 0

    var nombre: String? = ""
    var icono: Int? = 0
    var descripcion: String? = ""


}