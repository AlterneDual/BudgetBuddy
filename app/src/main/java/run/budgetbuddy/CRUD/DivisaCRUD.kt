package CRUD

import io.realm.*
import io.realm.kotlin.where
import models.Categoria
import models.Divisa

open class DivisaCRUD {

    var realm: Realm = Realm.getDefaultInstance()

    fun addDivisa(divisa: Divisa) : Int{
        var key = getKey()

        realm.executeTransaction{ r:Realm  ->
            var divisaR = r.createObject(Divisa::class.java, key)
            divisaR.nombre = divisa.nombre
            divisaR.simbolo = divisa.simbolo
            divisaR.divOrigen = divisa.divOrigen
            divisaR.divDestino = divisa.divDestino


            realm.insertOrUpdate(divisaR)
        }
        return key
    }

    fun getKey():Int{

        return try {
            val number: Number? = realm.where<Divisa>().max("id")
            if(number!= null){
                number.toInt() + 1
            } else {
                0
            }

        }catch (e : ArrayIndexOutOfBoundsException){
            0
        }
    }

    fun getDivisa(id:Int): Divisa?{

        return realm.where(Divisa::class.java).equalTo("id",id).findFirst()

    }

    fun updateDivisa(id: Int, new_nombre: String?, new_simbolo: String?, new_divOrigen: String?, new_divDestino: String?){
        var divisa = getDivisa(id)
        realm.executeTransaction{
            if(new_nombre != null){
                divisa?.nombre = new_nombre
            }
            if(new_simbolo != null) {
                divisa?.simbolo = new_simbolo
            }
            if(new_divOrigen != null) {
                divisa?.divOrigen = new_divOrigen
            }
            if(new_divDestino != null) {
                divisa?.divDestino = new_divDestino
            }
            realm.insertOrUpdate(divisa)
        }
    }

    fun deleteCategoria(id:Int){

        val user = getDivisa(id)
        realm.executeTransaction{
            user!!.deleteFromRealm()
        }
    }

    fun cleanAll(){

        realm.executeTransaction { r: Realm ->
            r.delete(Divisa::class.java)
        }
    }

    fun getAllDivisa():MutableList<Divisa>{

        var list =  mutableListOf<Divisa>()
        var divisa_list = realm.where(Divisa::class.java).findAll()
        list.addAll(divisa_list)
        return list
    }


}
