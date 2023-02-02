// Generated by view binder compiler. Do not edit!
package run.budgetbuddy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

public final class MainView3gBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton addGrupo;

  @NonNull
  public final Button addGrupoEnlace;

  @NonNull
  public final RecyclerView groupList;

  @NonNull
  public final Button nuevoGrupo;

  @NonNull
  public final ImageButton optionsGrupo;

  @NonNull
  public final Toolbar toolbar;

  private MainView3gBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton addGrupo,
      @NonNull Button addGrupoEnlace, @NonNull RecyclerView groupList, @NonNull Button nuevoGrupo,
      @NonNull ImageButton optionsGrupo, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.addGrupo = addGrupo;
    this.addGrupoEnlace = addGrupoEnlace;
    this.groupList = groupList;
    this.nuevoGrupo = nuevoGrupo;
    this.optionsGrupo = optionsGrupo;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MainView3gBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MainView3gBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.main_view_3g, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MainView3gBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addGrupo;
      ImageButton addGrupo = ViewBindings.findChildViewById(rootView, id);
      if (addGrupo == null) {
        break missingId;
      }

      id = R.id.addGrupoEnlace;
      Button addGrupoEnlace = ViewBindings.findChildViewById(rootView, id);
      if (addGrupoEnlace == null) {
        break missingId;
      }

      id = R.id.groupList;
      RecyclerView groupList = ViewBindings.findChildViewById(rootView, id);
      if (groupList == null) {
        break missingId;
      }

      id = R.id.nuevoGrupo;
      Button nuevoGrupo = ViewBindings.findChildViewById(rootView, id);
      if (nuevoGrupo == null) {
        break missingId;
      }

      id = R.id.optionsGrupo;
      ImageButton optionsGrupo = ViewBindings.findChildViewById(rootView, id);
      if (optionsGrupo == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new MainView3gBinding((ConstraintLayout) rootView, addGrupo, addGrupoEnlace, groupList,
          nuevoGrupo, optionsGrupo, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}