package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0007J\u0014\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0015J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J\u0016\u0010%\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0003J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\'\u001a\u00020(J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010*\u001a\u00020(J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010,\u001a\u00020(J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010,\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010,\u001a\u00020.2\u0006\u0010/\u001a\u00020.R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicio;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lrun/budgetbuddy/adapter/myListAdapter_gasto;", "binding", "Lrun/budgetbuddy/databinding/MgInicioGastosBinding;", "gc", "LCRUD/GastoCRUD;", "getGc", "()LCRUD/GastoCRUD;", "setGc", "(LCRUD/GastoCRUD;)V", "gestos", "Landroid/view/GestureDetector;", "listagastosBD", "Ljava/util/HashMap;", "Lmodels/Categoria;", "", "Lkotlin/collections/HashMap;", "seleccionado", "", "IniciarAdapter", "", "check", "getAllDistGastos", "gastos", "", "Lmodels/Gasto;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "showDatePicker", "verGrafico", "verInfoAno", "ano", "Ljava/sql/Date;", "verInfoDia", "fecha_hoy", "verInfoMes", "fecha_inicio", "verInfoPeriodo", "Ljava/util/Date;", "fecha_final", "verInfoSemana", "EscuchaGestos", "app_debug"})
public final class MgInicio extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInicioGastosBinding binding;
    private run.budgetbuddy.adapter.myListAdapter_gasto adapter;
    private java.util.HashMap<models.Categoria, java.lang.Float> listagastosBD;
    @org.jetbrains.annotations.NotNull
    private CRUD.GastoCRUD gc;
    private int seleccionado = 0;
    private android.view.GestureDetector gestos;
    
    public MgInicio() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final CRUD.GastoCRUD getGc() {
        return null;
    }
    
    public final void setGc(@org.jetbrains.annotations.NotNull
    CRUD.GastoCRUD p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void verGrafico(java.util.List<models.Gasto> gastos) {
    }
    
    private final void IniciarAdapter() {
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
    
    public final void getAllDistGastos(@org.jetbrains.annotations.NotNull
    java.util.List<models.Gasto> gastos) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    public final void check() {
    }
    
    @java.lang.Override
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable
    android.view.MotionEvent event) {
        return false;
    }
    
    private final void showDatePicker() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicio$EscuchaGestos;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lrun/budgetbuddy/activities/MG/MgInicio;)V", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "app_debug"})
    public final class EscuchaGestos extends android.view.GestureDetector.SimpleOnGestureListener {
        
        public EscuchaGestos() {
            super();
        }
        
        @java.lang.Override
        public boolean onFling(@org.jetbrains.annotations.NotNull
        android.view.MotionEvent e1, @org.jetbrains.annotations.NotNull
        android.view.MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }
}