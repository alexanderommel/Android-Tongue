package com.example.tongue.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tongue.adapters.GroupModifierAdapter;
import com.example.tongue.databinding.ProductFragmentBinding;
import com.example.tongue.models.GroupModifier;
import com.example.tongue.models.LineItem;
import com.example.tongue.models.Modifier;
import com.example.tongue.models.Product;
import com.example.tongue.testingdata.ModifiersGenerator;
import com.example.tongue.viewmodels.ProductViewModel;
import com.example.tongue.viewmodels.SharedCartViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductFragment extends Fragment {

    // Fields
    private ProductFragmentBinding binding;
    private ProductViewModel productViewModel;
    private OnLineItemAddedListener listener;
    private SharedCartViewModel model;
    private int quantity=1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        // Custom setting
        productViewModel =
                new ViewModelProvider(this).get(ProductViewModel.class);

        binding = ProductFragmentBinding.inflate(inflater, (ViewGroup) container, false);
        View root = binding.getRoot();


        // !!Temporal until Development of Tongue ViewModels!! (Bad Practice)
        List<List<Modifier>> modifiers = ModifiersGenerator.getModifierListsFromGroups();

        // GroupModifierRecyclerView population
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        GroupModifierAdapter adapter = new GroupModifierAdapter(modifiers);
        binding.productFragmentRecyclerView.setLayoutManager(manager);
        binding.productFragmentRecyclerView.setAdapter(adapter);

        // Increase Button Click Listener
        //binding.productFragmentIncreaseButton.bringToFront();
        binding.productFragmentIncreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity<=10){
                    quantity++;
                    binding.productFragmentQuantityTextView.setText(String.valueOf(quantity));
                }
            }
        });

        // Decrease Button Click Listener
        //binding.productFragmentReduceButton.bringToFront();
        binding.productFragmentReduceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity>=2){
                    quantity--;
                    binding.productFragmentQuantityTextView.setText(String.valueOf(quantity));
                }
            }
        });


        // AddProduct Click Listener
        model = new ViewModelProvider(requireActivity()).get(SharedCartViewModel.class);
        binding.productFragmentAddLineItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Temporal!!!
                LineItem item = new LineItem();
                Product product = new Product();
                product.setId(1L);
                item.setQuantity(1);
                item.setId(2L);
                item.setProduct(product);
                listener.OnLineItemAdded(item);
                model.addItemToCart(item);
            }
        });

        return root;

    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        try {
            listener = (ProductFragment.OnLineItemAddedListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ "must implement OnLineItemAddedListener");
        }
    }

    public interface OnLineItemAddedListener {
        public void OnLineItemAdded(LineItem lineItem);
    }
}
