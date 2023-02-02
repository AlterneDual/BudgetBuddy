package CRUD;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nJE\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0002\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006 "}, d2 = {"LCRUD/GastoCRUD;", "", "()V", "realm", "Lio/realm/Realm;", "getRealm", "()Lio/realm/Realm;", "setRealm", "(Lio/realm/Realm;)V", "addGasto", "", "gasto", "Lmodels/Gasto;", "cleanAll", "", "deleteGasto", "id", "getAllGastos", "", "getGasto", "getKey", "updateGasto", "new_importe", "", "new_fecha", "", "new_categoria", "Lmodels/Categoria;", "new_desc", "new_divisa", "Lmodels/Divisa;", "(ILjava/lang/Double;Ljava/lang/String;Lmodels/Categoria;Ljava/lang/String;Lmodels/Divisa;)V", "app_debug"})
public class GastoCRUD {
    @org.jetbrains.annotations.NotNull()
    private io.realm.Realm realm;
    
    public GastoCRUD() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.realm.Realm getRealm() {
        return null;
    }
    
    public final void setRealm(@org.jetbrains.annotations.NotNull()
    io.realm.Realm p0) {
    }
    
    public final int addGasto(@org.jetbrains.annotations.NotNull()
    models.Gasto gasto) {
        return 0;
    }
    
    public final int getKey() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final models.Gasto getGasto(int id) {
        return null;
    }
    
    public final void updateGasto(int id, @org.jetbrains.annotations.Nullable()
    java.lang.Double new_importe, @org.jetbrains.annotations.Nullable()
    java.lang.String new_fecha, @org.jetbrains.annotations.Nullable()
    models.Categoria new_categoria, @org.jetbrains.annotations.Nullable()
    java.lang.String new_desc, @org.jetbrains.annotations.Nullable()
    models.Divisa new_divisa) {
    }
    
    public final void deleteGasto(int id) {
    }
    
    public final void cleanAll() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<models.Gasto> getAllGastos() {
        return null;
    }
}