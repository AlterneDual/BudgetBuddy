package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\u0016\u0010\u001d\u001a\u00020\u001c2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0015J\"\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u001cH\u0002J\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010.\u001a\u00020/J\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u00101\u001a\u00020/J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u00103\u001a\u00020/J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u00103\u001a\u0002052\u0006\u00106\u001a\u000205J\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u00103\u001a\u0002052\u0006\u00106\u001a\u000205R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInfo;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "MYGESTORVIEWINGRESOS_SETTING", "", "adapterList", "Lrun/budgetbuddy/adapter/myListAdapterInfoGasto;", "binding", "Lrun/budgetbuddy/databinding/MgInfoBinding;", "gc", "LCRUD/GastoCRUD;", "getGc", "()LCRUD/GastoCRUD;", "setGc", "(LCRUD/GastoCRUD;)V", "list_view", "Landroid/widget/ListView;", "lista_gastos", "", "Lmodels/Gasto;", "posActualGasto", "", "getPosActualGasto", "()I", "setPosActualGasto", "(I)V", "seleccionado", "check", "", "inicializarAdapter", "onContextItemSelected", "", "item", "Landroid/view/MenuItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "showDatePicker", "verInfoAno", "ano", "Ljava/sql/Date;", "verInfoDia", "fecha_hoy", "verInfoMes", "fecha_inicio", "verInfoPeriodo", "Ljava/util/Date;", "fecha_final", "verInfoSemana", "app_debug"})
public final class MgInfo extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInfoBinding binding;
    private int seleccionado = 1;
    @org.jetbrains.annotations.NotNull()
    private CRUD.GastoCRUD gc;
    private android.widget.ListView list_view;
    private run.budgetbuddy.adapter.myListAdapterInfoGasto adapterList;
    private java.util.List<models.Gasto> lista_gastos;
    private int posActualGasto = 0;
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
    
    public final int getPosActualGasto() {
        return 0;
    }
    
    public final void setPosActualGasto(int p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<models.Gasto> verInfoSemana(@org.jetbrains.annotations.NotNull()
    java.util.Date fecha_inicio, @org.jetbrains.annotations.NotNull()
    java.util.Date fecha_final) {
        return null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<models.Gasto> verInfoPeriodo(@org.jetbrains.annotations.NotNull()
    java.util.Date fecha_inicio, @org.jetbrains.annotations.NotNull()
    java.util.Date fecha_final) {
        return null;
    }
    
    private final void showDatePicker() {
    }
    
    private final void inicializarAdapter(java.util.List<models.Gasto> lista_gastos) {
    }
    
    @java.lang.Override()
    public void onCreateContextMenu(@org.jetbrains.annotations.NotNull()
    android.view.ContextMenu menu, @org.jetbrains.annotations.Nullable()
    android.view.View v, @org.jetbrains.annotations.NotNull()
    android.view.ContextMenu.ContextMenuInfo menuInfo) {
    }
    
    @java.lang.Override()
    public boolean onContextItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
}