package com.llw.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.llw.mvvm.model.User;
import com.llw.mvvm.repository.UserRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * 登录页面ViewModel
 *
 * @author llw
 */
@HiltViewModel
public class LoginViewModel extends BaseViewModel {

    private final UserRepository userRepository;

    public MutableLiveData<User> user;
    public LiveData<com.llw.mvvm.db.bean.User> localUser;

    @Inject
    LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MutableLiveData<User> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
        }
        return user;
    }

    public void getLocalUser() {
        localUser = userRepository.getUser();
        failed = userRepository.failed;
    }
}
