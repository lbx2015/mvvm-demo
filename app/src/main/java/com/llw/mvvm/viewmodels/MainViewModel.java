package com.llw.mvvm.viewmodels;

import androidx.lifecycle.LiveData;

import com.llw.mvvm.model.BiYingResponse;
import com.llw.mvvm.model.WallPaperResponse;
import com.llw.mvvm.repository.MainRepository;
import com.llw.mvvm.ui.activity.MainActivity;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


/**
 * 主页面ViewModel
 *
 * @author llw
 * {@link MainActivity}
 */
@HiltViewModel
public class MainViewModel extends BaseViewModel {

    private final MainRepository mainRepository;
    public LiveData<BiYingResponse> biying;
    public LiveData<WallPaperResponse> wallPaper;

    @Inject
    MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public void getBiying() {
        failed = mainRepository.failed;
        biying = mainRepository.getBiYing();
    }

    public void getWallPaper() {
        failed = mainRepository.failed;
        wallPaper = mainRepository.getWallPaper();
    }
}
