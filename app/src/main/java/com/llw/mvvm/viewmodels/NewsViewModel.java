package com.llw.mvvm.viewmodels;

import androidx.lifecycle.LiveData;

import com.llw.mvvm.model.NewsResponse;
import com.llw.mvvm.repository.NewsRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * NewsFragment数据提供
 *
 * @author llw
 * {@link com.llw.mvvm.ui.fragment.NewsFragment}
 */
@HiltViewModel
public class NewsViewModel extends BaseViewModel {

    public LiveData<NewsResponse> news;

    private final NewsRepository newsRepository;

    @Inject
    public NewsViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void getNews() {
        failed = newsRepository.failed;
        news = newsRepository.getNews();
    }
}