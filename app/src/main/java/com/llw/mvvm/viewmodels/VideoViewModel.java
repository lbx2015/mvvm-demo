package com.llw.mvvm.viewmodels;

import androidx.lifecycle.LiveData;

import com.llw.mvvm.model.VideoResponse;
import com.llw.mvvm.repository.VideoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * VideoFragment数据提供
 *
 * @author llw
 * {@link com.llw.mvvm.ui.fragment.VideoFragment}
 */
@HiltViewModel
public class VideoViewModel extends BaseViewModel {


    private final VideoRepository videoRepository;
    public LiveData<VideoResponse> video;

    @Inject
    VideoViewModel(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public void getVideo() {
        failed = videoRepository.failed;
        video = videoRepository.getVideo();
    }
}