package models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0006\u0010#\u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lmodels/Usuario;", "Lio/realm/RealmObject;", "()V", "email", "", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "id", "", "getId", "()I", "setId", "(I)V", "listaGastos", "Lio/realm/RealmList;", "Lmodels/Gasto;", "getListaGastos", "()Lio/realm/RealmList;", "setListaGastos", "(Lio/realm/RealmList;)V", "nombre", "getNombre", "setNombre", "password", "getPassword", "setPassword", "saldo", "", "getSaldo", "()D", "setSaldo", "(D)V", "toString", "totalGastos", "app_debug"})
@io.realm.annotations.RealmClass
public class Usuario extends io.realm.RealmObject {
    @io.realm.annotations.PrimaryKey
    private int id = 0;
    @org.jetbrains.annotations.NotNull
    @io.realm.annotations.Required
    private java.lang.String nombre = "";
    @org.jetbrains.annotations.NotNull
    @io.realm.annotations.Required
    private java.lang.String password = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String email = "";
    private double saldo = 0.0;
    @org.jetbrains.annotations.Nullable
    private io.realm.RealmList<models.Gasto> listaGastos;
    
    public Usuario() {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNombre() {
        return null;
    }
    
    public final void setNombre(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final double getSaldo() {
        return 0.0;
    }
    
    public final void setSaldo(double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final io.realm.RealmList<models.Gasto> getListaGastos() {
        return null;
    }
    
    public final void setListaGastos(@org.jetbrains.annotations.Nullable
    io.realm.RealmList<models.Gasto> p0) {
    }
    
    public final double totalGastos() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}