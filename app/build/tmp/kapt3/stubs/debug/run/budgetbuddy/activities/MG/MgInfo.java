package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0007J$\u0010+\u001a\u00020*2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\nH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u000102H\u0015J\"\u00103\u001a\u00020*2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020*H\u0002J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001f0\n2\u0006\u0010<\u001a\u00020=J\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020!0\n2\u0006\u0010<\u001a\u00020=J\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001f0\n2\u0006\u0010@\u001a\u00020=J\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020!0\n2\u0006\u0010@\u001a\u00020=J\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001f0\n2\u0006\u0010C\u001a\u00020=J\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020!0\n2\u0006\u0010C\u001a\u00020=J\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001f0\n2\u0006\u0010C\u001a\u00020F2\u0006\u0010G\u001a\u00020FJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020!0\n2\u0006\u0010C\u001a\u00020F2\u0006\u0010G\u001a\u00020FJ\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001f0\n2\u0006\u0010C\u001a\u00020F2\u0006\u0010G\u001a\u00020FJ\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020!0\n2\u0006\u0010C\u001a\u00020F2\u0006\u0010G\u001a\u00020FR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u000e\u0010(\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInfo;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "MYGESTORVIEWINGRESOS_SETTING", "", "adapterList", "Lrun/budgetbuddy/adapter/myListAdapterInfoGasto;", "binding", "Lrun/budgetbuddy/databinding/MgInfoBinding;", "elemetos", "", "", "getElemetos", "()Ljava/util/List;", "setElemetos", "(Ljava/util/List;)V", "gc", "LCRUD/GastoCRUD;", "getGc", "()LCRUD/GastoCRUD;", "setGc", "(LCRUD/GastoCRUD;)V", "ic", "LCRUD/IngresoCRUD;", "getIc", "()LCRUD/IngresoCRUD;", "setIc", "(LCRUD/IngresoCRUD;)V", "list_view", "Landroid/widget/ListView;", "lista_gastos", "Lmodels/Gasto;", "lista_ingresos", "Lrun/budgetbuddy/model/Ingreso;", "posActualGasto", "", "getPosActualGasto", "()I", "setPosActualGasto", "(I)V", "seleccionado", "check", "", "inicializarAdapter", "onContextItemSelected", "", "item", "Landroid/view/MenuItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "showDatePicker", "verInfoAno", "ano", "Ljava/sql/Date;", "verInfoAnoIngreso", "verInfoDia", "fecha_hoy", "verInfoDiaIngreso", "verInfoMes", "fecha_inicio", "verInfoMesIngreso", "verInfoPeriodo", "Ljava/util/Date;", "fecha_final", "verInfoPeriodoIngreso", "verInfoSemana", "verInfoSemanaIngreso", "app_debug"})
public final class MgInfo extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInfoBinding binding;
    private int seleccionado = 1;
    @org.jetbrains.annotations.NotNull
    private CRUD.GastoCRUD gc;
    @org.jetbrains.annotations.NotNull
    private CRUD.IngresoCRUD ic;
    private android.widget.ListView list_view;
    private run.budgetbuddy.adapter.myListAdapterInfoGasto adapterList;
    private java.util.List<models.Gasto> lista_gastos;
    private java.util.List<run.budgetbuddy.model.Ingreso> lista_ingresos;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.Object> elemetos;
    private int posActualGasto = 0;
    private java.lang.String MYGESTORVIEWINGRESOS_SETTING = "MyGestorView";
    
    public MgInfo() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final CRUD.GastoCRUD getGc() {
        return null;
    }
    
    public final void setGc(@org.jetbrains.annotations.NotNull
    CRUD.GastoCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final CRUD.IngresoCRUD getIc() {
        return null;
    }
    
    public final void setIc(@org.jetbrains.annotations.NotNull
    CRUD.IngresoCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> getElemetos() {
        return null;
    }
    
    public final void setElemetos(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Object> p0) {
    }
    
    public final int getPosActualGasto() {
        return 0;
    }
    
    public final void setPosActualGasto(int p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    public final void check() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<models.Gasto> verInfoDia(@org.jetbrains.annotations.NotNull
    java.sql.Date fecha_hoy) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<models.Gasto> verInfoSemana(@org.jetbrains.annotations.NotNull
    java.util.Date fecha_inicio, @org.jetbrains.annotations.NotNull
    java.util.Date fecha_final) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<models.Gasto> verInfoMes(@org.jetbrains.annotations.NotNull
    java.sql.Date fecha_inicio) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<models.Gasto> verInfoAno(@org.jetbrains.annotations.NotNull
    java.sql.Date ano) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<models.Gasto> verInfoPeriodo(@org.jetbrains.annotations.NotNull
    java.util.Date fecha_inicio, @org.jetbrains.annotations.NotNull
    java.util.Date fecha_final) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoDiaIngreso(@org.jetbrains.annotations.NotNull
    java.sql.Date fecha_hoy) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoSemanaIngreso(@org.jetbrains.annotations.NotNull
    java.util.Date fecha_inicio, @org.jetbrains.annotations.NotNull
    java.util.Date fecha_final) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoMesIngreso(@org.jetbrains.annotations.NotNull
    java.sql.Date fecha_inicio) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoAnoIngreso(@org.jetbrains.annotations.NotNull
    java.sql.Date ano) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoPeriodoIngreso(@org.jetbrains.annotations.NotNull
    java.util.Date fecha_inicio, @org.jetbrains.annotations.NotNull
    java.util.Date fecha_final) {
        return null;
    }
    
    private final void showDatePicker() {
    }
    
    private final void inicializarAdapter(java.util.List<models.Gasto> lista_gastos, java.util.List<run.budgetbuddy.model.Ingreso> lista_ingresos) {
    }
    
    @java.lang.Override
    public void onCreateContextMenu(@org.jetbrains.annotations.NotNull
    android.view.ContextMenu menu, @org.jetbrains.annotations.Nullable
    android.view.View v, @org.jetbrains.annotations.NotNull
    android.view.ContextMenu.ContextMenuInfo menuInfo) {
    }
    
    @java.lang.Override
    public boolean onContextItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
}