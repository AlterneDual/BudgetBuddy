package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0016\u0010\u0018\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0015J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001e\u001a\u00020\u001fJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010!\u001a\u00020\u001fJ\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010#\u001a\u00020\u001fJ\u0016\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fJ\u0016\u0010\'\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInfo;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "MYGESTORVIEWINGRESOS_SETTING", "", "adapterList", "Lrun/budgetbuddy/adapter/myListAdapterInfoGasto;", "binding", "Lrun/budgetbuddy/databinding/MgInfoBinding;", "gc", "LCRUD/GastoCRUD;", "getGc", "()LCRUD/GastoCRUD;", "setGc", "(LCRUD/GastoCRUD;)V", "list_view", "Landroid/widget/ListView;", "lista_gastos", "", "Lmodels/Gasto;", "seleccionado", "", "check", "", "inicializarAdapter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDatePicker", "verInfoAno", "ano", "Ljava/sql/Date;", "verInfoDia", "fecha_hoy", "verInfoMes", "fecha_inicio", "verInfoPeriodo", "fecha_a", "fecha_b", "verInfoSemana", "fecha_final", "app_debug"})
public final class MgInfo extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInfoBinding binding;
    private int seleccionado = 1;
    @org.jetbrains.annotations.NotNull()
    private CRUD.GastoCRUD gc;
    private android.widget.ListView list_view;
    private run.budgetbuddy.adapter.myListAdapterInfoGasto adapterList;
    private java.util.List<models.Gasto> lista_gastos;
    private java.lang.String MYGESTORVIEWINGRESOS_SETTING = "MyGestorView";
    
    public MgInfo() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final CRUD.GastoCRUD getGc() {
        return null;
    }
    
    public final void setGc(@org.jetbrains.annotations.NotNull()
    CRUD.GastoCRUD p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    public final void check() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<models.Gasto> verInfoDia(@org.jetbrains.annotations.NotNull()
    java.sql.Date fecha_hoy) {
        return null;
    }
    
    public final void verInfoSemana(@org.jetbrains.annotations.NotNull()
    java.sql.Date fecha_inicio, @org.jetbrains.annotations.NotNull()
    java.sql.Date fecha_final) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<models.Gasto> verInfoMes(@org.jetbrains.annotations.NotNull()
    java.sql.Date fecha_inicio) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<models.Gasto> verInfoAno(@org.jetbrains.annotations.NotNull()
    java.sql.Date ano) {
        return null;
    }
    
    public final void verInfoPeriodo(@org.jetbrains.annotations.NotNull()
    java.sql.Date fecha_a, @org.jetbrains.annotations.NotNull()
    java.sql.Date fecha_b) {
    }
    
    private final void showDatePicker() {
    }
    
    private final void inicializarAdapter(java.util.List<models.Gasto> lista_gastos) {
    }
}