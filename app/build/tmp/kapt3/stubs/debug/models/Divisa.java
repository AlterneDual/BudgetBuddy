package models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e\u00a8\u0006\""}, d2 = {"Lmodels/Divisa;", "Lio/realm/RealmObject;", "()V", "destino", "", "getDestino", "()D", "setDestino", "(D)V", "divDestino", "", "getDivDestino", "()Ljava/lang/String;", "setDivDestino", "(Ljava/lang/String;)V", "divOrigen", "getDivOrigen", "setDivOrigen", "id", "", "getId", "()I", "setId", "(I)V", "nombre", "getNombre", "setNombre", "origen", "getOrigen", "setOrigen", "simbolo", "getSimbolo", "setSimbolo", "conversor", "app_debug"})
@io.realm.annotations.RealmClass()
public class Divisa extends io.realm.RealmObject {
    @io.realm.annotations.PrimaryKey()
    private int id = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nombre = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String simbolo = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String divOrigen;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String divDestino = "";
    private double origen = 0.0;
    private double destino = 0.0;
    
    public Divisa() {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNombre() {
        return null;
    }
    
    public final void setNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSimbolo() {
        return null;
    }
    
    public final void setSimbolo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDivOrigen() {
        return null;
    }
    
    public final void setDivOrigen(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDivDestino() {
        return null;
    }
    
    public final void setDivDestino(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final double getOrigen() {
        return 0.0;
    }
    
    public final void setOrigen(double p0) {
    }
    
    public final double getDestino() {
        return 0.0;
    }
    
    public final void setDestino(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String conversor() {
        return null;
    }
}