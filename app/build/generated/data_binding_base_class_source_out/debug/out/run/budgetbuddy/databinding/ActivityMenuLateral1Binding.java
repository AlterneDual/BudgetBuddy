// Generated by view binder compiler. Do not edit!
package run.budgetbuddy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import run.budgetbuddy.R;

public final class ActivityMenuLateral1Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView btnCerrar;

  @NonNull
  public final FrameLayout frameLayout2;

  @NonNull
  public final FrameLayout frameLayout3;

  @NonNull
  public final ImageView icPerfil;

  @NonNull
  public final ConstraintLayout linearLayout;

  @NonNull
  public final ListView listViewMenu;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView txtEditarPerfil;

  private ActivityMenuLateral1Binding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView btnCerrar, @NonNull FrameLayout frameLayout2,
      @NonNull FrameLayout frameLayout3, @NonNull ImageView icPerfil,
      @NonNull ConstraintLayout linearLayout, @NonNull ListView listViewMenu,
      @NonNull TextView textView6, @NonNull TextView txtEditarPerfil) {
    this.rootView = rootView;
    this.btnCerrar = btnCerrar;
    this.frameLayout2 = frameLayout2;
    this.frameLayout3 = frameLayout3;
    this.icPerfil = icPerfil;
    this.linearLayout = linearLayout;
    this.listViewMenu = listViewMenu;
    this.textView6 = textView6;
    this.txtEditarPerfil = txtEditarPerfil;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMenuLateral1Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMenuLateral1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_menu_lateral_1, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMenuLateral1Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCerrar;
      ImageView btnCerrar = ViewBindings.findChildViewById(rootView, id);
      if (btnCerrar == null) {
        break missingId;
      }

      id = R.id.frameLayout2;
      FrameLayout frameLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout2 == null) {
        break missingId;
      }

      id = R.id.frameLayout3;
      FrameLayout frameLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout3 == null) {
        break missingId;
      }

      id = R.id.icPerfil;
      ImageView icPerfil = ViewBindings.findChildViewById(rootView, id);
      if (icPerfil == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      ConstraintLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.listView_menu;
      ListView listViewMenu = ViewBindings.findChildViewById(rootView, id);
      if (listViewMenu == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.txtEditarPerfil;
      TextView txtEditarPerfil = ViewBindings.findChildViewById(rootView, id);
      if (txtEditarPerfil == null) {
        break missingId;
      }

      return new ActivityMenuLateral1Binding((ConstraintLayout) rootView, btnCerrar, frameLayout2,
          frameLayout3, icPerfil, linearLayout, listViewMenu, textView6, txtEditarPerfil);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}