package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0007J\u0014\u0010\u001a\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\u0016\u0010$\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0003J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\'\u001a\u00020(J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010*\u001a\u00020(J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010,\u001a\u00020(J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010,\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010,\u001a\u00020.2\u0006\u0010/\u001a\u00020.R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicioIngresos;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lrun/budgetbuddy/adapter/myListAdapter_ingreso;", "binding", "Lrun/budgetbuddy/databinding/MgInicioIngresosBinding;", "gestos", "Landroid/view/GestureDetector;", "ic", "LCRUD/IngresoCRUD;", "getIc", "()LCRUD/IngresoCRUD;", "setIc", "(LCRUD/IngresoCRUD;)V", "listaIngresosBD", "", "Lrun/budgetbuddy/model/Ingreso;", "lista_colores", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "seleccionado", "IniciarAdapter", "", "check", "inicializarIngresos", "gastos", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "showDatePicker", "verGrafico", "ingresos", "verInfoAno", "ano", "Ljava/sql/Date;", "verInfoDia", "fecha_hoy", "verInfoMes", "fecha_inicio", "verInfoPeriodo", "Ljava/util/Date;", "fecha_final", "verInfoSemana", "EscuchaGestos", "app_debug"})
public final class MgInicioIngresos extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInicioIngresosBinding binding;
    private run.budgetbuddy.adapter.myListAdapter_ingreso adapter;
    private java.util.List<run.budgetbuddy.model.Ingreso> listaIngresosBD;
    @org.jetbrains.annotations.NotNull()
    private CRUD.IngresoCRUD ic;
    private int seleccionado = 0;
    private android.view.GestureDetector gestos;
    private java.util.ArrayList<java.lang.Integer> lista_colores;
    
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