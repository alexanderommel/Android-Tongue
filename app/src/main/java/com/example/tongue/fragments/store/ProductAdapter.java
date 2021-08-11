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

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private List<Product> products;

    public ProductAdapter(List<Product> products){this.products=products;}

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


    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        // Product Item View
        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;

        public ProductViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            productImage = (ImageView) itemView.findViewById(R.id.store_variant_product_item_productImage);
            productTitle = (TextView) itemView.findViewById(R.id.store_variant_product_item_title);
            productDescription = (TextView) itemView.findViewById(R.id.store_variant_product_item_description);
            productPrice = (TextView) itemView.findViewById(R.id.store_variant_product_item_price);
        }

        public ImageView getProductImage() {
            return productImage;
        }

        public TextView getProductTitle() {
            return productTitle;
        }

        public TextView getProductDescription() {
            return productDescription;
        }

        public TextView getProductPrice() {
            return productPrice;
        }
    }



    }
