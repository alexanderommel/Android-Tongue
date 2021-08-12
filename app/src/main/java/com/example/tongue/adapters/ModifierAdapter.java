package com.example.tongue.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.models.Modifier;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModifierAdapter extends RecyclerView.Adapter<ModifierAdapter.ModifierViewHolder> {

    // Fields
    private List<Modifier> modifiers;

    public ModifierAdapter(List<Modifier> modifiers){
        this.modifiers = modifiers;
    }

    @NonNull
    @NotNull
    @Override
    public ModifierViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_modifier_checkboxitem,parent,false);
        return new ModifierViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ModifierViewHolder holder, int position) {
        String price = modifiers.get(position).getPrice().toString();
        holder.modifierPrice.setText((CharSequence) price);
        holder.modifierNameCheckbox.setText(modifiers.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return modifiers.size();
    }

    public class ModifierViewHolder extends RecyclerView.ViewHolder{

        // Fields
        private CheckBox modifierNameCheckbox;
        private TextView modifierPrice;

        public ModifierViewHolder(@NonNull @NotNull View itemView, int viewType) {
            super(itemView);
            modifierNameCheckbox = itemView.findViewById(R.id.product_modifier_checkbox);
            modifierPrice = itemView.findViewById(R.id.product_modifier_price);
        }
    }
}
