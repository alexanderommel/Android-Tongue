package com.example.tongue.fragments.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;

import com.example.tongue.models.StoreVariant;
import com.example.tongue.models.storeClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.AbstractMutableList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    // Fields
    private List<StoreVariant> storeVariants;
    private storeClickListener storeClickListener;

    public StoreAdapter(List<StoreVariant> storeVariants, storeClickListener listener){
        this.storeVariants = storeVariants;
        this.storeClickListener=listener;
    }


    @SuppressLint("ResourceType")
    @Override
    public StoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if (viewType==0){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.category_recycler, parent, false);
        }else{
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.store_item, parent, false);
        }

        return new StoreViewHolder(view,viewType);
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 1; //Default is 1
        if (position == 0) viewType = 0; //If zero, it will be a header view
        return viewType;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StoreViewHolder holder, int position) {
        System.out.println(position);
        if (position==0){
            // populate header

            return;
        }
        if (position==1){
            holder.imageView.setImageResource(R.drawable.japonesastore);
            holder.titleStore.setText("Japanese Sushi Veintimilla");
        }
        if (position==2){
            holder.imageView.setImageResource(R.drawable.papajhonsstore);
            holder.titleStore.setText("Papa Jhons Quicentro Sur");
        }
    }

    @Override
    public int getItemCount() {
        return storeVariants.size();
    }


    public class StoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //Stores
        private ImageView imageView;
        private TextView titleStore;
        private StoreVariant storeVariant;



        //Category header
        private ImageView imageViewCategory;
        private RecyclerView categoryRecyclerView;

        public StoreViewHolder(View view,int viewType){
            super(view);
            if (viewType==0){
                //imageViewCategory = (ImageView) view.findViewById(R.id.category_item_categoryImageView);
                categoryRecyclerView = (RecyclerView) view.findViewById(R.id.category_recyclerView);
                LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
                manager.setOrientation(RecyclerView.HORIZONTAL);
                CategoryAdapter categoryAdapter = new CategoryAdapter(new String[]{"B","C","d","e","f","g","a","b","asd"});
                categoryRecyclerView.setLayoutManager(manager);
                categoryRecyclerView.setAdapter(categoryAdapter);

            }else {
                imageView = (ImageView) view.findViewById(R.id.store_item_storeImageView);
                titleStore = (TextView) view.findViewById(R.id.store_item_storeName);
                imageView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            storeClickListener.onStoreVariantClicked(storeVariant, v);
        }
    }

}
