package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0015J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInfo;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "MYGESTORVIEWINGRESOS_SETTING", "", "binding", "Lrun/budgetbuddy/databinding/MgInfoBinding;", "gc", "LCRUD/GastoCRUD;", "getGc", "()LCRUD/GastoCRUD;", "setGc", "(LCRUD/GastoCRUD;)V", "seleccionado", "", "check", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDatePicker", "verInfoAno", "fecha_hoy", "Ljava/sql/Date;", "verInfoDia", "verInfoMes", "verInfoPeriodo", "verInfoSemana", "app_debug"})
public final class MgInfo extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInfoBinding binding;
    private int seleccionado = 1;
    @org.jetbrains.annotations.NotNull
    private CRUD.GastoCRUD gc;
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
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    public final void check() {
    }
    
    public final void verInfoDia(@org.jetbrains.annotations.NotNull
    java.sql.Date fecha_hoy) {
    }
    
    public final void verInfoSemana(@org.jetbrains.annotations.NotNull
    java.sql.Date fecha_hoy) {
    }
    
    public final void verInfoMes(@org.jetbrains.annotations.NotNull
    java.sql.Date fecha_hoy) {
    }
    
    public final void verInfoAno(@org.jetbrains.annotations.NotNull
    java.sql.Date fecha_hoy) {
    }
    
    public final void verInfoPeriodo(@org.jetbrains.annotations.NotNull
    java.sql.Date fecha_hoy) {
    }
    
    private final void showDatePicker() {
    }
}