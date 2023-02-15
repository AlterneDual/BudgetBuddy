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
            categoriaR.color = categoria.color
            categoriaR.color_hex = categoria.color_hex
            categoriaR.descripcion = categoria.descripcion


            realm.insertOrUpdate(categoriaR)
        }
        return key
    }

    fun getKey(): Int {

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

    fun updateCategoria(categoria: Categoria) {

        var cat = getCategoria(categoria.id)
        realm.executeTransaction {
            if (categoria.nombre != null) {
                cat?.nombre = categoria.nombre
            }
            if (categoria.icono != null) {
                cat?.icono = categoria.icono
            }
            if (categoria.color != null) {
                cat?.color = categoria.color
            }
            if (categoria.color_hex != null) {
                cat?.color_hex = categoria.color_hex
            }
            if (categoria.descripcion != null) {
                cat?.descripcion = categoria.descripcion
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
