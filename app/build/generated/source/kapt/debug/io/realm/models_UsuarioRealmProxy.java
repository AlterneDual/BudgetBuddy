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
public class models_UsuarioRealmProxy extends models.Usuario
    implements RealmObjectProxy, models_UsuarioRealmProxyInterface {

    static final class UsuarioColumnInfo extends ColumnInfo {
        long idColKey;
        long nombreColKey;
        long passwordColKey;
        long emailColKey;
        long saldoColKey;
        long listaGastosColKey;

        UsuarioColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Usuario");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.nombreColKey = addColumnDetails("nombre", "nombre", objectSchemaInfo);
            this.passwordColKey = addColumnDetails("password", "password", objectSchemaInfo);
            this.emailColKey = addColumnDetails("email", "email", objectSchemaInfo);
            this.saldoColKey = addColumnDetails("saldo", "saldo", objectSchemaInfo);
            this.listaGastosColKey = addColumnDetails("listaGastos", "listaGastos", objectSchemaInfo);
        }

        UsuarioColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UsuarioColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UsuarioColumnInfo src = (UsuarioColumnInfo) rawSrc;
            final UsuarioColumnInfo dst = (UsuarioColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.nombreColKey = src.nombreColKey;
            dst.passwordColKey = src.passwordColKey;
            dst.emailColKey = src.emailColKey;
            dst.saldoColKey = src.saldoColKey;
            dst.listaGastosColKey = src.listaGastosColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UsuarioColumnInfo columnInfo;
    private ProxyState<models.Usuario> proxyState;
    private RealmList<models.Gasto> listaGastosRealmList;

    models_UsuarioRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UsuarioColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<models.Usuario>(this);
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
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordColKey);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'password' to null.");
            }
            row.getTable().setString(columnInfo.passwordColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'password' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.passwordColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailColKey);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
            }
            row.getTable().setString(columnInfo.emailColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.emailColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$saldo() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.saldoColKey);
    }

    @Override
    public void realmSet$saldo(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.saldoColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.saldoColKey, value);
    }

    @Override
    public RealmList<models.Gasto> realmGet$listaGastos() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (listaGastosRealmList != null) {
            return listaGastosRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.listaGastosColKey);
            listaGastosRealmList = new RealmList<models.Gasto>(models.Gasto.class, osList, proxyState.getRealm$realm());
            return listaGastosRealmList;
        }
    }

    @Override
    public void realmSet$listaGastos(RealmList<models.Gasto> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("listaGastos")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<models.Gasto> original = value;
                value = new RealmList<models.Gasto>();
                for (models.Gasto item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealmOrUpdate(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.listaGastosColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                models.Gasto linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                models.Gasto linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Usuario", false, 6, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "nombre", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "saldo", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "listaGastos", RealmFieldType.LIST, "Gasto");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UsuarioColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UsuarioColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Usuario";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Usuario";
    }

    @SuppressWarnings("cast")
    public static models.Usuario createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        models.Usuario obj = null;
        if (update) {
            Table table = realm.getTable(models.Usuario.class);
            UsuarioColumnInfo columnInfo = (UsuarioColumnInfo) realm.getSchema().getColumnInfo(models.Usuario.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(models.Usuario.class), false, Collections.<String> emptyList());
                    obj = new io.realm.models_UsuarioRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("listaGastos")) {
                excludeFields.add("listaGastos");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.models_UsuarioRealmProxy) realm.createObjectInternal(models.Usuario.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.models_UsuarioRealmProxy) realm.createObjectInternal(models.Usuario.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final models_UsuarioRealmProxyInterface objProxy = (models_UsuarioRealmProxyInterface) obj;
        if (json.has("nombre")) {
            if (json.isNull("nombre")) {
                objProxy.realmSet$nombre(null);
            } else {
                objProxy.realmSet$nombre((String) json.getString("nombre"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("saldo")) {
            if (json.isNull("saldo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'saldo' to null.");
            } else {
                objProxy.realmSet$saldo((double) json.getDouble("saldo"));
            }
        }
        if (json.has("listaGastos")) {
            if (json.isNull("listaGastos")) {
                objProxy.realmSet$listaGastos(null);
            } else {
                objProxy.realmGet$listaGastos().clear();
                JSONArray array = json.getJSONArray("listaGastos");
                for (int i = 0; i < array.length(); i++) {
                    models.Gasto item = models_GastoRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$listaGastos().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static models.Usuario createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final models.Usuario obj = new models.Usuario();
        final models_UsuarioRealmProxyInterface objProxy = (models_UsuarioRealmProxyInterface) obj;
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
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("saldo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$saldo((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'saldo' to null.");
                }
            } else if (name.equals("listaGastos")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$listaGastos(null);
                } else {
                    objProxy.realmSet$listaGastos(new RealmList<models.Gasto>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        models.Gasto item = models_GastoRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$listaGastos().add(item);
                    }
                    reader.endArray();
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

    static models_UsuarioRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(models.Usuario.class), false, Collections.<String>emptyList());
        io.realm.models_UsuarioRealmProxy obj = new io.realm.models_UsuarioRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static models.Usuario copyOrUpdate(Realm realm, UsuarioColumnInfo columnInfo, models.Usuario object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (models.Usuario) cachedRealmObject;
        }

        models.Usuario realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(models.Usuario.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((models_UsuarioRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.models_UsuarioRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static models.Usuario copy(Realm realm, UsuarioColumnInfo columnInfo, models.Usuario newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (models.Usuario) cachedRealmObject;
        }

        models_UsuarioRealmProxyInterface unmanagedSource = (models_UsuarioRealmProxyInterface) newObject;

        Table table = realm.getTable(models.Usuario.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.nombreColKey, unmanagedSource.realmGet$nombre());
        builder.addString(columnInfo.passwordColKey, unmanagedSource.realmGet$password());
        builder.addString(columnInfo.emailColKey, unmanagedSource.realmGet$email());
        builder.addDouble(columnInfo.saldoColKey, unmanagedSource.realmGet$saldo());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.models_UsuarioRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<models.Gasto> listaGastosUnmanagedList = unmanagedSource.realmGet$listaGastos();
        if (listaGastosUnmanagedList != null) {
            RealmList<models.Gasto> listaGastosManagedList = managedCopy.realmGet$listaGastos();
            listaGastosManagedList.clear();
            for (int i = 0; i < listaGastosUnmanagedList.size(); i++) {
                models.Gasto listaGastosUnmanagedItem = listaGastosUnmanagedList.get(i);
                models.Gasto cachelistaGastos = (models.Gasto) cache.get(listaGastosUnmanagedItem);
                if (cachelistaGastos != null) {
                    listaGastosManagedList.add(cachelistaGastos);
                } else {
                    listaGastosManagedList.add(models_GastoRealmProxy.copyOrUpdate(realm, (models_GastoRealmProxy.GastoColumnInfo) realm.getSchema().getColumnInfo(models.Gasto.class), listaGastosUnmanagedItem, update, cache, flags));
                }
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, models.Usuario object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(models.Usuario.class);
        long tableNativePtr = table.getNativePtr();
        UsuarioColumnInfo columnInfo = (UsuarioColumnInfo) realm.getSchema().getColumnInfo(models.Usuario.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((models_UsuarioRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_UsuarioRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_UsuarioRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$nombre = ((models_UsuarioRealmProxyInterface) object).realmGet$nombre();
        if (realmGet$nombre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
        }
        String realmGet$password = ((models_UsuarioRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        }
        String realmGet$email = ((models_UsuarioRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.saldoColKey, objKey, ((models_UsuarioRealmProxyInterface) object).realmGet$saldo(), false);

        RealmList<models.Gasto> listaGastosList = ((models_UsuarioRealmProxyInterface) object).realmGet$listaGastos();
        if (listaGastosList != null) {
            OsList listaGastosOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.listaGastosColKey);
            for (models.Gasto listaGastosItem : listaGastosList) {
                Long cacheItemIndexlistaGastos = cache.get(listaGastosItem);
                if (cacheItemIndexlistaGastos == null) {
                    cacheItemIndexlistaGastos = models_GastoRealmProxy.insert(realm, listaGastosItem, cache);
                }
                listaGastosOsList.addRow(cacheItemIndexlistaGastos);
            }
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(models.Usuario.class);
        long tableNativePtr = table.getNativePtr();
        UsuarioColumnInfo columnInfo = (UsuarioColumnInfo) realm.getSchema().getColumnInfo(models.Usuario.class);
        long pkColumnKey = columnInfo.idColKey;
        models.Usuario object = null;
        while (objects.hasNext()) {
            object = (models.Usuario) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((models_UsuarioRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_UsuarioRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_UsuarioRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$nombre = ((models_UsuarioRealmProxyInterface) object).realmGet$nombre();
            if (realmGet$nombre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
            }
            String realmGet$password = ((models_UsuarioRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            }
            String realmGet$email = ((models_UsuarioRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.saldoColKey, objKey, ((models_UsuarioRealmProxyInterface) object).realmGet$saldo(), false);

            RealmList<models.Gasto> listaGastosList = ((models_UsuarioRealmProxyInterface) object).realmGet$listaGastos();
            if (listaGastosList != null) {
                OsList listaGastosOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.listaGastosColKey);
                for (models.Gasto listaGastosItem : listaGastosList) {
                    Long cacheItemIndexlistaGastos = cache.get(listaGastosItem);
                    if (cacheItemIndexlistaGastos == null) {
                        cacheItemIndexlistaGastos = models_GastoRealmProxy.insert(realm, listaGastosItem, cache);
                    }
                    listaGastosOsList.addRow(cacheItemIndexlistaGastos);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, models.Usuario object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(models.Usuario.class);
        long tableNativePtr = table.getNativePtr();
        UsuarioColumnInfo columnInfo = (UsuarioColumnInfo) realm.getSchema().getColumnInfo(models.Usuario.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((models_UsuarioRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_UsuarioRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_UsuarioRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        String realmGet$nombre = ((models_UsuarioRealmProxyInterface) object).realmGet$nombre();
        if (realmGet$nombre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombreColKey, objKey, false);
        }
        String realmGet$password = ((models_UsuarioRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
        }
        String realmGet$email = ((models_UsuarioRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailColKey, objKey, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.saldoColKey, objKey, ((models_UsuarioRealmProxyInterface) object).realmGet$saldo(), false);

        OsList listaGastosOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.listaGastosColKey);
        RealmList<models.Gasto> listaGastosList = ((models_UsuarioRealmProxyInterface) object).realmGet$listaGastos();
        if (listaGastosList != null && listaGastosList.size() == listaGastosOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objectCount = listaGastosList.size();
            for (int i = 0; i < objectCount; i++) {
                models.Gasto listaGastosItem = listaGastosList.get(i);
                Long cacheItemIndexlistaGastos = cache.get(listaGastosItem);
                if (cacheItemIndexlistaGastos == null) {
                    cacheItemIndexlistaGastos = models_GastoRealmProxy.insertOrUpdate(realm, listaGastosItem, cache);
                }
                listaGastosOsList.setRow(i, cacheItemIndexlistaGastos);
            }
        } else {
            listaGastosOsList.removeAll();
            if (listaGastosList != null) {
                for (models.Gasto listaGastosItem : listaGastosList) {
                    Long cacheItemIndexlistaGastos = cache.get(listaGastosItem);
                    if (cacheItemIndexlistaGastos == null) {
                        cacheItemIndexlistaGastos = models_GastoRealmProxy.insertOrUpdate(realm, listaGastosItem, cache);
                    }
                    listaGastosOsList.addRow(cacheItemIndexlistaGastos);
                }
            }
        }

        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(models.Usuario.class);
        long tableNativePtr = table.getNativePtr();
        UsuarioColumnInfo columnInfo = (UsuarioColumnInfo) realm.getSchema().getColumnInfo(models.Usuario.class);
        long pkColumnKey = columnInfo.idColKey;
        models.Usuario object = null;
        while (objects.hasNext()) {
            object = (models.Usuario) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((models_UsuarioRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((models_UsuarioRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((models_UsuarioRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            String realmGet$nombre = ((models_UsuarioRealmProxyInterface) object).realmGet$nombre();
            if (realmGet$nombre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombreColKey, objKey, false);
            }
            String realmGet$password = ((models_UsuarioRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
            }
            String realmGet$email = ((models_UsuarioRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailColKey, objKey, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.saldoColKey, objKey, ((models_UsuarioRealmProxyInterface) object).realmGet$saldo(), false);

            OsList listaGastosOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.listaGastosColKey);
            RealmList<models.Gasto> listaGastosList = ((models_UsuarioRealmProxyInterface) object).realmGet$listaGastos();
            if (listaGastosList != null && listaGastosList.size() == listaGastosOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = listaGastosList.size();
                for (int i = 0; i < objectCount; i++) {
                    models.Gasto listaGastosItem = listaGastosList.get(i);
                    Long cacheItemIndexlistaGastos = cache.get(listaGastosItem);
                    if (cacheItemIndexlistaGastos == null) {
                        cacheItemIndexlistaGastos = models_GastoRealmProxy.insertOrUpdate(realm, listaGastosItem, cache);
                    }
                    listaGastosOsList.setRow(i, cacheItemIndexlistaGastos);
                }
            } else {
                listaGastosOsList.removeAll();
                if (listaGastosList != null) {
                    for (models.Gasto listaGastosItem : listaGastosList) {
                        Long cacheItemIndexlistaGastos = cache.get(listaGastosItem);
                        if (cacheItemIndexlistaGastos == null) {
                            cacheItemIndexlistaGastos = models_GastoRealmProxy.insertOrUpdate(realm, listaGastosItem, cache);
                        }
                        listaGastosOsList.addRow(cacheItemIndexlistaGastos);
                    }
                }
            }

        }
    }

    public static models.Usuario createDetachedCopy(models.Usuario realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        models.Usuario unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new models.Usuario();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (models.Usuario) cachedObject.object;
            }
            unmanagedObject = (models.Usuario) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        models_UsuarioRealmProxyInterface unmanagedCopy = (models_UsuarioRealmProxyInterface) unmanagedObject;
        models_UsuarioRealmProxyInterface realmSource = (models_UsuarioRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nombre(realmSource.realmGet$nombre());
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$saldo(realmSource.realmGet$saldo());

        // Deep copy of listaGastos
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$listaGastos(null);
        } else {
            RealmList<models.Gasto> managedlistaGastosList = realmSource.realmGet$listaGastos();
            RealmList<models.Gasto> unmanagedlistaGastosList = new RealmList<models.Gasto>();
            unmanagedCopy.realmSet$listaGastos(unmanagedlistaGastosList);
            int nextDepth = currentDepth + 1;
            int size = managedlistaGastosList.size();
            for (int i = 0; i < size; i++) {
                models.Gasto item = models_GastoRealmProxy.createDetachedCopy(managedlistaGastosList.get(i), nextDepth, maxDepth, cache);
                unmanagedlistaGastosList.add(item);
            }
        }

        return unmanagedObject;
    }

    static models.Usuario update(Realm realm, UsuarioColumnInfo columnInfo, models.Usuario realmObject, models.Usuario newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        models_UsuarioRealmProxyInterface realmObjectTarget = (models_UsuarioRealmProxyInterface) realmObject;
        models_UsuarioRealmProxyInterface realmObjectSource = (models_UsuarioRealmProxyInterface) newObject;
        Table table = realm.getTable(models.Usuario.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nombreColKey, realmObjectSource.realmGet$nombre());
        builder.addString(columnInfo.passwordColKey, realmObjectSource.realmGet$password());
        builder.addString(columnInfo.emailColKey, realmObjectSource.realmGet$email());
        builder.addDouble(columnInfo.saldoColKey, realmObjectSource.realmGet$saldo());

        RealmList<models.Gasto> listaGastosUnmanagedList = realmObjectSource.realmGet$listaGastos();
        if (listaGastosUnmanagedList != null) {
            RealmList<models.Gasto> listaGastosManagedCopy = new RealmList<models.Gasto>();
            for (int i = 0; i < listaGastosUnmanagedList.size(); i++) {
                models.Gasto listaGastosItem = listaGastosUnmanagedList.get(i);
                models.Gasto cachelistaGastos = (models.Gasto) cache.get(listaGastosItem);
                if (cachelistaGastos != null) {
                    listaGastosManagedCopy.add(cachelistaGastos);
                } else {
                    listaGastosManagedCopy.add(models_GastoRealmProxy.copyOrUpdate(realm, (models_GastoRealmProxy.GastoColumnInfo) realm.getSchema().getColumnInfo(models.Gasto.class), listaGastosItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.listaGastosColKey, listaGastosManagedCopy);
        } else {
            builder.addObjectList(columnInfo.listaGastosColKey, new RealmList<models.Gasto>());
        }

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
        models_UsuarioRealmProxy aUsuario = (models_UsuarioRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aUsuario.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUsuario.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aUsuario.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
