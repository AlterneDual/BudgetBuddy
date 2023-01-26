package models

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.RealmField
import io.realm.internal.ObjectServerFacade.RealmInstanceFactory

@RealmClass
open class Gasto() : RealmObject(){

    @PrimaryKey
    var id : Int = 0

    var importe : Double = 0.0
    var fecha : String? = ""
    var categoria: Categoria? = Categoria()
    var descripcion : String = ""
    var divisa : Divisa? = Divisa()

    var id_user : Int = 0

    override fun toString(): String {
        return "ID: $id, Importe: $importe || DESC: $descripcion || Categoria:|| id_user: $id_user"
    }

}