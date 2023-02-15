package run.budgetbuddy.activities.MG;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicioIngresos;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lrun/budgetbuddy/databinding/MgInicioIngresosBinding;", "gestos", "Landroid/view/GestureDetector;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "EscuchaGestos", "app_debug"})
public final class MgInicioIngresos extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.MgInicioIngresosBinding binding;
    private android.view.GestureDetector gestos;
    
    public MgInicioIngresos() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable
    android.view.MotionEvent event) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lrun/budgetbuddy/activities/MG/MgInicioIngresos$EscuchaGestos;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lrun/budgetbuddy/activities/MG/MgInicioIngresos;)V", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "app_debug"})
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