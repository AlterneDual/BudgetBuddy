package models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f\u00a8\u0006\""}, d2 = {"Lmodels/Divisa;", "Lio/realm/RealmObject;", "()V", "destino", "", "getDestino", "()Ljava/lang/Double;", "setDestino", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "divDestino", "", "getDivDestino", "()Ljava/lang/String;", "setDivDestino", "(Ljava/lang/String;)V", "divOrigen", "getDivOrigen", "setDivOrigen", "id", "", "getId", "()I", "setId", "(I)V", "nombre", "getNombre", "setNombre", "origen", "getOrigen", "setOrigen", "simbolo", "getSimbolo", "setSimbolo", "app_debug"})
@io.realm.annotations.RealmClass
public class Divisa extends io.realm.RealmObject {
    @io.realm.annotations.PrimaryKey
    private int id = 0;
    @org.jetbrains.annotations.Nullable
    private java.lang.String nombre;
    @org.jetbrains.annotations.Nullable
    private java.lang.String simbolo = "";
    @org.jetbrains.annotations.Nullable
    private java.lang.String divOrigen;
    @org.jetbrains.annotations.Nullable
    private java.lang.String divDestino = "";
    @org.jetbrains.annotations.Nullable
    private java.lang.Double origen = 0.0;
    @org.jetbrains.annotations.Nullable
    private java.lang.Double destino = 0.0;
    
    public Divisa() {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNombre() {
        return null;
    }
    
    public final void setNombre(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSimbolo() {
        return null;
    }
    
    public final void setSimbolo(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDivOrigen() {
        return null;
    }
    
    public final void setDivOrigen(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDivDestino() {
        return null;
    }
    
    public final void setDivDestino(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getOrigen() {
        return null;
    }
    
    public final void setOrigen(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getDestino() {
        return null;
    }
    
    public final void setDestino(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
}