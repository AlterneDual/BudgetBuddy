// Generated by view binder compiler. Do not edit!
package run.budgetbuddy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import run.budgetbuddy.R;

public final class MgAnadirGastoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnAnadir;

  @NonNull
  public final ImageView btnAtras3;

  @NonNull
  public final ImageView btnCalendario;

  @NonNull
  public final Button btnFecha1;

  @NonNull
  public final Button btnFecha2;

  @NonNull
  public final Button btnFecha3;

  @NonNull
  public final EditText etCantidad;

  @NonNull
  public final EditText etComentario;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final RecyclerView rvCategorias;

  @NonNull
  public final Toolbar toolbarA;

  @NonNull
  public final TextView tvCategorias;

  @NonNull
  public final TextView tvDivisa;

  @NonNull
  public final TextView tvFechaSeleccionada;

  @NonNull
  public final TextView tvIngresos;

  private MgAnadirGastoBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnAnadir,
      @NonNull ImageView btnAtras3, @NonNull ImageView btnCalendario, @NonNull Button btnFecha1,
      @NonNull Button btnFecha2, @NonNull Button btnFecha3, @NonNull EditText etCantidad,
      @NonNull EditText etComentario, @NonNull LinearLayout linearLayout2,
      @NonNull LinearLayout linearLayout3, @NonNull RecyclerView rvCategorias,
      @NonNull Toolbar toolbarA, @NonNull TextView tvCategorias, @NonNull TextView tvDivisa,
      @NonNull TextView tvFechaSeleccionada, @NonNull TextView tvIngresos) {
    this.rootView = rootView;
    this.btnAnadir = btnAnadir;
    this.btnAtras3 = btnAtras3;
    this.btnCalendario = btnCalendario;
    this.btnFecha1 = btnFecha1;
    this.btnFecha2 = btnFecha2;
    this.btnFecha3 = btnFecha3;
    this.etCantidad = etCantidad;
    this.etComentario = etComentario;
    this.linearLayout2 = linearLayout2;
    this.linearLayout3 = linearLayout3;
    this.rvCategorias = rvCategorias;
    this.toolbarA = toolbarA;
    this.tvCategorias = tvCategorias;
    this.tvDivisa = tvDivisa;
    this.tvFechaSeleccionada = tvFechaSeleccionada;
    this.tvIngresos = tvIngresos;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MgAnadirGastoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MgAnadirGastoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.mg_anadir_gasto, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MgAnadirGastoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAnadir;
      Button btnAnadir = ViewBindings.findChildViewById(rootView, id);
      if (btnAnadir == null) {
        break missingId;
      }

      id = R.id.btnAtras3;
      ImageView btnAtras3 = ViewBindings.findChildViewById(rootView, id);
      if (btnAtras3 == null) {
        break missingId;
      }

      id = R.id.btnCalendario;
      ImageView btnCalendario = ViewBindings.findChildViewById(rootView, id);
      if (btnCalendario == null) {
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

      id = R.id.etComentario;
      EditText etComentario = ViewBindings.findChildViewById(rootView, id);
      if (etComentario == null) {
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

      id = R.id.rvCategorias;
      RecyclerView rvCategorias = ViewBindings.findChildViewById(rootView, id);
      if (rvCategorias == null) {
        break missingId;
      }

      id = R.id.toolbarA;
      Toolbar toolbarA = ViewBindings.findChildViewById(rootView, id);
      if (toolbarA == null) {
        break missingId;
      }

      id = R.id.tvCategorias;
      TextView tvCategorias = ViewBindings.findChildViewById(rootView, id);
      if (tvCategorias == null) {
        break missingId;
      }

      id = R.id.tvDivisa;
      TextView tvDivisa = ViewBindings.findChildViewById(rootView, id);
      if (tvDivisa == null) {
        break missingId;
      }

      id = R.id.tvFechaSeleccionada;
      TextView tvFechaSeleccionada = ViewBindings.findChildViewById(rootView, id);
      if (tvFechaSeleccionada == null) {
        break missingId;
      }

      id = R.id.tvIngresos;
      TextView tvIngresos = ViewBindings.findChildViewById(rootView, id);
      if (tvIngresos == null) {
        break missingId;
      }

      return new MgAnadirGastoBinding((ConstraintLayout) rootView, btnAnadir, btnAtras3,
          btnCalendario, btnFecha1, btnFecha2, btnFecha3, etCantidad, etComentario, linearLayout2,
          linearLayout3, rvCategorias, toolbarA, tvCategorias, tvDivisa, tvFechaSeleccionada,
          tvIngresos);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}