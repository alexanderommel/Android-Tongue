package com.example.tongue.fragments.product;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProductViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("Hey guys");
    }

    public LiveData<String> getText(){ return mText;}
}
