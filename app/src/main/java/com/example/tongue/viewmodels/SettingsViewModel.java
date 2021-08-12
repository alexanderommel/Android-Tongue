package com.example.tongue.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private MutableLiveData<String> string;

    public SettingsViewModel(){
        string = new MutableLiveData<>();
        string.setValue("Bebe");
    }

    public LiveData<String> getText(){return string;}
}
