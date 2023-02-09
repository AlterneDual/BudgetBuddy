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
public class models_GastoRealmProxy extends models.Gasto
    implements RealmObjectProxy, models_GastoRealmProxyInterface {

    static final class GastoColumnInfo extends ColumnInfo {
        long idColKey;
        long importeColKey;
        long fechaColKey;
        long categoriaColKey;
        long divisaColKey;
        long id_userColKey;

        GastoColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Gasto");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.importeColKey = addColumnDetails("importe", "importe", objectSchemaInfo);
            this.fechaColKey = addColumnDetails("fecha", "fecha", objectSchemaInfo);
            this.categoriaColKey = addColumnDetails("categoria", "categoria", objectSchemaInfo);
            this.divisaColKey = addColumnDetails("divisa", "divisa", objectSchemaInfo);
            this.id_userColKey = addColumnDetails("id_user", "id_user", objectSchemaInfo);
        }

        GastoColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GastoColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GastoColumnInfo src = (GastoColumnInfo) rawSrc;
            final GastoColumnInfo dst = (GastoColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.importeColKey = src.importeColKey;
            dst.fechaColKey = src.fechaColKey;
            dst.categoriaColKey = src.categoriaColKey;
            dst.divisaColKey = src.divisaColKey;
            dst.id_userColKey = src.id_userColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private GastoColumnInfo columnInfo;
    private ProxyState<models.Gasto> proxyState;

    models_GastoRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GastoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<models.Gasto>(this);
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
    public double realmGet$importe() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.importeColKey);
    }

    @Override
    public void realmSet$importe(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.importeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.importeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$fecha() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.fechaColKey);
    }

    @Override
    public void realmSet$fecha(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'fecha' to null.");
            }
            row.getTable().setDate(columnInfo.fechaColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'fecha' to null.");
        }
        proxyState.getRow$realm().setDate(columnInfo.fechaColKey, value);
    }

    @Override
    public models.Categoria realmGet$categoria() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.categoriaColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(models.Categoria.class, proxyState.getRow$realm().getLink(columnInfo.categoriaColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$categoria(models.Categoria value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("categoria")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = realm.copyToRealmOrUpdate(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.categoriaColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.categoriaColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.categoriaColKey);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.categoriaColKey, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey());
    }

    @Override
    public models.Divisa realmGet$divisa() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.divisaColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(models.Divisa.class, proxyState.getRow$realm().getLink(columnInfo.divisaColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$divisa(models.Divisa value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("divisa")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = realm.copyToRealmOrUpdate(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.divisaColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.divisaColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.divisaColKey);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.divisaColKey, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id_user() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.id_userColKey);
    }

    @Override
    public void realmSet$id_user(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.id_userColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.id_userColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Gasto", false, 6, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "importe", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "fecha", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "categoria", RealmFieldType.OBJECT, "Categoria");
        builder.addPersistedLinkProperty(NO_ALIAS, "divisa", RealmFieldType.OBJECT, "Divisa");
        builder.addPersistedProperty(NO_ALIAS, "id_user", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GastoColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GastoColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Gasto";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Gasto";
    }

    @SuppressWarnings("cast")
    public static models.Gasto createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        models.Gasto obj = null;
        if (update) {
            Table table = realm.getTable(models.Gasto.class);
            GastoColumnInfo columnInfo = (GastoColumnInfo) realm.getSchema().getColumnInfo(models.Gasto.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(models.Gasto.class), false, Collections.<String> emptyList());
                    obj = new io.realm.models_GastoRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("categoria")) {
                excludeFields.add("categoria");
            }
            if (json.has("divisa")) {
                excludeFields.add("divisa");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.models_GastoRealmProxy) realm.createObjectInternal(models.Gasto.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.models_GastoRealmProxy) realm.createObjectInternal(models.Gasto.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final models_GastoRealmProxyInterface objProxy = (models_GastoRealmProxyInterface) obj;
        if (json.has("importe")) {
            if (json.isNull("importe")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'importe' to null.");
            } else {
                objProxy.realmSet$importe((double) json.getDouble("importe"));
            }
        }
        if (json.has("fecha")) {
            if (json.isNull("fecha")) {
                objProxy.realmSet$fecha(null);
            } else {
                Object timestamp = json.get("fecha");
                if (timestamp instanceof String) {
                    objProxy.realmSet$fecha(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$fecha(new Date(json.getLong("fecha")));
                }
            }
        }
        if (json.has("categoria")) {
            if (json.isNull("categoria")) {
                objProxy.realmSet$categoria(null);
            } else {
                models.Categoria categoriaObj = models_CategoriaRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("categoria"), update);
                objProxy.realmSet$categoria(categoriaObj);
            }
        }
        if (json.has("divisa")) {
            if (json.isNull("divisa")) {
                objProxy.realmSet$divisa(null);
            } else {
                models.Divisa divisaObj = models_DivisaRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("divisa"), update);
                objProxy.realmSet$divisa(divisaObj);
            }
        }
        if (json.has("id_user")) {
            if (json.isNull("id_user")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id_user' to null.");
            } else {
                objProxy.realmSet$id_user((int) json.getInt("id_user"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static models.Gasto createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final models.Gasto obj = new models.Gasto();
        final models_GastoRealmProxyInterface objProxy = (models_GastoRealmProxyInterface) obj;
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
            } else if (name.equals("importe")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$importe((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'importe' to null.");
                }
            } else if (name.equals("fecha")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$fecha(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$fecha(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$fecha(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("categoria")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$categoria(null);
                } else {
                    models.Categoria categoriaObj = models_CategoriaRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$categoria(categoriaObj);
                }
            } else if (name.equals("divisa")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$divisa(null);
                } else {
                    models.Divisa divisaObj = models_DivisaRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$divisa(divisaObj);
                }
            } else if (name.equals("id_user")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id_user((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id_user' to null.");
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

    static models_GastoRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(models.Gasto.class), false, Collections.<String>emptyList());
        io.realm.models_GastoRealmProxy obj = new io.realm.models_GastoRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static models.Gasto copyOrUpdate(Realm realm, GastoColumnInfo columnInfo, models.Gasto object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (models.Gasto) cachedRealmObject;
        }

        models.Gasto realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(models.Gasto.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((models_GastoRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.models_GastoRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static models.Gasto copy(Realm realm, GastoColumnInfo columnInfo, models.Gasto newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (models.Gasto) cachedRealmObject;
        }

        models_GastoRealmProxyInterface unmanagedSource = (models_GastoRealmProxyInterface) newObject;

        Table table = realm.getTable(models.Gasto.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addDouble(columnInfo.importeColKey, unmanagedSource.realmGet$importe());
        builder.addDate(columnInfo.fechaColKey, unmanagedSource.realmGet$fecha());
        builder.addInteger(columnInfo.id_userColKey, unmanagedSource.realmGet$id_user());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.models_GastoRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        models.Categoria categoriaObj = unmanagedSource.realmGet$categoria();
        if (categoriaObj == null) {
            managedCopy.realmSet$categoria(null);
        } else {
            models.Categoria cachecategoria = (models.Categoria) cache.get(categoriaObj);
            if (cachecategoria != null) {
                managedCopy.realmSet$categoria(cachecategoria);
            } else {
                managedCopy.realmSet$categoria(models_CategoriaRealmProxy.copyOrUpdate(realm, (models_CategoriaRealmProxy.CategoriaColumnInfo) realm.getSchema().getColumnInfo(models.Categoria.class), categoriaObj, update, cache, flags));
            }
        }

        models.Divisa divisaObj = unmanagedSource.realmGet$divisa();
        if (divisaObj == null) {
            managedCopy.realmSet$divisa(null);
        } else {
            models.Divisa cachedivisa = (models.Divisa) cache.get(divisaObj);
            if (cachedivisa != null) {
                managedCopy.realmSet$divisa(cachedivisa);
            } else {
                managedCopy.realmSet$divisa(models_DivisaRealmProxy.copyOrUpdate(realm, (models_DivisaRealmProxy.DivisaColumnInfo) realm.getSchema().getColumnInfo(models.Divisa.class), divisaObj, update, cache, flags));
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, models.Gasto object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(models.Gasto.class);
        long tableNativePtr = table.getNativePtr();
        GastoColumnInfo columnInfo = (GastoColumnInfo) realm.getSchema().getColumnInfo(models.Gasto.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((models_GastoRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_GastoRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_GastoRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importeColKey, objKey, ((models_GastoRealmProxyInterface) object).realmGet$importe(), false);
        java.util.Date realmGet$fecha = ((models_GastoRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.fechaColKey, objKey, realmGet$fecha.getTime(), false);
        }

        models.Categoria categoriaObj = ((models_GastoRealmProxyInterface) object).realmGet$categoria();
        if (categoriaObj != null) {
            Long cachecategoria = cache.get(categoriaObj);
            if (cachecategoria == null) {
                cachecategoria = models_CategoriaRealmProxy.insert(realm, categoriaObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.categoriaColKey, objKey, cachecategoria, false);
        }

        models.Divisa divisaObj = ((models_GastoRealmProxyInterface) object).realmGet$divisa();
        if (divisaObj != null) {
            Long cachedivisa = cache.get(divisaObj);
            if (cachedivisa == null) {
                cachedivisa = models_DivisaRealmProxy.insert(realm, divisaObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.divisaColKey, objKey, cachedivisa, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.id_userColKey, objKey, ((models_GastoRealmProxyInterface) object).realmGet$id_user(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(models.Gasto.class);
        long tableNativePtr = table.getNativePtr();
        GastoColumnInfo columnInfo = (GastoColumnInfo) realm.getSchema().getColumnInfo(models.Gasto.class);
        long pkColumnKey = columnInfo.idColKey;
        models.Gasto object = null;
        while (objects.hasNext()) {
            object = (models.Gasto) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((models_GastoRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_GastoRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_GastoRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importeColKey, objKey, ((models_GastoRealmProxyInterface) object).realmGet$importe(), false);
            java.util.Date realmGet$fecha = ((models_GastoRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.fechaColKey, objKey, realmGet$fecha.getTime(), false);
            }

            models.Categoria categoriaObj = ((models_GastoRealmProxyInterface) object).realmGet$categoria();
            if (categoriaObj != null) {
                Long cachecategoria = cache.get(categoriaObj);
                if (cachecategoria == null) {
                    cachecategoria = models_CategoriaRealmProxy.insert(realm, categoriaObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.categoriaColKey, objKey, cachecategoria, false);
            }

            models.Divisa divisaObj = ((models_GastoRealmProxyInterface) object).realmGet$divisa();
            if (divisaObj != null) {
                Long cachedivisa = cache.get(divisaObj);
                if (cachedivisa == null) {
                    cachedivisa = models_DivisaRealmProxy.insert(realm, divisaObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.divisaColKey, objKey, cachedivisa, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.id_userColKey, objKey, ((models_GastoRealmProxyInterface) object).realmGet$id_user(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, models.Gasto object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(models.Gasto.class);
        long tableNativePtr = table.getNativePtr();
        GastoColumnInfo columnInfo = (GastoColumnInfo) realm.getSchema().getColumnInfo(models.Gasto.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((models_GastoRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_GastoRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_GastoRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importeColKey, objKey, ((models_GastoRealmProxyInterface) object).realmGet$importe(), false);
        java.util.Date realmGet$fecha = ((models_GastoRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.fechaColKey, objKey, realmGet$fecha.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaColKey, objKey, false);
        }

        models.Categoria categoriaObj = ((models_GastoRealmProxyInterface) object).realmGet$categoria();
        if (categoriaObj != null) {
            Long cachecategoria = cache.get(categoriaObj);
            if (cachecategoria == null) {
                cachecategoria = models_CategoriaRealmProxy.insertOrUpdate(realm, categoriaObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.categoriaColKey, objKey, cachecategoria, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.categoriaColKey, objKey);
        }

        models.Divisa divisaObj = ((models_GastoRealmProxyInterface) object).realmGet$divisa();
        if (divisaObj != null) {
            Long cachedivisa = cache.get(divisaObj);
            if (cachedivisa == null) {
                cachedivisa = models_DivisaRealmProxy.insertOrUpdate(realm, divisaObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.divisaColKey, objKey, cachedivisa, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.divisaColKey, objKey);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.id_userColKey, objKey, ((models_GastoRealmProxyInterface) object).realmGet$id_user(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(models.Gasto.class);
        long tableNativePtr = table.getNativePtr();
        GastoColumnInfo columnInfo = (GastoColumnInfo) realm.getSchema().getColumnInfo(models.Gasto.class);
        long pkColumnKey = columnInfo.idColKey;
        models.Gasto object = null;
        while (objects.hasNext()) {
            object = (models.Gasto) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((models_GastoRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_GastoRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_GastoRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importeColKey, objKey, ((models_GastoRealmProxyInterface) object).realmGet$importe(), false);
            java.util.Date realmGet$fecha = ((models_GastoRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.fechaColKey, objKey, realmGet$fecha.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fechaColKey, objKey, false);
            }

            models.Categoria categoriaObj = ((models_GastoRealmProxyInterface) object).realmGet$categoria();
            if (categoriaObj != null) {
                Long cachecategoria = cache.get(categoriaObj);
                if (cachecategoria == null) {
                    cachecategoria = models_CategoriaRealmProxy.insertOrUpdate(realm, categoriaObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.categoriaColKey, objKey, cachecategoria, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.categoriaColKey, objKey);
            }

            models.Divisa divisaObj = ((models_GastoRealmProxyInterface) object).realmGet$divisa();
            if (divisaObj != null) {
                Long cachedivisa = cache.get(divisaObj);
                if (cachedivisa == null) {
                    cachedivisa = models_DivisaRealmProxy.insertOrUpdate(realm, divisaObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.divisaColKey, objKey, cachedivisa, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.divisaColKey, objKey);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.id_userColKey, objKey, ((models_GastoRealmProxyInterface) object).realmGet$id_user(), false);
        }
    }

    public static models.Gasto createDetachedCopy(models.Gasto realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        models.Gasto unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new models.Gasto();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (models.Gasto) cachedObject.object;
            }
            unmanagedObject = (models.Gasto) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        models_GastoRealmProxyInterface unmanagedCopy = (models_GastoRealmProxyInterface) unmanagedObject;
        models_GastoRealmProxyInterface realmSource = (models_GastoRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$importe(realmSource.realmGet$importe());
        unmanagedCopy.realmSet$fecha(realmSource.realmGet$fecha());

        // Deep copy of categoria
        unmanagedCopy.realmSet$categoria(models_CategoriaRealmProxy.createDetachedCopy(realmSource.realmGet$categoria(), currentDepth + 1, maxDepth, cache));

        // Deep copy of divisa
        unmanagedCopy.realmSet$divisa(models_DivisaRealmProxy.createDetachedCopy(realmSource.realmGet$divisa(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$id_user(realmSource.realmGet$id_user());

        return unmanagedObject;
    }

    static models.Gasto update(Realm realm, GastoColumnInfo columnInfo, models.Gasto realmObject, models.Gasto newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        models_GastoRealmProxyInterface realmObjectTarget = (models_GastoRealmProxyInterface) realmObject;
        models_GastoRealmProxyInterface realmObjectSource = (models_GastoRealmProxyInterface) newObject;
        Table table = realm.getTable(models.Gasto.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addDouble(columnInfo.importeColKey, realmObjectSource.realmGet$importe());
        builder.addDate(columnInfo.fechaColKey, realmObjectSource.realmGet$fecha());

        models.Categoria categoriaObj = realmObjectSource.realmGet$categoria();
        if (categoriaObj == null) {
            builder.addNull(columnInfo.categoriaColKey);
        } else {
            models.Categoria cachecategoria = (models.Categoria) cache.get(categoriaObj);
            if (cachecategoria != null) {
                builder.addObject(columnInfo.categoriaColKey, cachecategoria);
            } else {
                builder.addObject(columnInfo.categoriaColKey, models_CategoriaRealmProxy.copyOrUpdate(realm, (models_CategoriaRealmProxy.CategoriaColumnInfo) realm.getSchema().getColumnInfo(models.Categoria.class), categoriaObj, true, cache, flags));
            }
        }

        models.Divisa divisaObj = realmObjectSource.realmGet$divisa();
        if (divisaObj == null) {
            builder.addNull(columnInfo.divisaColKey);
        } else {
            models.Divisa cachedivisa = (models.Divisa) cache.get(divisaObj);
            if (cachedivisa != null) {
                builder.addObject(columnInfo.divisaColKey, cachedivisa);
            } else {
                builder.addObject(columnInfo.divisaColKey, models_DivisaRealmProxy.copyOrUpdate(realm, (models_DivisaRealmProxy.DivisaColumnInfo) realm.getSchema().getColumnInfo(models.Divisa.class), divisaObj, true, cache, flags));
            }
        }
        builder.addInteger(columnInfo.id_userColKey, realmObjectSource.realmGet$id_user());

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
        models_GastoRealmProxy aGasto = (models_GastoRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aGasto.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGasto.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aGasto.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
