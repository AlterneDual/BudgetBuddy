package CRUD

import io.realm.*
import io.realm.kotlin.where
import models.Categoria

open class CategoriaCRUD {

    var realm: Realm = Realm.getDefaultInstance()

    fun addCategoria(categoria: Categoria): Int {
        var key = getKey()

        realm.executeTransaction { r: Realm ->
            var categoriaR = r.createObject(Categoria::class.java, key)
            categoriaR.nombre = categoria.nombre
            categoriaR.icono = categoria.icono
            categoriaR.descripcion = categoria.descripcion

            realm.insertOrUpdate(categoriaR)
        }
        return key
    }

    private fun getKey(): Int {
        return try {
            val number: Number? = realm.where<Categoria>().max("id")
            if (number != null) {
                number.toInt() + 1
            } else {
                0
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            0
        }
    }

    fun getCategoria(id: Int): Categoria? {
        return realm.where(Categoria::class.java).equalTo("id", id).findFirst()
    }

    fun updateCategoria(id: Int, new_nombre: String?, new_icono: Int?, new_desc: String?) {
        var categoria = getCategoria(id)
        realm.executeTransaction {
            if (new_nombre != null) {
                categoria?.nombre = new_nombre
            }
            if (new_icono != null) {
                categoria?.icono = new_icono
            }
            if (new_desc != null) {
                categoria?.descripcion = new_desc
            }
            realm.insertOrUpdate(categoria)
        }
    }

    fun deleteCategoria(id: Int) {

        val user = getCategoria(id)
        realm.executeTransaction {
            user!!.deleteFromRealm()
        }
    }

    fun cleanAll() {

        realm.executeTransaction { r: Realm ->
            r.delete(Categoria::class.java)
        }
    }

    fun getAllCategoria(): MutableList<Categoria> {

        var list = mutableListOf<Categoria>()
        var categoria_list = realm.where(Categoria::class.java).findAll()
        list.addAll(categoria_list)
        return list
    }
}
