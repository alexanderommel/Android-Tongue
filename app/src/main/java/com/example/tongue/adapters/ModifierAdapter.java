package com.example.tongue.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.interfaces.CheckboxClickListener;
import com.example.tongue.interfaces.ModifierClickListener;
import com.example.tongue.interfaces.RadioButtonClickListener;
import com.example.tongue.models.Modifier;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModifierAdapter extends RecyclerView.Adapter<ModifierAdapter.ModifierViewHolder> {

    // Fields
    private List<Modifier> modifiers;
    private Boolean isCheckBox;
    private ModifierClickListener listener;

    public ModifierAdapter(List<Modifier> modifiers
            ,Boolean isCheckBox){
        this.modifiers = modifiers;
        this.isCheckBox=isCheckBox;
    }

    public void setListener(ModifierClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public ModifierViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view;
        if (isCheckBox){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.product_modifier_checkboxitem,parent,false);
        }else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.product_modifier_radiobuttonitem,parent,false);
        }
        return new ModifierViewHolder(view, viewType, isCheckBox);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ModifierViewHolder holder, int position) {
        String price = "$"+modifiers.get(position).getPrice().toString();
        holder.modifierPrice.setText((CharSequence) price);
        if (isCheckBox)
            holder.modifierNameCheckbox.setText(modifiers.get(position).getName());
        else
            holder.modifierNameRadioButton.setText(modifiers.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return modifiers.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ModifierViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // Fields
        private Modifier modifier=new Modifier();
        private RadioButton modifierNameRadioButton;
        private CheckBox modifierNameCheckbox;
        private TextView modifierPrice;
        private int position;
        private Boolean uniquePick;

        public ModifierViewHolder(@NonNull @NotNull View itemView, int viewType, Boolean isCheckBox) {
            super(itemView);
            this.position = viewType;
            this.uniquePick = !isCheckBox;
            if (isCheckBox==true){
                modifierNameCheckbox = itemView.findViewById(R.id.product_modifier_checkbox);
                modifierNameCheckbox.setOnClickListener(this);
            }else {
                modifierNameRadioButton = itemView.findViewById(R.id.product_modifier_radiobutton);
                modifierNameRadioButton.setOnClickListener(this);
            }
            modifierPrice = itemView.findViewById(R.id.product_modifier_price);
        }

        @Override
        public void onClick(View v) {
            listener.onModifierClicked(modifier,v,position,uniquePick);
        }
    }
}
