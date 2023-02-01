package models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lmodels/Categoria;", "Lio/realm/RealmObject;", "()V", "descripcion", "", "getDescripcion", "()Ljava/lang/String;", "setDescripcion", "(Ljava/lang/String;)V", "icono", "", "getIcono", "()Ljava/lang/Integer;", "setIcono", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "id", "getId", "()I", "setId", "(I)V", "nombre", "getNombre", "setNombre", "app_debug"})
@io.realm.annotations.RealmClass
public class Categoria extends io.realm.RealmObject {
    @io.realm.annotations.PrimaryKey
    private int id = 0;
    @org.jetbrains.annotations.Nullable
    private java.lang.String nombre = "";
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer icono = 0;
    @org.jetbrains.annotations.Nullable
    private java.lang.String descripcion = "";
    
    public Categoria() {
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
    public final java.lang.Integer getIcono() {
        return null;
    }
    
    public final void setIcono(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescripcion() {
        return null;
    }
    
    public final void setDescripcion(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}