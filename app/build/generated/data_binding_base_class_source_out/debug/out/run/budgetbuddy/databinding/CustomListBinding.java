// Generated by view binder compiler. Do not edit!
package run.budgetbuddy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import run.budgetbuddy.R;

public final class CustomListBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout customList;

  @NonNull
  public final LinearLayout imgLayout;

  @NonNull
  public final ImageView ivIcono;

  @NonNull
  public final TextView tvNombre1;

  @NonNull
  public final TextView tvNombre2;

  private CustomListBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout customList,
      @NonNull LinearLayout imgLayout, @NonNull ImageView ivIcono, @NonNull TextView tvNombre1,
      @NonNull TextView tvNombre2) {
    this.rootView = rootView;
    this.customList = customList;
    this.imgLayout = imgLayout;
    this.ivIcono = ivIcono;
    this.tvNombre1 = tvNombre1;
    this.tvNombre2 = tvNombre2;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout customList = (LinearLayout) rootView;

      id = R.id.imgLayout;
      LinearLayout imgLayout = ViewBindings.findChildViewById(rootView, id);
      if (imgLayout == null) {
        break missingId;
      }

      id = R.id.ivIcono;
      ImageView ivIcono = ViewBindings.findChildViewById(rootView, id);
      if (ivIcono == null) {
        break missingId;
      }

      id = R.id.tvNombre1;
      TextView tvNombre1 = ViewBindings.findChildViewById(rootView, id);
      if (tvNombre1 == null) {
        break missingId;
      }

      id = R.id.tvNombre2;
      TextView tvNombre2 = ViewBindings.findChildViewById(rootView, id);
      if (tvNombre2 == null) {
        break missingId;
      }

      return new CustomListBinding((LinearLayout) rootView, customList, imgLayout, ivIcono,
          tvNombre1, tvNombre2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
