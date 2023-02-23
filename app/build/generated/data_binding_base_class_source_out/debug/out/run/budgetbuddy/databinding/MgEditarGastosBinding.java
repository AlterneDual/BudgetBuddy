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
import android.widget.TextView;
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

public final class MgEditarGastosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView btnAtras2;

  @NonNull
  public final ImageView btnCalendario;

  @NonNull
  public final Button btnEditar;

  @NonNull
  public final Button btnEliminar1;

  @NonNull
  public final Button btnFecha1;

  @NonNull
  public final Button btnFecha2;

  @NonNull
  public final Button btnFecha3;

  @NonNull
  public final EditText etCantidad;

  @NonNull
  public final EditText etNombreGasto;

  @NonNull
  public final GridView gvCategorias;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final LinearLayout linearLayout4;

  @NonNull
  public final Toolbar toolbarA;

  @NonNull
  public final TextView tvDivisa1;

  @NonNull
  public final TextView tvFechaActual;

  private MgEditarGastosBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView btnAtras2,
      @NonNull ImageView btnCalendario, @NonNull Button btnEditar, @NonNull Button btnEliminar1,
      @NonNull Button btnFecha1, @NonNull Button btnFecha2, @NonNull Button btnFecha3,
      @NonNull EditText etCantidad, @NonNull EditText etNombreGasto, @NonNull GridView gvCategorias,
      @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3,
      @NonNull LinearLayout linearLayout4, @NonNull Toolbar toolbarA, @NonNull TextView tvDivisa1,
      @NonNull TextView tvFechaActual) {
    this.rootView = rootView;
    this.btnAtras2 = btnAtras2;
    this.btnCalendario = btnCalendario;
    this.btnEditar = btnEditar;
    this.btnEliminar1 = btnEliminar1;
    this.btnFecha1 = btnFecha1;
    this.btnFecha2 = btnFecha2;
    this.btnFecha3 = btnFecha3;
    this.etCantidad = etCantidad;
    this.etNombreGasto = etNombreGasto;
    this.gvCategorias = gvCategorias;
    this.linearLayout2 = linearLayout2;
    this.linearLayout3 = linearLayout3;
    this.linearLayout4 = linearLayout4;
    this.toolbarA = toolbarA;
    this.tvDivisa1 = tvDivisa1;
    this.tvFechaActual = tvFechaActual;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MgEditarGastosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MgEditarGastosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.mg_editar_gastos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MgEditarGastosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAtras2;
      ImageView btnAtras2 = ViewBindings.findChildViewById(rootView, id);
      if (btnAtras2 == null) {
        break missingId;
      }

      id = R.id.btnCalendario;
      ImageView btnCalendario = ViewBindings.findChildViewById(rootView, id);
      if (btnCalendario == null) {
        break missingId;
      }

      id = R.id.btnEditar;
      Button btnEditar = ViewBindings.findChildViewById(rootView, id);
      if (btnEditar == null) {
        break missingId;
      }

      id = R.id.btnEliminar1;
      Button btnEliminar1 = ViewBindings.findChildViewById(rootView, id);
      if (btnEliminar1 == null) {
        break missingId;
      }

      id = R.id.btnFecha1;
      Button btnFecha1 = ViewBindings.findChildViewById(rootView, id);
      if (btnFecha1 == null) {
        break missingId;
      }

      id = R.id.btnFecha2;
      Button btnFecha2 = ViewBindings.findChildViewById(rootView, id);
      if (btnFecha2 == null) {
        break missingId;
      }

      id = R.id.btnFecha3;
      Button btnFecha3 = ViewBindings.findChildViewById(rootView, id);
      if (btnFecha3 == null) {
        break missingId;
      }

      id = R.id.etCantidad;
      EditText etCantidad = ViewBindings.findChildViewById(rootView, id);
      if (etCantidad == null) {
        break missingId;
      }

      id = R.id.etNombreGasto;
      EditText etNombreGasto = ViewBindings.findChildViewById(rootView, id);
      if (etNombreGasto == null) {
        break missingId;
      }

      id = R.id.gvCategorias;
      GridView gvCategorias = ViewBindings.findChildViewById(rootView, id);
      if (gvCategorias == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.linearLayout4;
      LinearLayout linearLayout4 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout4 == null) {
        break missingId;
      }

      id = R.id.toolbarA;
      Toolbar toolbarA = ViewBindings.findChildViewById(rootView, id);
      if (toolbarA == null) {
        break missingId;
      }

      id = R.id.tvDivisa1;
      TextView tvDivisa1 = ViewBindings.findChildViewById(rootView, id);
      if (tvDivisa1 == null) {
        break missingId;
      }

      id = R.id.tvFechaActual;
      TextView tvFechaActual = ViewBindings.findChildViewById(rootView, id);
      if (tvFechaActual == null) {
        break missingId;
      }

      return new MgEditarGastosBinding((ConstraintLayout) rootView, btnAtras2, btnCalendario,
          btnEditar, btnEliminar1, btnFecha1, btnFecha2, btnFecha3, etCantidad, etNombreGasto,
          gvCategorias, linearLayout2, linearLayout3, linearLayout4, toolbarA, tvDivisa1,
          tvFechaActual);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
