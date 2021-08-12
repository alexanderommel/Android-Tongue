package com.example.tongue.adapters;

public class CollectionProductAdapter {


    /*
    // Fields
    private List<List<CollectionProductAllocation>> allocations;

    public CollectionProductAdapter(List<List<CollectionProductAllocation>> allocations){
        this.allocations=allocations;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @NotNull
    @Override
    public CollectionProductViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_recycler, parent, false);
        return new CollectionProductViewHolder(view,viewType,allocations.get(viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CollectionProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return allocations.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class CollectionProductViewHolder extends RecyclerView.ViewHolder{

        // Collection headers
        private TextView collectionHeader;
        private List<CollectionProductAllocation> productAllocations;

        // Products
        private RecyclerView productsRecyclerView;

        @RequiresApi(api = Build.VERSION_CODES.N)
        public CollectionProductViewHolder(@NonNull @NotNull View itemView, int viewType, List<CollectionProductAllocation> productAllocations) {
            super(itemView);

            productsRecyclerView = (RecyclerView) itemView.findViewById(R.id.products_recyclerView2);
            System.out.println(productsRecyclerView==null);
            LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(RecyclerView.VERTICAL);

            List<Product> products = productAllocations
                    .stream().map(CollectionProductAllocation::getProduct).collect(Collectors.toList());

            ProductAdapter adapter = new ProductAdapter(products);

            System.out.println(manager==null);
            productsRecyclerView.setLayoutManager(manager);
            productsRecyclerView.setAdapter(adapter);

        }
    }


     */
}
