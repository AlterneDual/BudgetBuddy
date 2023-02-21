package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001@B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0007J\u000e\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0014\u0010(\u001a\u00020%2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001cJ\u0012\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-H\u0015J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020%H\u0002J\b\u00103\u001a\u00020%H\u0002J\u0016\u00104\u001a\u00020%2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001cH\u0003J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020*0\u001c2\u0006\u00106\u001a\u000207J\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020*0\u001c2\u0006\u00109\u001a\u000207J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020*0\u001c2\u0006\u0010;\u001a\u000207J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020*0\u001c2\u0006\u0010;\u001a\u00020=2\u0006\u0010>\u001a\u00020=J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020*0\u001c2\u0006\u0010;\u001a\u00020=2\u0006\u0010>\u001a\u00020=R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 `!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicio;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lrun/budgetbuddy/adapter/myListAdapter_gasto;", "binding", "Lrun/budgetbuddy/databinding/MgInicioGastosBinding;", "categoriaCRUD", "LCRUD/CategoriaCRUD;", "getCategoriaCRUD", "()LCRUD/CategoriaCRUD;", "setCategoriaCRUD", "(LCRUD/CategoriaCRUD;)V", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "getDrawerLayout", "()Landroidx/drawerlayout/widget/DrawerLayout;", "setDrawerLayout", "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "gc", "LCRUD/GastoCRUD;", "getGc", "()LCRUD/GastoCRUD;", "setGc", "(LCRUD/GastoCRUD;)V", "gestos", "Landroid/view/GestureDetector;", "listaCategorias", "", "Lmodels/Categoria;", "listagastosBD", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "seleccionado", "", "IniciarAdapter", "", "check", "crearCategorias", "getAllDistGastos", "gastos", "Lmodels/Gasto;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "rellenar_bd_categorias", "showDatePicker", "verGrafico", "verInfoAno", "ano", "Ljava/sql/Date;", "verInfoDia", "fecha_hoy", "verInfoMes", "fecha_inicio", "verInfoPeriodo", "Ljava/util/Date;", "fecha_final", "verInfoSemana", "EscuchaGestos", "app_debug"})
public final class MgInicio extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInicioGastosBinding binding;
    private run.budgetbuddy.adapter.myListAdapter_gasto adapter;
    private java.util.HashMap<models.Categoria, java.lang.Float> listagastosBD;
    @org.jetbrains.annotations.NotNull()
    private CRUD.GastoCRUD gc;
    private int seleccionado = 0;
    private android.view.GestureDetector gestos;
    private java.util.List<models.Categoria> listaCategorias;
    @org.jetbrains.annotations.NotNull()
    private CRUD.CategoriaCRUD categoriaCRUD;
    public androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    
    public MgInicio() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final CRUD.GastoCRUD getGc() {
        return null;
    }
    
    public final void setGc(@org.jetbrains.annotations.NotNull()
    CRUD.GastoCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final CRUD.CategoriaCRUD getCategoriaCRUD() {
        return null;
    }
    
    public final void setCategoriaCRUD(@org.jetbrains.annotations.NotNull()
    CRUD.CategoriaCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.drawerlayout.widget.DrawerLayout getDrawerLayout() {
        return null;
    }
    
    public final void setDrawerLayout(@org.jetbrains.annotations.NotNull()
    androidx.drawerlayout.widget.DrawerLayout p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @android.annotation.SuppressLint(value = {"ResourceType"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void verGrafico(java.util.List<models.Gasto> gastos) {
    }
    
    private final void IniciarAdapter() {
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
    
    public final void getAllDistGastos(@org.jetbrains.annotations.NotNull()
    java.util.List<models.Gasto> gastos) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    public final void check() {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event) {
        return false;
    }
    
    private final void showDatePicker() {
    }
    
    private final java.util.List<models.Categoria> crearCategorias() {
        return null;
    }
    
    private final void rellenar_bd_categorias() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicio$EscuchaGestos;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lrun/budgetbuddy/activities/MG/MgInicio;)V", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "app_debug"})
    public final class EscuchaGestos extends android.view.GestureDetector.SimpleOnGestureListener {
        
        public EscuchaGestos() {
            super();
        }
        
        @java.lang.Override()
        public boolean onFling(@org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e1, @org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }
}