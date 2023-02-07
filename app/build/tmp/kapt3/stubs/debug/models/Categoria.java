package models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0017\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001e\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lmodels/Categoria;", "Lio/realm/RealmObject;", "()V", "nombre", "", "color", "", "icono", "(Ljava/lang/String;II)V", "getColor", "()I", "setColor", "(I)V", "descripcion", "getDescripcion", "()Ljava/lang/String;", "setDescripcion", "(Ljava/lang/String;)V", "getIcono", "setIcono", "id", "getId", "setId", "getNombre", "setNombre", "toString", "app_debug"})
@io.realm.annotations.RealmClass
public class Categoria extends io.realm.RealmObject {
    @org.jetbrains.annotations.NotNull
    private java.lang.String nombre;
    private int color;
    private int icono;
    @io.realm.annotations.PrimaryKey
    private int id = 0;
    @org.jetbrains.annotations.NotNull
    private java.lang.String descripcion = "";
    
    public Categoria(@org.jetbrains.annotations.NotNull
    java.lang.String nombre, int color, int icono) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNombre() {
        return null;
    }
    
    public final void setNombre(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int p0) {
    }
    
    public final int getIcono() {
        return 0;
    }
    
    public final void setIcono(int p0) {
    }
    
    public Categoria() {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescripcion() {
        return null;
    }
    
    public final void setDescripcion(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}