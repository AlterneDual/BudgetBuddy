package CRUD

import io.realm.*
import io.realm.kotlin.where
import models.Gasto
import models.Usuario

open class UsuarioCRUD {

    var realm: Realm = Realm.getDefaultInstance()

    //fun addUser(name : String, pss: String, email: String, rol: String, listaGastos: RealmList<Gasto>)
    fun addUser(usuario : Usuario) : Int{
        var key = getKey()

        realm.executeTransaction{ r:Realm  ->
            var user = r.createObject(Usuario::class.java, key)
            user.nombre = usuario.nombre
            user.password = usuario.password
            user.email = usuario.email
            user.saldo = usuario.saldo
            user.listaGastos = usuario.listaGastos

//            if(usuario.listaGastos!!.size <= 0){
//                user.listaGastos = usuario.listaGastos
//            }
            realm.insertOrUpdate(user)
        }
        return key
    }

    fun getKey():Int{

        return try {
            val number: Number? = realm.where<Usuario>().max("id")
            if(number!= null){
                number.toInt() + 1
            } else {
                0
            }

        }catch (e : ArrayIndexOutOfBoundsException){
            0
        }
    }

    fun getUser(id:Int): Usuario?{

        return realm.where(Usuario::class.java).equalTo("id",id).findFirst()

    }


    fun updateUser(usuario: Usuario){

        realm.executeTransaction{ r:Realm  ->
            var user = getUser(usuario.id)

            if(usuario.nombre != null){
                user!!.nombre = usuario.nombre
            }
            if(usuario.password != null) {
                user!!.password = usuario.password
            }
            if(usuario.email != null) {
                user!!.email = usuario.email
            }
            if(usuario.saldo != null) {
                user!!.saldo = usuario.saldo
            }
            if(usuario.listaGastos != null) {
                user!!.listaGastos = usuario.listaGastos
            }
            realm.insertOrUpdate(user)
        }
    }

    fun deleteUser(id:Int){

        val user = getUser(id)
        realm.executeTransaction{
            user!!.deleteFromRealm()
        }
    }

    fun cleanAll(){

        realm.executeTransaction { r: Realm ->
            r.delete(Usuario::class.java)
        }
    }

    fun getAllUser():MutableList<Usuario>{

        var list =  mutableListOf<Usuario>()
        var user_list = realm.where(Usuario::class.java).findAll()
        list.addAll(user_list)
        return list
    }


}