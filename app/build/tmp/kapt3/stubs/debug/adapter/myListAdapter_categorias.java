package adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Ladapter/myListAdapter_categorias;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "layout", "", "listaOpciones", "", "Lmodels/Categoria;", "(Landroid/content/Context;ILjava/util/List;)V", "listaColores", "selectedItem", "getSelectedItem", "()I", "setSelectedItem", "(I)V", "getCount", "getItem", "position", "getItemId", "", "id", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "app_debug"})
public final class myListAdapter_categorias extends android.widget.BaseAdapter {
    private final android.content.Context context = null;
    private final int layout = 0;
    private final java.util.List<models.Categoria> listaOpciones = null;
    private java.util.List<java.lang.Integer> listaColores;
    private int selectedItem = -1;
    
    public myListAdapter_categorias(@org.jetbrains.annotations.NotNull
    android.content.Context context, int layout, @org.jetbrains.annotations.NotNull
    java.util.List<models.Categoria> listaOpciones) {
        super();
    }
    
    @java.lang.Override
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public models.Categoria getItem(int position) {
        return null;
    }
    
    @java.lang.Override
    public long getItemId(int id) {
        return 0L;
    }
    
    public final int getSelectedItem() {
        return 0;
    }
    
    public final void setSelectedItem(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable
    android.view.View convertView, @org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Ladapter/myListAdapter_categorias$ViewHolder;", "", "icono", "Landroid/widget/ImageView;", "color", "nombreCategoria", "Landroid/widget/TextView;", "(Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/TextView;)V", "getColor", "()Landroid/widget/ImageView;", "setColor", "(Landroid/widget/ImageView;)V", "getIcono", "setIcono", "getNombreCategoria", "()Landroid/widget/TextView;", "setNombreCategoria", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class ViewHolder {
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView icono;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView color;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView nombreCategoria;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.widget.ImageView icono, @org.jetbrains.annotations.NotNull
        android.widget.ImageView color, @org.jetbrains.annotations.NotNull
        android.widget.TextView nombreCategoria) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIcono() {
            return null;
        }
        
        public final void setIcono(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getColor() {
            return null;
        }
        
        public final void setColor(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getNombreCategoria() {
            return null;
        }
        
        public final void setNombreCategoria(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
    }
}