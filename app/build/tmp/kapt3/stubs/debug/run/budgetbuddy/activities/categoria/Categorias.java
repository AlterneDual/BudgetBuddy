package run.budgetbuddy.activities.categoria;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J&\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010\'\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lrun/budgetbuddy/activities/categoria/Categorias;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapterList", "Ladapter/myListAdapter_categorias;", "binding", "Lrun/budgetbuddy/databinding/CategoriasBinding;", "categoriaCRUD", "LCRUD/CategoriaCRUD;", "getCategoriaCRUD", "()LCRUD/CategoriaCRUD;", "setCategoriaCRUD", "(LCRUD/CategoriaCRUD;)V", "grid_view", "Landroid/widget/GridView;", "listaCategorias", "", "Lmodels/Categoria;", "posicion", "", "crearCategorias", "inicializarAdapter", "", "onContextItemSelected", "", "item", "Landroid/view/MenuItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "recargarBDD", "rellenar_bd_categorias", "vaciar_bd_categorias", "app_debug"})
public final class Categorias extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.CategoriasBinding binding;
    private adapter.myListAdapter_categorias adapterList;
    private android.widget.GridView grid_view;
    private java.util.List<models.Categoria> listaCategorias;
    @org.jetbrains.annotations.NotNull
    private CRUD.CategoriaCRUD categoriaCRUD;
    private int posicion = 0;
    
    public Categorias() {
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
    
    private final void inicializarAdapter() {
    }
    
    private final java.util.List<models.Categoria> crearCategorias() {
        return null;
    }
    
    private final void vaciar_bd_categorias() {
    }
    
    private final void rellenar_bd_categorias() {
    }
    
    @java.lang.Override
    public void onCreateContextMenu(@org.jetbrains.annotations.Nullable
    android.view.ContextMenu menu, @org.jetbrains.annotations.Nullable
    android.view.View v, @org.jetbrains.annotations.Nullable
    android.view.ContextMenu.ContextMenuInfo menuInfo) {
    }
    
    @java.lang.Override
    public boolean onContextItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final boolean recargarBDD() {
        return false;
    }
}