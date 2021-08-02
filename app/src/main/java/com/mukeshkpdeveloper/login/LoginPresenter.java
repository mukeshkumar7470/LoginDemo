package com.mukeshkpdeveloper.login;

import android.content.Intent;
import android.text.TextUtils;

public class LoginPresenter extends AbstractPresenter {

    private LoginActivityView mView;
    UserPreferences mDatabase = new UserPreferencesImpl();

    public LoginPresenter(LoginActivityView mView) {
        this.mView = mView;
    }

    public void onCreate(Intent intent) {
        // Handle intent data here...
    }

    /**
     * validate login data here
     * and if data valid, redirect to main screen.
     */

    public void login(String username, String password) {
        if(TextUtils.isEmpty(username)){
            mView.showError("Please enter username");
        }else if(username.length() < 6){
            mView.showError("Username must contains 6 letters");
        }else if(TextUtils.isEmpty(password)){
            mView.showError("Please enter password");
        }else if(password.length() < 6){
            mView.showError("Password must contains 6 letters");
        }else {
            mDatabase.setUserLogin(true);
            mView.showMainActivity();
        }
    }
}