package com.example.tongue.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.databinding.StoreVariantFragmentdescBinding;
import com.example.tongue.models.Cart;
import com.example.tongue.viewmodels.HomeViewModel;
import com.example.tongue.adapters.CollectionAdapter;
import com.example.tongue.adapters.SectionAdapter;
import com.example.tongue.models.Collection;
import com.example.tongue.models.CollectionProductAllocation;
import com.example.tongue.models.Product;
import com.example.tongue.interfaces.ProductClickListener;
import com.example.tongue.interfaces.SectionClickListener;
import com.example.tongue.testingdata.CollectionGenerators;
import com.example.tongue.testingdata.CollectionProductAllocationGenerator;
import com.example.tongue.viewmodels.SharedCartViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StoreVariantDescriptionFragment extends Fragment {

    private Button lastActivatedButton;
    private HomeViewModel homeViewModel;
    private StoreVariantFragmentdescBinding binding;
    private OnProductSelectedListener listener;
    private OnCartDetailsListener cartListener;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        // Custom setting
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = StoreVariantFragmentdescBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.storeVariantOrderLayout.setVisibility(View.GONE);

        // Testing data
        String[] titles = {"Hamburguesas","Pizzas","Sushi","Helados","Hamburguesas","Pizzas"};
        List<List<CollectionProductAllocation>> allocationsList =
                CollectionProductAllocationGenerator.getProductAllocationsList(titles,4);

        List<Collection> collections =
                CollectionGenerators.getCollections(titles);


        // Sections recycler view setting
        LinearLayoutManager sectionManager = new LinearLayoutManager(this.getContext());
        sectionManager.setOrientation(RecyclerView.HORIZONTAL);
        SectionAdapter sectionAdapter = new SectionAdapter(collections, new SectionClickListener() {
            @Override
            public void onSectionClicked(Collection collection, View view) {
                //binding.storeVariantHomeToolbar.setVisibility(View.INVISIBLE);
                binding.storeVariantHomeRecyclerView.scrollToPosition(collection.getRelativePosition());
            }
        });
        sectionAdapter.setContext(getContext());
        binding.storeVariantSectionRecyclerview.setLayoutManager(sectionManager);
        binding.storeVariantSectionRecyclerview.setAdapter(sectionAdapter);

        // Collection recycler view setting
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());

        manager.setOrientation(RecyclerView.VERTICAL);
        CollectionAdapter adapter = new CollectionAdapter(allocationsList, new ProductClickListener() {
            @Override
            public void onProductClicked(Product product, View view) {
                listener.onProductSelected(product);
            }
        });
        //CollectionProductAdapter adapter = new CollectionProductAdapter(allocationsList);
        binding.storeVariantHomeRecyclerView.setLayoutManager(manager);
        binding.storeVariantHomeRecyclerView.setAdapter(adapter);
        binding.storeVariantHomeRecyclerView.setNestedScrollingEnabled(true);



        // Scrolling listener setting
        binding.storeVariantHomeRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                int firstVisiblePosition = manager.findFirstVisibleItemPosition();
                //binding.storeVariantSectionRecyclerview.smoothScrollToPosition(firstVisiblePosition+1);
                if (firstVisiblePosition>=0){
                    LinearLayout child = (LinearLayout) sectionManager.getChildAt(firstVisiblePosition);
                    if (child!=null){
                        Button childSection = child.findViewById(R.id.store_variant_section_button);
                        if (lastActivatedButton!=null){
                            lastActivatedButton.setActivated(false);
                            Integer color = getContext().getColor(R.color.black);
                            lastActivatedButton.setTextColor(color);
                        }
                        Integer color = getContext().getColor(R.color.tongueRed);
                        childSection.setTextColor(color);
                        childSection.setActivated(true);
                        lastActivatedButton = childSection;
                        //binding.storeVariantSectionRecyclerview.scrollBy(firstVisiblePosition,0);


                    }
                }
                binding.storeVariantSectionRecyclerview.scrollToPosition(firstVisiblePosition);
                //binding.storeVariantSectionRecyclerview.scrollBy(1,0);



            }
        });

        // SharedCartViewModel observer implementation
        SharedCartViewModel model = new ViewModelProvider(requireActivity()).get(SharedCartViewModel.class);
        model.getCart().observe(getViewLifecycleOwner(), cart -> {
            System.out.println("called");
            binding.storeVariantOrderLayout.setVisibility(View.VISIBLE);
        });

        binding.storeVariantOrderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("test click");
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnProductSelectedListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ "must implement ProductSelectedListener");
        }
    }

    public interface OnProductSelectedListener {
        public void onProductSelected(Product product);
    }

    public interface OnCartDetailsListener {
        public void OnCartDetailsClicked(Cart cart);
    }

}
