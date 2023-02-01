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
public class models_DivisaRealmProxy extends models.Divisa
    implements RealmObjectProxy, models_DivisaRealmProxyInterface {

    static final class DivisaColumnInfo extends ColumnInfo {
        long idColKey;
        long nombreColKey;
        long simboloColKey;
        long divOrigenColKey;
        long divDestinoColKey;
        long origenColKey;
        long destinoColKey;

        DivisaColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Divisa");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.nombreColKey = addColumnDetails("nombre", "nombre", objectSchemaInfo);
            this.simboloColKey = addColumnDetails("simbolo", "simbolo", objectSchemaInfo);
            this.divOrigenColKey = addColumnDetails("divOrigen", "divOrigen", objectSchemaInfo);
            this.divDestinoColKey = addColumnDetails("divDestino", "divDestino", objectSchemaInfo);
            this.origenColKey = addColumnDetails("origen", "origen", objectSchemaInfo);
            this.destinoColKey = addColumnDetails("destino", "destino", objectSchemaInfo);
        }

        DivisaColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DivisaColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DivisaColumnInfo src = (DivisaColumnInfo) rawSrc;
            final DivisaColumnInfo dst = (DivisaColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.nombreColKey = src.nombreColKey;
            dst.simboloColKey = src.simboloColKey;
            dst.divOrigenColKey = src.divOrigenColKey;
            dst.divDestinoColKey = src.divDestinoColKey;
            dst.origenColKey = src.origenColKey;
            dst.destinoColKey = src.destinoColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private DivisaColumnInfo columnInfo;
    private ProxyState<models.Divisa> proxyState;

    models_DivisaRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DivisaColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<models.Divisa>(this);
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
                row.getTable().setNull(columnInfo.nombreColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombreColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombreColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombreColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$simbolo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.simboloColKey);
    }

    @Override
    public void realmSet$simbolo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.simboloColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.simboloColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.simboloColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.simboloColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$divOrigen() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.divOrigenColKey);
    }

    @Override
    public void realmSet$divOrigen(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.divOrigenColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.divOrigenColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.divOrigenColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.divOrigenColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$divDestino() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.divDestinoColKey);
    }

    @Override
    public void realmSet$divDestino(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.divDestinoColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.divDestinoColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.divDestinoColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.divDestinoColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$origen() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.origenColKey)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.origenColKey);
    }

    @Override
    public void realmSet$origen(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.origenColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.origenColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.origenColKey);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.origenColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$destino() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.destinoColKey)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.destinoColKey);
    }

    @Override
    public void realmSet$destino(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.destinoColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.destinoColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.destinoColKey);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.destinoColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Divisa", false, 7, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "nombre", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "simbolo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "divOrigen", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "divDestino", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "origen", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "destino", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DivisaColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DivisaColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Divisa";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Divisa";
    }

    @SuppressWarnings("cast")
    public static models.Divisa createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        models.Divisa obj = null;
        if (update) {
            Table table = realm.getTable(models.Divisa.class);
            DivisaColumnInfo columnInfo = (DivisaColumnInfo) realm.getSchema().getColumnInfo(models.Divisa.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(models.Divisa.class), false, Collections.<String> emptyList());
                    obj = new io.realm.models_DivisaRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.models_DivisaRealmProxy) realm.createObjectInternal(models.Divisa.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.models_DivisaRealmProxy) realm.createObjectInternal(models.Divisa.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final models_DivisaRealmProxyInterface objProxy = (models_DivisaRealmProxyInterface) obj;
        if (json.has("nombre")) {
            if (json.isNull("nombre")) {
                objProxy.realmSet$nombre(null);
            } else {
                objProxy.realmSet$nombre((String) json.getString("nombre"));
            }
        }
        if (json.has("simbolo")) {
            if (json.isNull("simbolo")) {
                objProxy.realmSet$simbolo(null);
            } else {
                objProxy.realmSet$simbolo((String) json.getString("simbolo"));
            }
        }
        if (json.has("divOrigen")) {
            if (json.isNull("divOrigen")) {
                objProxy.realmSet$divOrigen(null);
            } else {
                objProxy.realmSet$divOrigen((String) json.getString("divOrigen"));
            }
        }
        if (json.has("divDestino")) {
            if (json.isNull("divDestino")) {
                objProxy.realmSet$divDestino(null);
            } else {
                objProxy.realmSet$divDestino((String) json.getString("divDestino"));
            }
        }
        if (json.has("origen")) {
            if (json.isNull("origen")) {
                objProxy.realmSet$origen(null);
            } else {
                objProxy.realmSet$origen((double) json.getDouble("origen"));
            }
        }
        if (json.has("destino")) {
            if (json.isNull("destino")) {
                objProxy.realmSet$destino(null);
            } else {
                objProxy.realmSet$destino((double) json.getDouble("destino"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static models.Divisa createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final models.Divisa obj = new models.Divisa();
        final models_DivisaRealmProxyInterface objProxy = (models_DivisaRealmProxyInterface) obj;
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
            } else if (name.equals("simbolo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$simbolo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$simbolo(null);
                }
            } else if (name.equals("divOrigen")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$divOrigen((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$divOrigen(null);
                }
            } else if (name.equals("divDestino")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$divDestino((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$divDestino(null);
                }
            } else if (name.equals("origen")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$origen((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$origen(null);
                }
            } else if (name.equals("destino")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$destino((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$destino(null);
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

    static models_DivisaRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(models.Divisa.class), false, Collections.<String>emptyList());
        io.realm.models_DivisaRealmProxy obj = new io.realm.models_DivisaRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static models.Divisa copyOrUpdate(Realm realm, DivisaColumnInfo columnInfo, models.Divisa object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (models.Divisa) cachedRealmObject;
        }

        models.Divisa realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(models.Divisa.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((models_DivisaRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.models_DivisaRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static models.Divisa copy(Realm realm, DivisaColumnInfo columnInfo, models.Divisa newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (models.Divisa) cachedRealmObject;
        }

        models_DivisaRealmProxyInterface unmanagedSource = (models_DivisaRealmProxyInterface) newObject;

        Table table = realm.getTable(models.Divisa.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.nombreColKey, unmanagedSource.realmGet$nombre());
        builder.addString(columnInfo.simboloColKey, unmanagedSource.realmGet$simbolo());
        builder.addString(columnInfo.divOrigenColKey, unmanagedSource.realmGet$divOrigen());
        builder.addString(columnInfo.divDestinoColKey, unmanagedSource.realmGet$divDestino());
        builder.addDouble(columnInfo.origenColKey, unmanagedSource.realmGet$origen());
        builder.addDouble(columnInfo.destinoColKey, unmanagedSource.realmGet$destino());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.models_DivisaRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, models.Divisa object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(models.Divisa.class);
        long tableNativePtr = table.getNativePtr();
        DivisaColumnInfo columnInfo = (DivisaColumnInfo) realm.getSchema().getColumnInfo(models.Divisa.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((models_DivisaRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_DivisaRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_DivisaRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$nombre = ((models_DivisaRealmProxyInterface) object).realmGet$nombre();
        if (realmGet$nombre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
        }
        String realmGet$simbolo = ((models_DivisaRealmProxyInterface) object).realmGet$simbolo();
        if (realmGet$simbolo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.simboloColKey, objKey, realmGet$simbolo, false);
        }
        String realmGet$divOrigen = ((models_DivisaRealmProxyInterface) object).realmGet$divOrigen();
        if (realmGet$divOrigen != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.divOrigenColKey, objKey, realmGet$divOrigen, false);
        }
        String realmGet$divDestino = ((models_DivisaRealmProxyInterface) object).realmGet$divDestino();
        if (realmGet$divDestino != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.divDestinoColKey, objKey, realmGet$divDestino, false);
        }
        Double realmGet$origen = ((models_DivisaRealmProxyInterface) object).realmGet$origen();
        if (realmGet$origen != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.origenColKey, objKey, realmGet$origen, false);
        }
        Double realmGet$destino = ((models_DivisaRealmProxyInterface) object).realmGet$destino();
        if (realmGet$destino != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.destinoColKey, objKey, realmGet$destino, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(models.Divisa.class);
        long tableNativePtr = table.getNativePtr();
        DivisaColumnInfo columnInfo = (DivisaColumnInfo) realm.getSchema().getColumnInfo(models.Divisa.class);
        long pkColumnKey = columnInfo.idColKey;
        models.Divisa object = null;
        while (objects.hasNext()) {
            object = (models.Divisa) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((models_DivisaRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_DivisaRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_DivisaRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$nombre = ((models_DivisaRealmProxyInterface) object).realmGet$nombre();
            if (realmGet$nombre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
            }
            String realmGet$simbolo = ((models_DivisaRealmProxyInterface) object).realmGet$simbolo();
            if (realmGet$simbolo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.simboloColKey, objKey, realmGet$simbolo, false);
            }
            String realmGet$divOrigen = ((models_DivisaRealmProxyInterface) object).realmGet$divOrigen();
            if (realmGet$divOrigen != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.divOrigenColKey, objKey, realmGet$divOrigen, false);
            }
            String realmGet$divDestino = ((models_DivisaRealmProxyInterface) object).realmGet$divDestino();
            if (realmGet$divDestino != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.divDestinoColKey, objKey, realmGet$divDestino, false);
            }
            Double realmGet$origen = ((models_DivisaRealmProxyInterface) object).realmGet$origen();
            if (realmGet$origen != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.origenColKey, objKey, realmGet$origen, false);
            }
            Double realmGet$destino = ((models_DivisaRealmProxyInterface) object).realmGet$destino();
            if (realmGet$destino != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.destinoColKey, objKey, realmGet$destino, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, models.Divisa object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(models.Divisa.class);
        long tableNativePtr = table.getNativePtr();
        DivisaColumnInfo columnInfo = (DivisaColumnInfo) realm.getSchema().getColumnInfo(models.Divisa.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((models_DivisaRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_DivisaRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_DivisaRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        String realmGet$nombre = ((models_DivisaRealmProxyInterface) object).realmGet$nombre();
        if (realmGet$nombre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombreColKey, objKey, false);
        }
        String realmGet$simbolo = ((models_DivisaRealmProxyInterface) object).realmGet$simbolo();
        if (realmGet$simbolo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.simboloColKey, objKey, realmGet$simbolo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.simboloColKey, objKey, false);
        }
        String realmGet$divOrigen = ((models_DivisaRealmProxyInterface) object).realmGet$divOrigen();
        if (realmGet$divOrigen != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.divOrigenColKey, objKey, realmGet$divOrigen, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.divOrigenColKey, objKey, false);
        }
        String realmGet$divDestino = ((models_DivisaRealmProxyInterface) object).realmGet$divDestino();
        if (realmGet$divDestino != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.divDestinoColKey, objKey, realmGet$divDestino, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.divDestinoColKey, objKey, false);
        }
        Double realmGet$origen = ((models_DivisaRealmProxyInterface) object).realmGet$origen();
        if (realmGet$origen != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.origenColKey, objKey, realmGet$origen, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.origenColKey, objKey, false);
        }
        Double realmGet$destino = ((models_DivisaRealmProxyInterface) object).realmGet$destino();
        if (realmGet$destino != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.destinoColKey, objKey, realmGet$destino, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.destinoColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(models.Divisa.class);
        long tableNativePtr = table.getNativePtr();
        DivisaColumnInfo columnInfo = (DivisaColumnInfo) realm.getSchema().getColumnInfo(models.Divisa.class);
        long pkColumnKey = columnInfo.idColKey;
        models.Divisa object = null;
        while (objects.hasNext()) {
            object = (models.Divisa) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((models_DivisaRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_DivisaRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_DivisaRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            String realmGet$nombre = ((models_DivisaRealmProxyInterface) object).realmGet$nombre();
            if (realmGet$nombre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombreColKey, objKey, false);
            }
            String realmGet$simbolo = ((models_DivisaRealmProxyInterface) object).realmGet$simbolo();
            if (realmGet$simbolo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.simboloColKey, objKey, realmGet$simbolo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.simboloColKey, objKey, false);
            }
            String realmGet$divOrigen = ((models_DivisaRealmProxyInterface) object).realmGet$divOrigen();
            if (realmGet$divOrigen != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.divOrigenColKey, objKey, realmGet$divOrigen, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.divOrigenColKey, objKey, false);
            }
            String realmGet$divDestino = ((models_DivisaRealmProxyInterface) object).realmGet$divDestino();
            if (realmGet$divDestino != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.divDestinoColKey, objKey, realmGet$divDestino, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.divDestinoColKey, objKey, false);
            }
            Double realmGet$origen = ((models_DivisaRealmProxyInterface) object).realmGet$origen();
            if (realmGet$origen != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.origenColKey, objKey, realmGet$origen, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.origenColKey, objKey, false);
            }
            Double realmGet$destino = ((models_DivisaRealmProxyInterface) object).realmGet$destino();
            if (realmGet$destino != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.destinoColKey, objKey, realmGet$destino, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.destinoColKey, objKey, false);
            }
        }
    }

    public static models.Divisa createDetachedCopy(models.Divisa realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        models.Divisa unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new models.Divisa();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (models.Divisa) cachedObject.object;
            }
            unmanagedObject = (models.Divisa) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        models_DivisaRealmProxyInterface unmanagedCopy = (models_DivisaRealmProxyInterface) unmanagedObject;
        models_DivisaRealmProxyInterface realmSource = (models_DivisaRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nombre(realmSource.realmGet$nombre());
        unmanagedCopy.realmSet$simbolo(realmSource.realmGet$simbolo());
        unmanagedCopy.realmSet$divOrigen(realmSource.realmGet$divOrigen());
        unmanagedCopy.realmSet$divDestino(realmSource.realmGet$divDestino());
        unmanagedCopy.realmSet$origen(realmSource.realmGet$origen());
        unmanagedCopy.realmSet$destino(realmSource.realmGet$destino());

        return unmanagedObject;
    }

    static models.Divisa update(Realm realm, DivisaColumnInfo columnInfo, models.Divisa realmObject, models.Divisa newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        models_DivisaRealmProxyInterface realmObjectTarget = (models_DivisaRealmProxyInterface) realmObject;
        models_DivisaRealmProxyInterface realmObjectSource = (models_DivisaRealmProxyInterface) newObject;
        Table table = realm.getTable(models.Divisa.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nombreColKey, realmObjectSource.realmGet$nombre());
        builder.addString(columnInfo.simboloColKey, realmObjectSource.realmGet$simbolo());
        builder.addString(columnInfo.divOrigenColKey, realmObjectSource.realmGet$divOrigen());
        builder.addString(columnInfo.divDestinoColKey, realmObjectSource.realmGet$divDestino());
        builder.addDouble(columnInfo.origenColKey, realmObjectSource.realmGet$origen());
        builder.addDouble(columnInfo.destinoColKey, realmObjectSource.realmGet$destino());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Divisa = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre:");
        stringBuilder.append(realmGet$nombre() != null ? realmGet$nombre() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{simbolo:");
        stringBuilder.append(realmGet$simbolo() != null ? realmGet$simbolo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{divOrigen:");
        stringBuilder.append(realmGet$divOrigen() != null ? realmGet$divOrigen() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{divDestino:");
        stringBuilder.append(realmGet$divDestino() != null ? realmGet$divDestino() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{origen:");
        stringBuilder.append(realmGet$origen() != null ? realmGet$origen() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{destino:");
        stringBuilder.append(realmGet$destino() != null ? realmGet$destino() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
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
        models_DivisaRealmProxy aDivisa = (models_DivisaRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aDivisa.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDivisa.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aDivisa.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
