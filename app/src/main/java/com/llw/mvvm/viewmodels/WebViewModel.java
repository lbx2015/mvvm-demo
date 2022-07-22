package com.llw.mvvm.viewmodels;

import androidx.lifecycle.LiveData;

import com.llw.mvvm.model.NewsDetailResponse;
import com.llw.mvvm.repository.WebRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * NewsFragment数据提供
 *
 * @author llw
 * {@link com.llw.mvvm.ui.activity.WebActivity}
 */
@HiltViewModel
public class WebViewModel extends BaseViewModel {

    private final WebRepository webRepository;
    public LiveData<NewsDetailResponse> newsDetail;

    @Inject
    WebViewModel(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public void getNewDetail(String uniquekey) {
        failed = webRepository.failed;
        newsDetail = webRepository.getNewsDetail(uniquekey);
    }
}