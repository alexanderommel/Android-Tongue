package com.example.tongue.fragments.store;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.databinding.FragmentHomeBinding;
import com.example.tongue.databinding.StoreVariantFragmentdescBinding;
import com.example.tongue.fragments.home.HomeViewModel;
import com.example.tongue.fragments.home.StoreAdapter;
import com.example.tongue.models.Collection;
import com.example.tongue.models.CollectionProductAllocation;
import com.example.tongue.models.CollectionProductAllocation;
import com.example.tongue.models.CollectionScrollChange;
import com.example.tongue.models.Product;
import com.example.tongue.models.SectionClickListener;
import com.example.tongue.testingdata.CollectionGenerators;
import com.example.tongue.testingdata.CollectionProductAllocationGenerator;
import com.example.tongue.testingdata.ProductGenerators;

import java.util.List;
import java.util.stream.Collectors;

public class StoreVariantDescriptionFragment extends Fragment {

    private Button lastActivatedButton;
    private HomeViewModel homeViewModel;
    private StoreVariantFragmentdescBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        // Custom setting
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = StoreVariantFragmentdescBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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
                binding.storeVariantHomeRecyclerView.scrollToPosition(collection.getRelativePosition());
            }
        });
        sectionAdapter.setContext(getContext());
        binding.storeVariantSectionRecyclerview.setLayoutManager(sectionManager);
        binding.storeVariantSectionRecyclerview.setAdapter(sectionAdapter);

        // Collection recycler view setting
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());

        manager.setOrientation(RecyclerView.VERTICAL);
        CollectionAdapter adapter = new CollectionAdapter(allocationsList);
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


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
