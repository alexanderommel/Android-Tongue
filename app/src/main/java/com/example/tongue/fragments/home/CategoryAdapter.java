package com.example.tongue.fragments.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;

import org.jetbrains.annotations.NotNull;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private String[] localDataSet;

    public CategoryAdapter(String[] dataSet){localDataSet=dataSet;}

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        @SuppressLint("ResourceType") View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryViewHolder holder, int position) {
        // We bind here data
        if (position==0){
            holder.imageView.setImageResource(R.drawable.ic_car);
            holder.categoryTitle.setText("envio gratis");
        }
        if (position==1){
            holder.imageView.setImageResource(R.drawable.ic_etiqueta);
            holder.categoryTitle.setText("descuentos");
        }
        if (position==2){
            holder.imageView.setImageResource(R.drawable.ic_hamburguesa);
            holder.categoryTitle.setText("hamburguesas");
        }
        if (position==3){
            holder.imageView.setImageResource(R.drawable.ic_sushi);
            holder.categoryTitle.setText("sushi");
        }
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView categoryTitle;

        public CategoryViewHolder(View view){
            super(view);
            categoryTitle = view.findViewById(R.id.category_item_categoryTitle);
            imageView = (ImageView) view.findViewById(R.id.category_item_categoryImageView);
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

}
