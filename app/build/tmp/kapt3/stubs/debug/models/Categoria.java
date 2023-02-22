package models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0017\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001e\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lmodels/Categoria;", "Lio/realm/RealmObject;", "()V", "nombre", "", "color", "", "icono", "color_hex", "(Ljava/lang/String;IILjava/lang/String;)V", "getColor", "()I", "setColor", "(I)V", "getColor_hex", "()Ljava/lang/String;", "setColor_hex", "(Ljava/lang/String;)V", "descripcion", "getDescripcion", "setDescripcion", "getIcono", "setIcono", "id", "getId", "setId", "getNombre", "setNombre", "toString", "app_debug"})
@io.realm.annotations.RealmClass()
public class Categoria extends io.realm.RealmObject {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nombre;
    private int color;
    private int icono;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String color_hex;
    @io.realm.annotations.PrimaryKey()
    private int id = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String descripcion = "";
    
    public Categoria(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre, int color, int icono, @org.jetbrains.annotations.NotNull()
    java.lang.String color_hex) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNombre() {
        return null;
    }
    
    public final void setNombre(@org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getColor_hex() {
        return null;
    }
    
    public final void setColor_hex(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Categoria() {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescripcion() {
        return null;
    }
    
    public final void setDescripcion(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
}