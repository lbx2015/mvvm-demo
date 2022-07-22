package com.llw.mvvm.viewmodels;

import androidx.lifecycle.LiveData;

import com.llw.mvvm.db.bean.User;
import com.llw.mvvm.repository.UserRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * HomeViewModel
 *
 * @author llw
 * {@link com.llw.mvvm.ui.activity.HomeActivity}
 */
@HiltViewModel
public class HomeViewModel extends BaseViewModel {

    private final UserRepository userRepository;
    public LiveData<User> user;
    public String defaultName = "初学者-Study";
    public String defaultIntroduction = "Android | Java";

    @Inject
    HomeViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void getUser() {
        user = userRepository.getUser();
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
        failed = userRepository.failed;
        getUser();
    }
}
