// Generated by view binder compiler. Do not edit!
package run.budgetbuddy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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

public final class MgInfoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView btnAtras;

  @NonNull
  public final LinearLayout linearLayout5;

  @NonNull
  public final ListView listaGastos;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final Toolbar toolbarA;

  @NonNull
  public final TextView tvAnho;

  @NonNull
  public final TextView tvDia;

  @NonNull
  public final TextView tvGastos;

  @NonNull
  public final TextView tvIngresos;

  @NonNull
  public final TextView tvMes;

  @NonNull
  public final TextView tvPeriodo;

  @NonNull
  public final TextView tvResultadoFecha;

  @NonNull
  public final TextView tvSemana;

  private MgInfoBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView btnAtras,
      @NonNull LinearLayout linearLayout5, @NonNull ListView listaGastos,
      @NonNull TextView textView10, @NonNull TextView textView3, @NonNull TextView textView8,
      @NonNull Toolbar toolbarA, @NonNull TextView tvAnho, @NonNull TextView tvDia,
      @NonNull TextView tvGastos, @NonNull TextView tvIngresos, @NonNull TextView tvMes,
      @NonNull TextView tvPeriodo, @NonNull TextView tvResultadoFecha, @NonNull TextView tvSemana) {
    this.rootView = rootView;
    this.btnAtras = btnAtras;
    this.linearLayout5 = linearLayout5;
    this.listaGastos = listaGastos;
    this.textView10 = textView10;
    this.textView3 = textView3;
    this.textView8 = textView8;
    this.toolbarA = toolbarA;
    this.tvAnho = tvAnho;
    this.tvDia = tvDia;
    this.tvGastos = tvGastos;
    this.tvIngresos = tvIngresos;
    this.tvMes = tvMes;
    this.tvPeriodo = tvPeriodo;
    this.tvResultadoFecha = tvResultadoFecha;
    this.tvSemana = tvSemana;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MgInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MgInfoBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.mg_info, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MgInfoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAtras;
      ImageView btnAtras = ViewBindings.findChildViewById(rootView, id);
      if (btnAtras == null) {
        break missingId;
      }

      id = R.id.linearLayout5;
      LinearLayout linearLayout5 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout5 == null) {
        break missingId;
      }

      id = R.id.lista_gastos;
      ListView listaGastos = ViewBindings.findChildViewById(rootView, id);
      if (listaGastos == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.toolbarA;
      Toolbar toolbarA = ViewBindings.findChildViewById(rootView, id);
      if (toolbarA == null) {
        break missingId;
      }

      id = R.id.tvAnho;
      TextView tvAnho = ViewBindings.findChildViewById(rootView, id);
      if (tvAnho == null) {
        break missingId;
      }

      id = R.id.tvDia;
      TextView tvDia = ViewBindings.findChildViewById(rootView, id);
      if (tvDia == null) {
        break missingId;
      }

      id = R.id.tvGastos;
      TextView tvGastos = ViewBindings.findChildViewById(rootView, id);
      if (tvGastos == null) {
        break missingId;
      }

      id = R.id.tvIngresos;
      TextView tvIngresos = ViewBindings.findChildViewById(rootView, id);
      if (tvIngresos == null) {
        break missingId;
      }

      id = R.id.tvMes;
      TextView tvMes = ViewBindings.findChildViewById(rootView, id);
      if (tvMes == null) {
        break missingId;
      }

      id = R.id.tvPeriodo;
      TextView tvPeriodo = ViewBindings.findChildViewById(rootView, id);
      if (tvPeriodo == null) {
        break missingId;
      }

      id = R.id.tvResultadoFecha;
      TextView tvResultadoFecha = ViewBindings.findChildViewById(rootView, id);
      if (tvResultadoFecha == null) {
        break missingId;
      }

      id = R.id.tvSemana;
      TextView tvSemana = ViewBindings.findChildViewById(rootView, id);
      if (tvSemana == null) {
        break missingId;
      }

      return new MgInfoBinding((ConstraintLayout) rootView, btnAtras, linearLayout5, listaGastos,
          textView10, textView3, textView8, toolbarA, tvAnho, tvDia, tvGastos, tvIngresos, tvMes,
          tvPeriodo, tvResultadoFecha, tvSemana);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
