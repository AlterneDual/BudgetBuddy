package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00105\u001a\u000206H\u0003J\u0006\u00107\u001a\u000206J\b\u00108\u001a\u000206H\u0002J\u001e\u00109\u001a\u0012\u0012\u0004\u0012\u00020!0:j\b\u0012\u0004\u0012\u00020!`;2\u0006\u0010<\u001a\u00020*J\u0012\u0010=\u001a\u0002062\b\u0010>\u001a\u0004\u0018\u00010?H\u0015J(\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020BH\u0003J\u0010\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020\'H\u0003J\b\u0010H\u001a\u000206H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020\'8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\'8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\'8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\'8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgEditarEliminarGasto;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapterList", "Ladapter/myListAdapter_categorias;", "binding", "Lrun/budgetbuddy/databinding/MgEditarGastosBinding;", "categoriaAtributo", "Lmodels/Categoria;", "getCategoriaAtributo", "()Lmodels/Categoria;", "setCategoriaAtributo", "(Lmodels/Categoria;)V", "categoriaCRUD", "LCRUD/CategoriaCRUD;", "getCategoriaCRUD", "()LCRUD/CategoriaCRUD;", "setCategoriaCRUD", "(LCRUD/CategoriaCRUD;)V", "fechaGasto", "Ljava/util/Date;", "kotlin.jvm.PlatformType", "getFechaGasto", "()Ljava/util/Date;", "setFechaGasto", "(Ljava/util/Date;)V", "gastoCRUD", "LCRUD/GastoCRUD;", "grid_view", "Landroid/widget/GridView;", "listaCategorias", "", "nombreMes", "", "getNombreMes", "()Ljava/lang/String;", "setNombreMes", "(Ljava/lang/String;)V", "selectedDate", "Landroid/icu/util/Calendar;", "today", "todayDay", "", "todayMonth", "todayYear", "tomorrow", "tomorrowDay", "tomorrowMonth", "tomorrowYear", "yesterday", "yesterdayDay", "yesterdayMonth", "yesterdayYear", "actualizarYesterdayTomorrow", "", "configurarSeleccion", "inicializarAdapter", "nombreMeses", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mes", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDatePickerDialog", "tvFechaSeleccionada", "Landroid/widget/TextView;", "fecha1", "fecha2", "fecha3", "updateFecha", "new_fecha", "valoresAyerHoyPredeterminados", "app_debug"})
public final class MgEditarEliminarGasto extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgEditarGastosBinding binding;
    private CRUD.GastoCRUD gastoCRUD;
    private java.util.List<models.Categoria> listaCategorias;
    @org.jetbrains.annotations.Nullable()
    private models.Categoria categoriaAtributo;
    private android.widget.GridView grid_view;
    private adapter.myListAdapter_categorias adapterList;
    @org.jetbrains.annotations.NotNull()
    private CRUD.CategoriaCRUD categoriaCRUD;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nombreMes;
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private android.icu.util.Calendar selectedDate;
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private android.icu.util.Calendar today;
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private android.icu.util.Calendar yesterday;
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private android.icu.util.Calendar tomorrow;
    private int todayDay = 0;
    private int todayMonth = 0;
    private int todayYear = 0;
    private int yesterdayDay = 0;
    private int yesterdayYear = 0;
    private int yesterdayMonth = 0;
    private int tomorrowDay = 0;
    private int tomorrowMonth = 0;
    private int tomorrowYear = 0;
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private java.util.Date fechaGasto;
    
    public MgEditarEliminarGasto() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final models.Categoria getCategoriaAtributo() {
        return null;
    }
    
    public final void setCategoriaAtributo(@org.jetbrains.annotations.Nullable()
    models.Categoria p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final CRUD.CategoriaCRUD getCategoriaCRUD() {
        return null;
    }
    
    public final void setCategoriaCRUD(@org.jetbrains.annotations.NotNull()
    CRUD.CategoriaCRUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNombreMes() {
        return null;
    }
    
    public final void setNombreMes(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final java.util.Date getFechaGasto() {
        return null;
    }
    
    public final void setFechaGasto(java.util.Date p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void updateFecha(android.icu.util.Calendar new_fecha) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void showDatePickerDialog(android.widget.TextView tvFechaSeleccionada, android.widget.TextView fecha1, android.widget.TextView fecha2, android.widget.TextView fecha3) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void actualizarYesterdayTomorrow() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> nombreMeses(int mes) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void valoresAyerHoyPredeterminados() {
    }
    
    private final void inicializarAdapter() {
    }
    
    public final void configurarSeleccion() {
    }
}