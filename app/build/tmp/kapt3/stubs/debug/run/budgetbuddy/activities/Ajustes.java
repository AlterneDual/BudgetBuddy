package run.budgetbuddy.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lrun/budgetbuddy/activities/Ajustes;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapterList", "Lrun/budgetbuddy/adapter/myListAdapter;", "binding", "Lrun/budgetbuddy/databinding/ActivityAjustesBinding;", "getBinding", "()Lrun/budgetbuddy/databinding/ActivityAjustesBinding;", "setBinding", "(Lrun/budgetbuddy/databinding/ActivityAjustesBinding;)V", "list_view", "Landroid/widget/ListView;", "listaOpciones", "", "Lmodels/ItemGenerico;", "posActual", "", "abrirOpcion", "", "crearAjustes", "inicializarAdapter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class Ajustes extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.adapter.myListAdapter adapterList;
    private android.widget.ListView list_view;
    private java.util.List<models.ItemGenerico> listaOpciones;
    private int posActual = 0;
    public run.budgetbuddy.databinding.ActivityAjustesBinding binding;
    
    public Ajustes() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final run.budgetbuddy.databinding.ActivityAjustesBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    run.budgetbuddy.databinding.ActivityAjustesBinding p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void inicializarAdapter() {
    }
    
    private final java.util.List<models.ItemGenerico> crearAjustes() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams"})
    public final void abrirOpcion() {
    }
}