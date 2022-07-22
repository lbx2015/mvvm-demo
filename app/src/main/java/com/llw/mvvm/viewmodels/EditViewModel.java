package com.llw.mvvm.viewmodels;

import androidx.lifecycle.LiveData;

import com.llw.mvvm.db.bean.Notebook;
import com.llw.mvvm.repository.NotebookRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * EditViewModel
 *
 * @author llw
 * {@link com.llw.mvvm.ui.activity.EditActivity}
 */
@HiltViewModel
public class EditViewModel extends BaseViewModel {

    private final NotebookRepository notebookRepository;

    public LiveData<Notebook> notebook;

    @Inject
    EditViewModel(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    /**
     * 添加笔记
     */
    public void addNotebook(Notebook notebook) {
        failed = notebookRepository.failed;
        notebookRepository.saveNotebook(notebook);
    }

    /**
     * 根据Id搜索笔记
     */
    public void queryById(int uid) {
        notebook = notebookRepository.getNotebookById(uid);
        failed = notebookRepository.failed;
    }

    /**
     * 更新笔记
     */
    public void updateNotebook(Notebook notebook) {
        notebookRepository.updateNotebook(notebook);
        failed = notebookRepository.failed;
    }

    /**
     * 删除笔记
     */
    public void deleteNotebook(Notebook notebook) {
        notebookRepository.deleteNotebook(notebook);
        failed = notebookRepository.failed;
    }

}
