package com.llw.mvvm.viewmodels;

import androidx.lifecycle.LiveData;

import com.llw.mvvm.db.bean.WallPaper;
import com.llw.mvvm.repository.PictureRepository;
import com.llw.mvvm.ui.activity.PictureViewActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * PictureViewModel
 *
 * @author llw
 * 作用于 {@link PictureViewActivity}
 */
@HiltViewModel
public class PictureViewModel extends BaseViewModel {

    private final PictureRepository pictureRepository;
    public LiveData<List<WallPaper>> wallPaper;

    @Inject
    PictureViewModel(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public void getWallPaper() {
        failed = pictureRepository.failed;
        wallPaper = pictureRepository.getWallPaper();
    }
}
