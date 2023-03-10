package run.budgetbuddy.activities.categoria;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010\'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020(2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J&\u00101\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u00109\u001a\u00020+H\u0002J\b\u0010:\u001a\u00020(H\u0002J\b\u0010;\u001a\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lrun/budgetbuddy/activities/categoria/Categorias;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapterList", "Ladapter/myListAdapter_categorias;", "binding", "Lrun/budgetbuddy/databinding/CategoriasBinding;", "categoriaCRUD", "LCRUD/CategoriaCRUD;", "getCategoriaCRUD", "()LCRUD/CategoriaCRUD;", "setCategoriaCRUD", "(LCRUD/CategoriaCRUD;)V", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "getDrawerLayout", "()Landroidx/drawerlayout/widget/DrawerLayout;", "setDrawerLayout", "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "drawerToggle", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "getDrawerToggle", "()Landroidx/appcompat/app/ActionBarDrawerToggle;", "setDrawerToggle", "(Landroidx/appcompat/app/ActionBarDrawerToggle;)V", "grid_view", "Landroid/widget/GridView;", "listaCategorias", "", "Lmodels/Categoria;", "navigationView", "Lcom/google/android/material/navigation/NavigationView;", "getNavigationView", "()Lcom/google/android/material/navigation/NavigationView;", "setNavigationView", "(Lcom/google/android/material/navigation/NavigationView;)V", "posicion", "", "crearCategorias", "inicializarAdapter", "", "onBackPressed", "onContextItemSelected", "", "item", "Landroid/view/MenuItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onOptionsItemSelected", "recargarBDD", "rellenar_bd_categorias", "vaciar_bd_categorias", "app_debug"})
public final class Categorias extends androidx.appcompat.app.AppCompatActivity {
    private run.budgetbuddy.databinding.CategoriasBinding binding;
    private adapter.myListAdapter_categorias adapterList;
    private android.widget.GridView grid_view;
    private java.util.List<models.Categoria> listaCategorias;
    @org.jetbrains.annotations.NotNull()
    private CRUD.CategoriaCRUD categoriaCRUD;
    private int posicion = 0;
    public androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    public com.google.android.material.navigation.NavigationView navigationView;
    public androidx.appcompat.app.ActionBarDrawerToggle drawerToggle;
    
    public Categorias() {
        super();
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
    
    private final void inicializarAdapter() {
    }
    
    private final java.util.List<models.Categoria> crearCategorias() {
        return null;
    }
    
    private final void vaciar_bd_categorias() {
    }
    
    private final void rellenar_bd_categorias() {
    }
    
    @java.lang.Override()
    public void onCreateContextMenu(@org.jetbrains.annotations.Nullable()
    android.view.ContextMenu menu, @org.jetbrains.annotations.Nullable()
    android.view.View v, @org.jetbrains.annotations.Nullable()
    android.view.ContextMenu.ContextMenuInfo menuInfo) {
    }
    
    @java.lang.Override()
    public boolean onContextItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final boolean recargarBDD() {
        return false;
    }
}