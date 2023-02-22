package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001GB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0007J\u0014\u0010,\u001a\u00020*2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\b\u0010.\u001a\u00020*H\u0016J\u0012\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u0002032\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020*H\u0002J\u0016\u0010:\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0003J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010=\u001a\u00020>J\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010@\u001a\u00020>J\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010B\u001a\u00020>J\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010B\u001a\u00020D2\u0006\u0010E\u001a\u00020DJ\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010B\u001a\u00020D2\u0006\u0010E\u001a\u00020DR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u000e\u0010(\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicioIngresos;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lrun/budgetbuddy/adapter/myListAdapter_ingreso;", "binding", "Lrun/budgetbuddy/databinding/MgInicioIngresosBinding;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "getDrawerLayout", "()Landroidx/drawerlayout/widget/DrawerLayout;", "setDrawerLayout", "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "drawerToggle", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "getDrawerToggle", "()Landroidx/appcompat/app/ActionBarDrawerToggle;", "setDrawerToggle", "(Landroidx/appcompat/app/ActionBarDrawerToggle;)V", "gestos", "Landroid/view/GestureDetector;", "ic", "LCRUD/IngresoCRUD;", "getIc", "()LCRUD/IngresoCRUD;", "setIc", "(LCRUD/IngresoCRUD;)V", "listaIngresosBD", "", "Lrun/budgetbuddy/model/Ingreso;", "lista_colores", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "navigationView", "Lcom/google/android/material/navigation/NavigationView;", "getNavigationView", "()Lcom/google/android/material/navigation/NavigationView;", "setNavigationView", "(Lcom/google/android/material/navigation/NavigationView;)V", "seleccionado", "IniciarAdapter", "", "check", "inicializarIngresos", "gastos", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "showDatePicker", "verGrafico", "ingresos", "verInfoAno", "ano", "Ljava/sql/Date;", "verInfoDia", "fecha_hoy", "verInfoMes", "fecha_inicio", "verInfoPeriodo", "Ljava/util/Date;", "fecha_final", "verInfoSemana", "EscuchaGestos", "app_debug"})
public final class MgInicioIngresos extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInicioIngresosBinding binding;
    private run.budgetbuddy.adapter.myListAdapter_ingreso adapter;
    private java.util.List<run.budgetbuddy.model.Ingreso> listaIngresosBD;
    @org.jetbrains.annotations.NotNull()
    private CRUD.IngresoCRUD ic;
    private int seleccionado = 0;
    private android.view.GestureDetector gestos;
    private java.util.ArrayList<java.lang.Integer> lista_colores;
    public androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    public com.google.android.material.navigation.NavigationView navigationView;
    public androidx.appcompat.app.ActionBarDrawerToggle drawerToggle;
    
    public MgInicioIngresos() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final CRUD.IngresoCRUD getIc() {
        return null;
    }
    
    public final void setIc(@org.jetbrains.annotations.NotNull()
    CRUD.IngresoCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.drawerlayout.widget.DrawerLayout getDrawerLayout() {
        return null;
    }
    
    public final void setDrawerLayout(@org.jetbrains.annotations.NotNull()
    androidx.drawerlayout.widget.DrawerLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.material.navigation.NavigationView getNavigationView() {
        return null;
    }
    
    public final void setNavigationView(@org.jetbrains.annotations.NotNull()
    com.google.android.material.navigation.NavigationView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.app.ActionBarDrawerToggle getDrawerToggle() {
        return null;
    }
    
    public final void setDrawerToggle(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.ActionBarDrawerToggle p0) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void verGrafico(java.util.List<run.budgetbuddy.model.Ingreso> ingresos) {
    }
    
    private final void IniciarAdapter() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoDia(@org.jetbrains.annotations.NotNull()
    java.sql.Date fecha_hoy) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoSemana(@org.jetbrains.annotations.NotNull()
    java.util.Date fecha_inicio, @org.jetbrains.annotations.NotNull()
    java.util.Date fecha_final) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoMes(@org.jetbrains.annotations.NotNull()
    java.sql.Date fecha_inicio) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoAno(@org.jetbrains.annotations.NotNull()
    java.sql.Date ano) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<run.budgetbuddy.model.Ingreso> verInfoPeriodo(@org.jetbrains.annotations.NotNull()
    java.util.Date fecha_inicio, @org.jetbrains.annotations.NotNull()
    java.util.Date fecha_final) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    public final void check() {
    }
    
    private final void showDatePicker() {
    }
    
    public final void inicializarIngresos(@org.jetbrains.annotations.NotNull()
    java.util.List<run.budgetbuddy.model.Ingreso> gastos) {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicioIngresos$EscuchaGestos;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lrun/budgetbuddy/activities/MG/MgInicioIngresos;)V", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "app_debug"})
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