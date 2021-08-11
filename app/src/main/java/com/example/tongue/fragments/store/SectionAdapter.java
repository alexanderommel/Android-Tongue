package com.example.tongue.fragments.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.models.Collection;
import com.example.tongue.models.SectionClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder>{

    // fields
    private List<Collection> collections;
    private Context context;
    private SectionClickListener sectionClickListener;

    // constructor
    public SectionAdapter(List<Collection> collections, SectionClickListener sectionClickListener){
        this.collections=collections;
        this.sectionClickListener=sectionClickListener;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    // methods

    @NonNull
    @NotNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_variant_section_item,parent,false);
        return new SectionAdapter.SectionViewHolder(view, viewType);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull @NotNull SectionViewHolder holder, int position) {
        holder.button.setText(collections.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class SectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // fields
        private Button button;
        private Collection collection;

        // constructor
        public SectionViewHolder(View view,int viewType){
            super(view);
            button = view.findViewById(R.id.store_variant_section_button);
            this.collection = collections.get(viewType);
            this.collection.setRelativePosition(viewType);
            button.setOnClickListener(this);
        }

        // methods

        @Override
        public void onClick(View v) {
            sectionClickListener.onSectionClicked(collection,v);
        }
    }
}
