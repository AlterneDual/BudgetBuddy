package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(4);
        modelClasses.add(models.Usuario.class);
        modelClasses.add(models.Gasto.class);
        modelClasses.add(models.Divisa.class);
        modelClasses.add(models.Categoria.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(4);
        infoMap.put(models.Usuario.class, io.realm.models_UsuarioRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(models.Gasto.class, io.realm.models_GastoRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(models.Divisa.class, io.realm.models_DivisaRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(models.Categoria.class, io.realm.models_CategoriaRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(models.Usuario.class)) {
            return io.realm.models_UsuarioRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(models.Gasto.class)) {
            return io.realm.models_GastoRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(models.Divisa.class)) {
            return io.realm.models_DivisaRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(models.Categoria.class)) {
            return io.realm.models_CategoriaRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(models.Usuario.class)) {
            return "Usuario";
        }
        if (clazz.equals(models.Gasto.class)) {
            return "Gasto";
        }
        if (clazz.equals(models.Divisa.class)) {
            return "Divisa";
        }
        if (clazz.equals(models.Categoria.class)) {
            return "Categoria";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public Class<? extends RealmModel> getClazzImpl(String className) {
        checkClassName(className);

        if (className.equals("Usuario")) {
            return models.Usuario.class;
        }
        if (className.equals("Gasto")) {
            return models.Gasto.class;
        }
        if (className.equals("Divisa")) {
            return models.Divisa.class;
        }
        if (className.equals("Categoria")) {
            return models.Categoria.class;
        }
        throw getMissingProxyClassException(className);
    }

    @Override
    public boolean hasPrimaryKeyImpl(Class<? extends RealmModel> clazz) {
        return models.Usuario.class.isAssignableFrom(clazz)
                || models.Gasto.class.isAssignableFrom(clazz)
                || models.Divisa.class.isAssignableFrom(clazz)
                || models.Categoria.class.isAssignableFrom(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(models.Usuario.class)) {
                return clazz.cast(new io.realm.models_UsuarioRealmProxy());
            }
            if (clazz.equals(models.Gasto.class)) {
                return clazz.cast(new io.realm.models_GastoRealmProxy());
            }
            if (clazz.equals(models.Divisa.class)) {
                return clazz.cast(new io.realm.models_DivisaRealmProxy());
            }
            if (clazz.equals(models.Categoria.class)) {
                return clazz.cast(new io.realm.models_CategoriaRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(models.Usuario.class)) {
            models_UsuarioRealmProxy.UsuarioColumnInfo columnInfo = (models_UsuarioRealmProxy.UsuarioColumnInfo) realm.getSchema().getColumnInfo(models.Usuario.class);
            return clazz.cast(io.realm.models_UsuarioRealmProxy.copyOrUpdate(realm, columnInfo, (models.Usuario) obj, update, cache, flags));
        }
        if (clazz.equals(models.Gasto.class)) {
            models_GastoRealmProxy.GastoColumnInfo columnInfo = (models_GastoRealmProxy.GastoColumnInfo) realm.getSchema().getColumnInfo(models.Gasto.class);
            return clazz.cast(io.realm.models_GastoRealmProxy.copyOrUpdate(realm, columnInfo, (models.Gasto) obj, update, cache, flags));
        }
        if (clazz.equals(models.Divisa.class)) {
            models_DivisaRealmProxy.DivisaColumnInfo columnInfo = (models_DivisaRealmProxy.DivisaColumnInfo) realm.getSchema().getColumnInfo(models.Divisa.class);
            return clazz.cast(io.realm.models_DivisaRealmProxy.copyOrUpdate(realm, columnInfo, (models.Divisa) obj, update, cache, flags));
        }
        if (clazz.equals(models.Categoria.class)) {
            models_CategoriaRealmProxy.CategoriaColumnInfo columnInfo = (models_CategoriaRealmProxy.CategoriaColumnInfo) realm.getSchema().getColumnInfo(models.Categoria.class);
            return clazz.cast(io.realm.models_CategoriaRealmProxy.copyOrUpdate(realm, columnInfo, (models.Categoria) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public long insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(models.Usuario.class)) {
            return io.realm.models_UsuarioRealmProxy.insert(realm, (models.Usuario) object, cache);
        } else if (clazz.equals(models.Gasto.class)) {
            return io.realm.models_GastoRealmProxy.insert(realm, (models.Gasto) object, cache);
        } else if (clazz.equals(models.Divisa.class)) {
            return io.realm.models_DivisaRealmProxy.insert(realm, (models.Divisa) object, cache);
        } else if (clazz.equals(models.Categoria.class)) {
            return io.realm.models_CategoriaRealmProxy.insert(realm, (models.Categoria) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(models.Usuario.class)) {
                io.realm.models_UsuarioRealmProxy.insert(realm, (models.Usuario) object, cache);
            } else if (clazz.equals(models.Gasto.class)) {
                io.realm.models_GastoRealmProxy.insert(realm, (models.Gasto) object, cache);
            } else if (clazz.equals(models.Divisa.class)) {
                io.realm.models_DivisaRealmProxy.insert(realm, (models.Divisa) object, cache);
            } else if (clazz.equals(models.Categoria.class)) {
                io.realm.models_CategoriaRealmProxy.insert(realm, (models.Categoria) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(models.Usuario.class)) {
                    io.realm.models_UsuarioRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(models.Gasto.class)) {
                    io.realm.models_GastoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(models.Divisa.class)) {
                    io.realm.models_DivisaRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(models.Categoria.class)) {
                    io.realm.models_CategoriaRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public long insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(models.Usuario.class)) {
            return io.realm.models_UsuarioRealmProxy.insertOrUpdate(realm, (models.Usuario) obj, cache);
        } else if (clazz.equals(models.Gasto.class)) {
            return io.realm.models_GastoRealmProxy.insertOrUpdate(realm, (models.Gasto) obj, cache);
        } else if (clazz.equals(models.Divisa.class)) {
            return io.realm.models_DivisaRealmProxy.insertOrUpdate(realm, (models.Divisa) obj, cache);
        } else if (clazz.equals(models.Categoria.class)) {
            return io.realm.models_CategoriaRealmProxy.insertOrUpdate(realm, (models.Categoria) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(models.Usuario.class)) {
                io.realm.models_UsuarioRealmProxy.insertOrUpdate(realm, (models.Usuario) object, cache);
            } else if (clazz.equals(models.Gasto.class)) {
                io.realm.models_GastoRealmProxy.insertOrUpdate(realm, (models.Gasto) object, cache);
            } else if (clazz.equals(models.Divisa.class)) {
                io.realm.models_DivisaRealmProxy.insertOrUpdate(realm, (models.Divisa) object, cache);
            } else if (clazz.equals(models.Categoria.class)) {
                io.realm.models_CategoriaRealmProxy.insertOrUpdate(realm, (models.Categoria) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(models.Usuario.class)) {
                    io.realm.models_UsuarioRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(models.Gasto.class)) {
                    io.realm.models_GastoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(models.Divisa.class)) {
                    io.realm.models_DivisaRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(models.Categoria.class)) {
                    io.realm.models_CategoriaRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(models.Usuario.class)) {
            return clazz.cast(io.realm.models_UsuarioRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(models.Gasto.class)) {
            return clazz.cast(io.realm.models_GastoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(models.Divisa.class)) {
            return clazz.cast(io.realm.models_DivisaRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(models.Categoria.class)) {
            return clazz.cast(io.realm.models_CategoriaRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(models.Usuario.class)) {
            return clazz.cast(io.realm.models_UsuarioRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(models.Gasto.class)) {
            return clazz.cast(io.realm.models_GastoRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(models.Divisa.class)) {
            return clazz.cast(io.realm.models_DivisaRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(models.Categoria.class)) {
            return clazz.cast(io.realm.models_CategoriaRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(models.Usuario.class)) {
            return clazz.cast(io.realm.models_UsuarioRealmProxy.createDetachedCopy((models.Usuario) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(models.Gasto.class)) {
            return clazz.cast(io.realm.models_GastoRealmProxy.createDetachedCopy((models.Gasto) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(models.Divisa.class)) {
            return clazz.cast(io.realm.models_DivisaRealmProxy.createDetachedCopy((models.Divisa) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(models.Categoria.class)) {
            return clazz.cast(io.realm.models_CategoriaRealmProxy.createDetachedCopy((models.Categoria) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> boolean isEmbedded(Class<E> clazz) {
        if (clazz.equals(models.Usuario.class)) {
            return false;
        }
        if (clazz.equals(models.Gasto.class)) {
            return false;
        }
        if (clazz.equals(models.Divisa.class)) {
            return false;
        }
        if (clazz.equals(models.Categoria.class)) {
            return false;
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> void updateEmbeddedObject(Realm realm, E unmanagedObject, E managedObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) managedObject.getClass().getSuperclass();

        if (clazz.equals(models.Usuario.class)) {
            throw getNotEmbeddedClassException("models.Usuario");
        } else if (clazz.equals(models.Gasto.class)) {
            throw getNotEmbeddedClassException("models.Gasto");
        } else if (clazz.equals(models.Divisa.class)) {
            throw getNotEmbeddedClassException("models.Divisa");
        } else if (clazz.equals(models.Categoria.class)) {
            throw getNotEmbeddedClassException("models.Categoria");
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
