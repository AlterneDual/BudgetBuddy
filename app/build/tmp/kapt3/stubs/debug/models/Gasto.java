package models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00100\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00061"}, d2 = {"Lmodels/Gasto;", "Lio/realm/RealmObject;", "()V", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "setCalendar", "(Ljava/util/Calendar;)V", "categoria", "Lmodels/Categoria;", "getCategoria", "()Lmodels/Categoria;", "setCategoria", "(Lmodels/Categoria;)V", "descripcion", "", "getDescripcion", "()Ljava/lang/String;", "setDescripcion", "(Ljava/lang/String;)V", "divisa", "Lmodels/Divisa;", "getDivisa", "()Lmodels/Divisa;", "setDivisa", "(Lmodels/Divisa;)V", "fecha", "Ljava/util/Date;", "getFecha", "()Ljava/util/Date;", "setFecha", "(Ljava/util/Date;)V", "id", "", "getId", "()I", "setId", "(I)V", "id_user", "getId_user", "setId_user", "importe", "", "getImporte", "()D", "setImporte", "(D)V", "toString", "app_debug"})
@io.realm.annotations.RealmClass
public class Gasto extends io.realm.RealmObject {
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.Transient
    private transient java.util.Calendar calendar;
    @io.realm.annotations.PrimaryKey
    private int id = 0;
    private double importe = 0.0;
    @org.jetbrains.annotations.NotNull
    private java.util.Date fecha;
    @org.jetbrains.annotations.Nullable
    private models.Categoria categoria;
    @org.jetbrains.annotations.NotNull
    private java.lang.String descripcion = "";
    @org.jetbrains.annotations.Nullable
    private models.Divisa divisa;
    private int id_user = 0;
    
    public Gasto() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendar() {
        return null;
    }
    
    public final void setCalendar(@org.jetbrains.annotations.NotNull
    java.util.Calendar p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public final double getImporte() {
        return 0.0;
    }
    
    public final void setImporte(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getFecha() {
        return null;
    }
    
    public final void setFecha(@org.jetbrains.annotations.NotNull
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final models.Categoria getCategoria() {
        return null;
    }
    
    public final void setCategoria(@org.jetbrains.annotations.Nullable
    models.Categoria p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescripcion() {
        return null;
    }
    
    public final void setDescripcion(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final models.Divisa getDivisa() {
        return null;
    }
    
    public final void setDivisa(@org.jetbrains.annotations.Nullable
    models.Divisa p0) {
    }
    
    public final int getId_user() {
        return 0;
    }
    
    public final void setId_user(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}