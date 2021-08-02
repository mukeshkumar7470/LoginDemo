package com.mukeshkpdeveloper.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AbstractActivity implements SplashActivityView {

    SplashPresenter mPresenter = new SplashPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter.onCreate(getIntent());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.checkUserIsLogin();
            }
        },2000);
    }


    Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showLoginActivity() {
        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        finish();
    }

    @Override
    public void showMainActivity() {
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        finish();
    }

}