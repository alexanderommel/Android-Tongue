package com.example.tongue.adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.models.Collection;
import com.example.tongue.models.CollectionProductAllocation;
import com.example.tongue.models.Product;
import com.example.tongue.interfaces.ProductClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder>{

    // Fields
    private List<List<CollectionProductAllocation>> productAllocationsList;
    private int currentPosition=0;
    public ProductClickListener productClickListener;

    // Constructor
    public CollectionAdapter(List<List<CollectionProductAllocation>> productAllocationsList,
                             ProductClickListener productClickListener){
        this.productAllocationsList = productAllocationsList;
        this.productClickListener = productClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @NotNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_variant_collection_item,parent,false);
        return new CollectionAdapter.CollectionViewHolder(view,productAllocationsList.get(viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CollectionViewHolder holder, int position) {
        System.out.println(position);
        holder.title
                .setText(productAllocationsList.get(position).get(0).getCollection().getTitle());

    }

    @Override
    public int getItemCount() {
        return productAllocationsList.size();
    }



    public class CollectionViewHolder extends RecyclerView.ViewHolder {

        // Fields
        private TextView title;
        private RecyclerView productsRecyclerView;
        private Product product;
        private Collection collection;

        @RequiresApi(api = Build.VERSION_CODES.N)
        public CollectionViewHolder(@NonNull @NotNull View itemView, List<CollectionProductAllocation> productAllocations) {
            super(itemView);
            title = itemView.findViewById(R.id.store_variant_collection_title);
            productsRecyclerView = itemView.findViewById(R.id.store_variant_collection_recyclerview);
            LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(RecyclerView.VERTICAL);
            List<Product> products = productAllocations
                    .stream().map(CollectionProductAllocation::getProduct).collect(Collectors.toList());

            productsRecyclerView.setNestedScrollingEnabled(false);
            ProductAdapter productAdapter = new ProductAdapter(products,productClickListener);
            productsRecyclerView.setLayoutManager(manager);
            productsRecyclerView.setAdapter(productAdapter);
        }


    }
}
