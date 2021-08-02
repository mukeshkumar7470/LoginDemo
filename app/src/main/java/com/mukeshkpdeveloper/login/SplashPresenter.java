package com.mukeshkpdeveloper.login;

import android.content.Intent;

public class SplashPresenter extends AbstractPresenter {

    private SplashActivityView mView;
    UserPreferences mDatabase = new UserPreferencesImpl();

    public SplashPresenter(SplashActivityView mView) {
        this.mView = mView;
    }


    public void onCreate(Intent intent) {
        // Handle intent data here...
    }

    public void checkUserIsLogin() {
        if(mDatabase.isUserLogin()){
            mView.showMainActivity();
        }   else {
            mView.showLoginActivity();
        }
    }

}