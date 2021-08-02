package com.mukeshkpdeveloper.login;

import java.util.List;

public interface UserPreferences {

    String IS_USER_LOGIN = "isUserLogin";
    String NOTES_LIST = "notes_list";

    public void setUserLogin(boolean status);

    public boolean isUserLogin();

    public void addNote(Note note);

    public List<Note> getNotes();

    public void clearUser();

    void removeNote(Note note);

}