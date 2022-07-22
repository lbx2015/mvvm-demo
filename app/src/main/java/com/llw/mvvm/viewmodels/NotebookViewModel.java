package com.llw.mvvm.viewmodels;

import androidx.lifecycle.LiveData;

import com.llw.mvvm.db.bean.Notebook;
import com.llw.mvvm.repository.NotebookRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * NotebookViewModel
 *
 * @author llw
 * {@link com.llw.mvvm.ui.activity.NotebookActivity}
 */
@HiltViewModel
public class NotebookViewModel extends BaseViewModel {

    private final NotebookRepository notebookRepository;

    public LiveData<List<Notebook>> notebooks;

    @Inject
    NotebookViewModel(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public void getNotebooks() {
        notebooks = notebookRepository.getNotebooks();
        failed = notebookRepository.failed;
    }

    /**
     * 删除笔记
     */
    public void deleteNotebook(Notebook... notebook) {
        notebookRepository.deleteNotebook(notebook);
        failed = notebookRepository.failed;
    }

    /**
     * 搜索笔记
     *
     * @param input 输入内容
     */
    public void searchNotebook(String input) {
        notebooks = notebookRepository.searchNotebook(input);
        failed = notebookRepository.failed;
    }
}
