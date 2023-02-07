package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicio;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lrun/budgetbuddy/adapter/myListAdapter_gasto;", "binding", "Lrun/budgetbuddy/databinding/MgInicioGastosBinding;", "listagastos", "Lio/realm/RealmList;", "Lmodels/Gasto;", "getListagastos", "()Lio/realm/RealmList;", "setListagastos", "(Lio/realm/RealmList;)V", "cargar", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MgInicio extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInicioGastosBinding binding;
    private run.budgetbuddy.adapter.myListAdapter_gasto adapter;
    @org.jetbrains.annotations.NotNull
    private io.realm.RealmList<models.Gasto> listagastos;
    
    public MgInicio() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final io.realm.RealmList<models.Gasto> getListagastos() {
        return null;
    }
    
    public final void setListagastos(@org.jetbrains.annotations.NotNull
    io.realm.RealmList<models.Gasto> p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void cargar() {
    }
}