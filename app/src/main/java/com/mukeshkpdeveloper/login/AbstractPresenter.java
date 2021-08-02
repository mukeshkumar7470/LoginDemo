package com.mukeshkpdeveloper.login;

public abstract class AbstractPresenter implements Presenter {
    protected String TAG = getClass().getSimpleName();

    public AbstractPresenter(){

    }

    @Override
    public void onStop() {
//        mCompositeSubscription.clear();
    }

    @Override
    public void onStart() {

    }

}