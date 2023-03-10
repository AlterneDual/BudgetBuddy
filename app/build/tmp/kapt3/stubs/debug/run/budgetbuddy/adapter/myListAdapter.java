package run.budgetbuddy.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lrun/budgetbuddy/adapter/myListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "layout", "", "listaAjustes", "", "Lmodels/ItemGenerico;", "(Landroid/content/Context;ILjava/util/List;)V", "getCount", "getItem", "position", "getItemId", "", "id", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "app_debug"})
public final class myListAdapter extends android.widget.BaseAdapter {
    private final android.content.Context context = null;
    private final int layout = 0;
    private final java.util.List<models.ItemGenerico> listaAjustes = null;
    
    public myListAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, int layout, @org.jetbrains.annotations.NotNull
    java.util.List<models.ItemGenerico> listaAjustes) {
        super();
    }
    
    @java.lang.Override
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public models.ItemGenerico getItem(int position) {
        return null;
    }
    
    @java.lang.Override
    public long getItemId(int id) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable
    android.view.View convertView, @org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lrun/budgetbuddy/adapter/myListAdapter$ViewHolder;", "", "nombre1", "Landroid/widget/TextView;", "nombre2", "icono", "Landroid/widget/ImageView;", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;)V", "getIcono", "()Landroid/widget/ImageView;", "setIcono", "(Landroid/widget/ImageView;)V", "getNombre1", "()Landroid/widget/TextView;", "setNombre1", "(Landroid/widget/TextView;)V", "getNombre2", "setNombre2", "app_debug"})
    public static final class ViewHolder {
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView nombre1;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView nombre2;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView icono;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.widget.TextView nombre1, @org.jetbrains.annotations.NotNull
        android.widget.TextView nombre2, @org.jetbrains.annotations.NotNull
        android.widget.ImageView icono) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getNombre1() {
            return null;
        }
        
        public final void setNombre1(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getNombre2() {
            return null;
        }
        
        public final void setNombre2(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIcono() {
            return null;
        }
        
        public final void setIcono(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
    }
}