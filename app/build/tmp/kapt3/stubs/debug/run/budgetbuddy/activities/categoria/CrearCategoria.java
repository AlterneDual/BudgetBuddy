package run.budgetbuddy.activities.categoria;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015H\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lrun/budgetbuddy/activities/categoria/CrearCategoria;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapterList", "Ladapter/myListAdapter_colores;", "adapterListColores", "binding", "Lrun/budgetbuddy/databinding/CrearCategoriaBinding;", "categoriaCRUD", "LCRUD/CategoriaCRUD;", "getCategoriaCRUD", "()LCRUD/CategoriaCRUD;", "setCategoriaCRUD", "(LCRUD/CategoriaCRUD;)V", "categoriaSeleccionada", "", "colorSeleccionado", "grid_view", "Landroid/widget/GridView;", "grid_view_colores", "listaColores", "", "listaIconos", "lista_colores_hex", "", "txt_nombre", "Landroid/widget/EditText;", "viewActual", "Landroid/view/View;", "viewcol", "colores", "crearCategoria", "", "crearColores", "crearIconos", "inicializarAdapter", "inicializarAdapterColores", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class CrearCategoria extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.CrearCategoriaBinding binding;
    private adapter.myListAdapter_colores adapterList;
    private adapter.myListAdapter_colores adapterListColores;
    private android.widget.GridView grid_view;
    private android.widget.EditText txt_nombre;
    private android.widget.GridView grid_view_colores;
    private java.util.List<java.lang.Integer> listaIconos;
    private java.util.List<java.lang.Integer> listaColores;
    private java.util.List<java.lang.String> lista_colores_hex;
    private int categoriaSeleccionada = -1;
    private int colorSeleccionado = -1;
    private android.view.View viewActual;
    private android.view.View viewcol;
    @org.jetbrains.annotations.NotNull
    private CRUD.CategoriaCRUD categoriaCRUD;
    
    public CrearCategoria() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final CRUD.CategoriaCRUD getCategoriaCRUD() {
        return null;
    }
    
    public final void setCategoriaCRUD(@org.jetbrains.annotations.NotNull
    CRUD.CategoriaCRUD p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void crearCategoria() {
    }
    
    private final void inicializarAdapter() {
    }
    
    private final void inicializarAdapterColores() {
    }
    
    private final java.util.List<java.lang.Integer> crearIconos() {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> crearColores() {
        return null;
    }
    
    private final java.util.List<java.lang.String> colores() {
        return null;
    }
}