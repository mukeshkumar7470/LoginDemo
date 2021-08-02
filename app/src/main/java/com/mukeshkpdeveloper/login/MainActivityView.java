package com.mukeshkpdeveloper.login;

import java.util.List;

public interface MainActivityView {

    void showLoginActivity();

    void showError(String msg);

    void setAdapter(List<Note> notes);

    void clearEdittext();

}