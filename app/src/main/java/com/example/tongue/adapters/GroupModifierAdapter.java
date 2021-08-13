package com.example.tongue.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.interfaces.CheckboxClickListener;
import com.example.tongue.interfaces.ModifierClickListener;
import com.example.tongue.models.Modifier;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GroupModifierAdapter extends RecyclerView.Adapter<GroupModifierAdapter.GroupModifierViewHolder> {

    // Fields
    private List<List<Modifier>> modifiers;

    public GroupModifierAdapter(List<List<Modifier>> modifiers ){
        this.modifiers = modifiers;
    }

    @NonNull
    @NotNull
    @Override
    public GroupModifierViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_modifier_item,parent,false);
        return new GroupModifierViewHolder(view, viewType, modifiers.get(viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GroupModifierViewHolder holder, int position) {
        holder.groupModifierContext.setText(modifiers.get(position).get(0).getGroupModifier().getContext());
        holder.groupModifierType.setText(modifiers.get(position).get(0).getGroupModifier().getType());
    }

    @Override
    public int getItemCount() {
        return modifiers.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class GroupModifierViewHolder extends RecyclerView.ViewHolder{

        // Fields
        private TextView groupModifierContext;
        private RecyclerView recyclerView;
        private TextView groupModifierType;

        public GroupModifierViewHolder(@NonNull @NotNull View itemView, int viewType, List<Modifier> modifierList) {
            super(itemView);
            groupModifierContext = itemView.findViewById(R.id.product_modifier_groupname);
            groupModifierType = itemView.findViewById(R.id.product_modifier_type);
            recyclerView = itemView.findViewById(R.id.product_modifier_recyclerview);
            LinearLayoutManager manager =new LinearLayoutManager(itemView.getContext());
            ModifierAdapter adapter;
            // Checkbox buttons
            int maximumActiveModifiers = modifierList.get(0).getGroupModifier().getMaximumActiveModifiers();
            int minimumActiveModifiers = modifierList.get(0).getGroupModifier().getMinimumActiveModifiers();
            if (maximumActiveModifiers==1 && minimumActiveModifiers==1) {
                adapter = new ModifierAdapter(modifierList, false);
                adapter.setListener(new ModifierClickListener() {
                    @Override
                    public void onModifierClicked(Modifier modifier, View view, int position, Boolean uniquePick) {
                        int numChildren = adapter.getItemCount();
                        System.out.println(view.getClass().getSimpleName());
                        if (uniquePick) {
                            for (int i = 0; i < numChildren; i++) {
                                LinearLayoutCompat modifierLayout = (LinearLayoutCompat) recyclerView.getChildAt(i);
                                RadioButton button = modifierLayout.findViewById(R.id.product_modifier_radiobutton);
                                button.setChecked(false);
                            }
                            RadioButton button = (RadioButton) view;
                            button.setChecked(true);
                        }
                    }
                });
            }
            else {
                adapter = new ModifierAdapter(modifierList, true);
                adapter.setListener(new ModifierClickListener() {
                    @Override
                    public void onModifierClicked(Modifier modifier, View view, int position, Boolean uniquePick) {
                    }
                });
            }
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        }
    }
}
