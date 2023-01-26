package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class models_CategoriaRealmProxy extends models.Categoria
    implements RealmObjectProxy, models_CategoriaRealmProxyInterface {

    static final class CategoriaColumnInfo extends ColumnInfo {
        long idColKey;
        long nombreColKey;
        long iconoColKey;
        long descripcionColKey;

        CategoriaColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Categoria");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.nombreColKey = addColumnDetails("nombre", "nombre", objectSchemaInfo);
            this.iconoColKey = addColumnDetails("icono", "icono", objectSchemaInfo);
            this.descripcionColKey = addColumnDetails("descripcion", "descripcion", objectSchemaInfo);
        }

        CategoriaColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CategoriaColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CategoriaColumnInfo src = (CategoriaColumnInfo) rawSrc;
            final CategoriaColumnInfo dst = (CategoriaColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.nombreColKey = src.nombreColKey;
            dst.iconoColKey = src.iconoColKey;
            dst.descripcionColKey = src.descripcionColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private CategoriaColumnInfo columnInfo;
    private ProxyState<models.Categoria> proxyState;

    models_CategoriaRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CategoriaColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<models.Categoria>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idColKey);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombreColKey);
    }

    @Override
    public void realmSet$nombre(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nombre' to null.");
            }
            row.getTable().setString(columnInfo.nombreColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'nombre' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.nombreColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$icono() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.iconoColKey);
    }

    @Override
    public void realmSet$icono(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.iconoColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.iconoColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$descripcion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descripcionColKey);
    }

    @Override
    public void realmSet$descripcion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'descripcion' to null.");
            }
            row.getTable().setString(columnInfo.descripcionColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'descripcion' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.descripcionColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Categoria", false, 4, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "nombre", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "icono", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "descripcion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CategoriaColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CategoriaColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Categoria";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Categoria";
    }

    @SuppressWarnings("cast")
    public static models.Categoria createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        models.Categoria obj = null;
        if (update) {
            Table table = realm.getTable(models.Categoria.class);
            CategoriaColumnInfo columnInfo = (CategoriaColumnInfo) realm.getSchema().getColumnInfo(models.Categoria.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(models.Categoria.class), false, Collections.<String> emptyList());
                    obj = new io.realm.models_CategoriaRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.models_CategoriaRealmProxy) realm.createObjectInternal(models.Categoria.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.models_CategoriaRealmProxy) realm.createObjectInternal(models.Categoria.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final models_CategoriaRealmProxyInterface objProxy = (models_CategoriaRealmProxyInterface) obj;
        if (json.has("nombre")) {
            if (json.isNull("nombre")) {
                objProxy.realmSet$nombre(null);
            } else {
                objProxy.realmSet$nombre((String) json.getString("nombre"));
            }
        }
        if (json.has("icono")) {
            if (json.isNull("icono")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'icono' to null.");
            } else {
                objProxy.realmSet$icono((int) json.getInt("icono"));
            }
        }
        if (json.has("descripcion")) {
            if (json.isNull("descripcion")) {
                objProxy.realmSet$descripcion(null);
            } else {
                objProxy.realmSet$descripcion((String) json.getString("descripcion"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static models.Categoria createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final models.Categoria obj = new models.Categoria();
        final models_CategoriaRealmProxyInterface objProxy = (models_CategoriaRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("nombre")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre(null);
                }
            } else if (name.equals("icono")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$icono((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'icono' to null.");
                }
            } else if (name.equals("descripcion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$descripcion((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$descripcion(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static models_CategoriaRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(models.Categoria.class), false, Collections.<String>emptyList());
        io.realm.models_CategoriaRealmProxy obj = new io.realm.models_CategoriaRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static models.Categoria copyOrUpdate(Realm realm, CategoriaColumnInfo columnInfo, models.Categoria object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (models.Categoria) cachedRealmObject;
        }

        models.Categoria realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(models.Categoria.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((models_CategoriaRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.models_CategoriaRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static models.Categoria copy(Realm realm, CategoriaColumnInfo columnInfo, models.Categoria newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (models.Categoria) cachedRealmObject;
        }

        models_CategoriaRealmProxyInterface unmanagedSource = (models_CategoriaRealmProxyInterface) newObject;

        Table table = realm.getTable(models.Categoria.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.nombreColKey, unmanagedSource.realmGet$nombre());
        builder.addInteger(columnInfo.iconoColKey, unmanagedSource.realmGet$icono());
        builder.addString(columnInfo.descripcionColKey, unmanagedSource.realmGet$descripcion());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.models_CategoriaRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, models.Categoria object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(models.Categoria.class);
        long tableNativePtr = table.getNativePtr();
        CategoriaColumnInfo columnInfo = (CategoriaColumnInfo) realm.getSchema().getColumnInfo(models.Categoria.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((models_CategoriaRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_CategoriaRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_CategoriaRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$nombre = ((models_CategoriaRealmProxyInterface) object).realmGet$nombre();
        if (realmGet$nombre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iconoColKey, objKey, ((models_CategoriaRealmProxyInterface) object).realmGet$icono(), false);
        String realmGet$descripcion = ((models_CategoriaRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionColKey, objKey, realmGet$descripcion, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(models.Categoria.class);
        long tableNativePtr = table.getNativePtr();
        CategoriaColumnInfo columnInfo = (CategoriaColumnInfo) realm.getSchema().getColumnInfo(models.Categoria.class);
        long pkColumnKey = columnInfo.idColKey;
        models.Categoria object = null;
        while (objects.hasNext()) {
            object = (models.Categoria) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((models_CategoriaRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_CategoriaRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_CategoriaRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$nombre = ((models_CategoriaRealmProxyInterface) object).realmGet$nombre();
            if (realmGet$nombre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iconoColKey, objKey, ((models_CategoriaRealmProxyInterface) object).realmGet$icono(), false);
            String realmGet$descripcion = ((models_CategoriaRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionColKey, objKey, realmGet$descripcion, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, models.Categoria object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(models.Categoria.class);
        long tableNativePtr = table.getNativePtr();
        CategoriaColumnInfo columnInfo = (CategoriaColumnInfo) realm.getSchema().getColumnInfo(models.Categoria.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((models_CategoriaRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_CategoriaRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_CategoriaRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        String realmGet$nombre = ((models_CategoriaRealmProxyInterface) object).realmGet$nombre();
        if (realmGet$nombre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombreColKey, objKey, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iconoColKey, objKey, ((models_CategoriaRealmProxyInterface) object).realmGet$icono(), false);
        String realmGet$descripcion = ((models_CategoriaRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionColKey, objKey, realmGet$descripcion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descripcionColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(models.Categoria.class);
        long tableNativePtr = table.getNativePtr();
        CategoriaColumnInfo columnInfo = (CategoriaColumnInfo) realm.getSchema().getColumnInfo(models.Categoria.class);
        long pkColumnKey = columnInfo.idColKey;
        models.Categoria object = null;
        while (objects.hasNext()) {
            object = (models.Categoria) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((models_CategoriaRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_CategoriaRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_CategoriaRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            String realmGet$nombre = ((models_CategoriaRealmProxyInterface) object).realmGet$nombre();
            if (realmGet$nombre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombreColKey, objKey, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iconoColKey, objKey, ((models_CategoriaRealmProxyInterface) object).realmGet$icono(), false);
            String realmGet$descripcion = ((models_CategoriaRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionColKey, objKey, realmGet$descripcion, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descripcionColKey, objKey, false);
            }
        }
    }

    public static models.Categoria createDetachedCopy(models.Categoria realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        models.Categoria unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new models.Categoria();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (models.Categoria) cachedObject.object;
            }
            unmanagedObject = (models.Categoria) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        models_CategoriaRealmProxyInterface unmanagedCopy = (models_CategoriaRealmProxyInterface) unmanagedObject;
        models_CategoriaRealmProxyInterface realmSource = (models_CategoriaRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nombre(realmSource.realmGet$nombre());
        unmanagedCopy.realmSet$icono(realmSource.realmGet$icono());
        unmanagedCopy.realmSet$descripcion(realmSource.realmGet$descripcion());

        return unmanagedObject;
    }

    static models.Categoria update(Realm realm, CategoriaColumnInfo columnInfo, models.Categoria realmObject, models.Categoria newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        models_CategoriaRealmProxyInterface realmObjectTarget = (models_CategoriaRealmProxyInterface) realmObject;
        models_CategoriaRealmProxyInterface realmObjectSource = (models_CategoriaRealmProxyInterface) newObject;
        Table table = realm.getTable(models.Categoria.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nombreColKey, realmObjectSource.realmGet$nombre());
        builder.addInteger(columnInfo.iconoColKey, realmObjectSource.realmGet$icono());
        builder.addString(columnInfo.descripcionColKey, realmObjectSource.realmGet$descripcion());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        models_CategoriaRealmProxy aCategoria = (models_CategoriaRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aCategoria.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCategoria.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aCategoria.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
