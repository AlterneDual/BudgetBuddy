package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0003J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0015J(\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0003J\b\u0010%\u001a\u00020\u001bH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgAnadirGasto;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lrun/budgetbuddy/databinding/MgAnadirGastoBinding;", "selectedDate", "Landroid/icu/util/Calendar;", "selectedDay", "", "selectedDayManual", "selectedMonth", "selectedMonthManual", "selectedYear", "selectedYearManual", "today", "todayDay", "todayMonth", "todayYear", "tomorrow", "tomorrowDay", "tomorrowMonth", "tomorrowYear", "yesterday", "yesterdayDay", "yesterdayMonth", "yesterdayYear", "actualizarYestardayTomorrow", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDatePickerDialog", "tvFechaSeleccionada", "Landroid/widget/TextView;", "fecha1", "fecha2", "fecha3", "valoresAyerHoyPredeterminados", "app_debug"})
public final class MgAnadirGasto extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgAnadirGastoBinding binding;
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private android.icu.util.Calendar selectedDate;
    private int selectedYear = 0;
    private int selectedMonth = 0;
    private int selectedDay = 0;
    private int selectedDayManual = 0;
    private int selectedMonthManual = 0;
    private int selectedYearManual = 0;
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
    
    public MgAnadirGasto() {
        super();
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void valoresAyerHoyPredeterminados() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void showDatePickerDialog(android.widget.TextView tvFechaSeleccionada, android.widget.TextView fecha1, android.widget.TextView fecha2, android.widget.TextView fecha3) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void actualizarYestardayTomorrow() {
    }
}