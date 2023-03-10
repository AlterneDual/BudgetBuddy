// Generated by view binder compiler. Do not edit!
package run.budgetbuddy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import run.budgetbuddy.R;

public final class CrearCategoriaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final GridView GVCategorias3;

  @NonNull
  public final GridView GVColores;

  @NonNull
  public final Button btnAnadir2;

  @NonNull
  public final ImageView btnAtras;

  @NonNull
  public final EditText etNombreCategoria;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final Toolbar toolbar;

  private CrearCategoriaBinding(@NonNull ConstraintLayout rootView, @NonNull GridView GVCategorias3,
      @NonNull GridView GVColores, @NonNull Button btnAnadir2, @NonNull ImageView btnAtras,
      @NonNull EditText etNombreCategoria, @NonNull LinearLayout linearLayout,
      @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.GVCategorias3 = GVCategorias3;
    this.GVColores = GVColores;
    this.btnAnadir2 = btnAnadir2;
    this.btnAtras = btnAtras;
    this.etNombreCategoria = etNombreCategoria;
    this.linearLayout = linearLayout;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CrearCategoriaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CrearCategoriaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.crear_categoria, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CrearCategoriaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.GVCategorias3;
      GridView GVCategorias3 = ViewBindings.findChildViewById(rootView, id);
      if (GVCategorias3 == null) {
        break missingId;
      }

      id = R.id.GVColores;
      GridView GVColores = ViewBindings.findChildViewById(rootView, id);
      if (GVColores == null) {
        break missingId;
      }

      id = R.id.btnAnadir2;
      Button btnAnadir2 = ViewBindings.findChildViewById(rootView, id);
      if (btnAnadir2 == null) {
        break missingId;
      }

      id = R.id.btnAtras;
      ImageView btnAtras = ViewBindings.findChildViewById(rootView, id);
      if (btnAtras == null) {
        break missingId;
      }

      id = R.id.etNombreCategoria;
      EditText etNombreCategoria = ViewBindings.findChildViewById(rootView, id);
      if (etNombreCategoria == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new CrearCategoriaBinding((ConstraintLayout) rootView, GVCategorias3, GVColores,
          btnAnadir2, btnAtras, etNombreCategoria, linearLayout, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
