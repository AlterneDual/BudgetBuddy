package CRUD

import io.realm.*
import io.realm.kotlin.where
import models.Categoria
import models.Divisa
import models.Gasto
import java.util.Date

open class GastoCRUD {

    var realm: Realm = Realm.getDefaultInstance()

    fun addGasto(gasto: Gasto) : Int{
        var key = getKey()

        realm.executeTransaction{ r:Realm  ->
            var gastoR = r.createObject(Gasto::class.java, key)
            gastoR.importe = gasto.importe
            gastoR.fecha = gasto.fecha
            gastoR.categoria = gasto.categoria
            gastoR.descripcion = gasto.descripcion
            gastoR.divisa = gasto.divisa
            gastoR.id_user = gasto.id_user


            realm.insertOrUpdate(gastoR)
        }
        return key
    }

    fun getKey():Int{

        return try {
            val number: Number? = realm.where<Gasto>().max("id")
            if(number!= null){
                number.toInt() + 1
            } else {
                0
            }

        }catch (e : ArrayIndexOutOfBoundsException){
            0
        }
    }

    fun getGasto(id:Int): Gasto?{

        return realm.where(Gasto::class.java).equalTo("id",id).findFirst()

    }

    fun updateGasto(id: Int, new_importe : Double?, new_fecha: Date?, new_categoria: Categoria?, new_desc: String?, new_divisa: Divisa?){
        var gasto = getGasto(id)
        realm.executeTransaction{
            if(new_importe != null){
                gasto?.importe = new_importe
            }
            if(new_fecha != null) {
                gasto?.fecha = new_fecha
            }
            if(new_categoria != null) {
                gasto?.categoria = new_categoria
            }
            if(new_desc != null) {
                gasto?.descripcion = new_desc
            }
            if(new_divisa != null) {
                gasto?.divisa = new_divisa
            }
            realm.insertOrUpdate(gasto)
        }
    }

    fun deleteGasto(id:Int){

        val gasto = getGasto(id)
        realm.executeTransaction{
            gasto!!.deleteFromRealm()
        }
    }

    fun cleanAll(){

        realm.executeTransaction { r: Realm ->
            r.delete(Gasto::class.java)
        }
    }

    public fun getAllGastos():MutableList<Gasto>{

        var list =  mutableListOf<Gasto>()
        var gasto_list = realm.where(Gasto::class.java).findAll()
        list.addAll(gasto_list)
        return list
    }


}
