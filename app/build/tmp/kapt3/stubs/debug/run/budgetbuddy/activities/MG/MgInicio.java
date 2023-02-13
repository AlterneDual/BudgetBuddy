package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0007J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0015J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicio;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lrun/budgetbuddy/adapter/myListAdapter_gasto;", "binding", "Lrun/budgetbuddy/databinding/MgInicioGastosBinding;", "gastoCRUD", "LCRUD/GastoCRUD;", "getGastoCRUD", "()LCRUD/GastoCRUD;", "setGastoCRUD", "(LCRUD/GastoCRUD;)V", "listagastosBD", "Lio/realm/RealmList;", "Lmodels/Gasto;", "getListagastosBD", "()Lio/realm/RealmList;", "setListagastosBD", "(Lio/realm/RealmList;)V", "seleccionado", "", "GetAllGastos", "", "IniciarAdapter", "check", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDatePicker", "verGrafico", "app_debug"})
public final class MgInicio extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInicioGastosBinding binding;
    private run.budgetbuddy.adapter.myListAdapter_gasto adapter;
    @org.jetbrains.annotations.NotNull
    private io.realm.RealmList<models.Gasto> listagastosBD;
    @org.jetbrains.annotations.NotNull
    private CRUD.GastoCRUD gastoCRUD;
    private int seleccionado = 1;
    
    public MgInicio() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final io.realm.RealmList<models.Gasto> getListagastosBD() {
        return null;
    }
    
    public final void setListagastosBD(@org.jetbrains.annotations.NotNull
    io.realm.RealmList<models.Gasto> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final CRUD.GastoCRUD getGastoCRUD() {
        return null;
    }
    
    public final void setGastoCRUD(@org.jetbrains.annotations.NotNull
    CRUD.GastoCRUD p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void verGrafico() {
    }
    
    private final void IniciarAdapter() {
    }
    
    private final void GetAllGastos() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    public final void check() {
    }
    
    private final void showDatePicker() {
    }
}