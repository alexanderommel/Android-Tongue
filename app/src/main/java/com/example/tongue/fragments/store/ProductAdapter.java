package com.example.tongue.fragments.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.fragments.home.StoreAdapter;
import com.example.tongue.models.Product;
import com.example.tongue.models.ProductClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private List<Product> products;
    private ProductClickListener productClickListener;

    public ProductAdapter(List<Product> products, ProductClickListener productClickListener){
        this.productClickListener = productClickListener;
        this.products=products;
    }

    @NonNull
    @NotNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_variant_product_item,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // Product Item View
        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;
        private Product product;

        public ProductViewHolder(@NonNull @NotNull View itemView){
            super(itemView);
            productImage = (ImageView) itemView.findViewById(R.id.store_variant_product_item_productImage);
            productTitle = (TextView) itemView.findViewById(R.id.store_variant_product_item_title);
            productDescription = (TextView) itemView.findViewById(R.id.store_variant_product_item_description);
            productPrice = (TextView) itemView.findViewById(R.id.store_variant_product_item_price);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            productClickListener.onProductClicked(product,v);
        }


    }


    }
