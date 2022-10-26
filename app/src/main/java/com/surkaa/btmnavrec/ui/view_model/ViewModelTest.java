package com.surkaa.btmnavrec.ui.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelTest extends ViewModel {

    private final MutableLiveData<String> mText;

    public ViewModelTest() {
        mText = new MutableLiveData<>();
        mText.setValue("This is viewModel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}