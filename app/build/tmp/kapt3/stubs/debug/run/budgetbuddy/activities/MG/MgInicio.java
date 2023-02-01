package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020\'H\u0002J\u0012\u0010(\u001a\u00020\'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicio;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lrun/budgetbuddy/adapter/myListAdapter_gasto;", "binding", "Lrun/budgetbuddy/databinding/MgInicioGastosBinding;", "categoriaCRUD", "LCRUD/CategoriaCRUD;", "getCategoriaCRUD", "()LCRUD/CategoriaCRUD;", "setCategoriaCRUD", "(LCRUD/CategoriaCRUD;)V", "divisaCRUD", "LCRUD/DivisaCRUD;", "getDivisaCRUD", "()LCRUD/DivisaCRUD;", "setDivisaCRUD", "(LCRUD/DivisaCRUD;)V", "gastoCRUD", "LCRUD/GastoCRUD;", "getGastoCRUD", "()LCRUD/GastoCRUD;", "setGastoCRUD", "(LCRUD/GastoCRUD;)V", "listagastos", "Lio/realm/RealmList;", "Lmodels/Gasto;", "getListagastos", "()Lio/realm/RealmList;", "setListagastos", "(Lio/realm/RealmList;)V", "usuarioCRUD", "LCRUD/UsuarioCRUD;", "getUsuarioCRUD", "()LCRUD/UsuarioCRUD;", "setUsuarioCRUD", "(LCRUD/UsuarioCRUD;)V", "crearGasto", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MgInicio extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInicioGastosBinding binding;
    private run.budgetbuddy.adapter.myListAdapter_gasto adapter;
    @org.jetbrains.annotations.NotNull()
    private CRUD.CategoriaCRUD categoriaCRUD;
    @org.jetbrains.annotations.NotNull()
    private CRUD.DivisaCRUD divisaCRUD;
    @org.jetbrains.annotations.NotNull()
    private CRUD.GastoCRUD gastoCRUD;
    @org.jetbrains.annotations.NotNull()
    private CRUD.UsuarioCRUD usuarioCRUD;
    @org.jetbrains.annotations.NotNull()
    private io.realm.RealmList<models.Gasto> listagastos;
    
    public MgInicio() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final CRUD.CategoriaCRUD getCategoriaCRUD() {
        return null;
    }
    
    public final void setCategoriaCRUD(@org.jetbrains.annotations.NotNull()
    CRUD.CategoriaCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final CRUD.DivisaCRUD getDivisaCRUD() {
        return null;
    }
    
    public final void setDivisaCRUD(@org.jetbrains.annotations.NotNull()
    CRUD.DivisaCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final CRUD.GastoCRUD getGastoCRUD() {
        return null;
    }
    
    public final void setGastoCRUD(@org.jetbrains.annotations.NotNull()
    CRUD.GastoCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final CRUD.UsuarioCRUD getUsuarioCRUD() {
        return null;
    }
    
    public final void setUsuarioCRUD(@org.jetbrains.annotations.NotNull()
    CRUD.UsuarioCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.realm.RealmList<models.Gasto> getListagastos() {
        return null;
    }
    
    public final void setListagastos(@org.jetbrains.annotations.NotNull()
    io.realm.RealmList<models.Gasto> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void crearGasto() {
    }
}