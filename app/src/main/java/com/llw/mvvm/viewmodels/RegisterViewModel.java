package com.llw.mvvm.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.llw.mvvm.db.bean.User;
import com.llw.mvvm.repository.UserRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


/**
 * 注册页面数据提供
 *
 * @author llw
 */
@HiltViewModel
public class RegisterViewModel extends BaseViewModel {

    private final UserRepository userRepository;
    public MutableLiveData<User> user;


    @Inject
    RegisterViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MutableLiveData<User> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
        }
        return user;
    }

    /**
     * 注册
     */
    public void register() {
        failed = userRepository.failed;
        user.getValue().setUid(1);
        Log.d("TAG", "register: " + new Gson().toJson(user.getValue()));
        userRepository.saveUser(user.getValue());
    }
}
