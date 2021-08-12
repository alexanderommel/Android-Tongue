package com.example.tongue.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
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

        public GroupModifierViewHolder(@NonNull @NotNull View itemView, int viewType, List<Modifier> modifierList) {
            super(itemView);
            groupModifierContext = itemView.findViewById(R.id.product_modifier_groupname);
            recyclerView = itemView.findViewById(R.id.product_modifier_recyclerview);
            LinearLayoutManager manager =new LinearLayoutManager(itemView.getContext());
            ModifierAdapter adapter = new ModifierAdapter(modifierList);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        }
    }
}
