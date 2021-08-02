package com.mukeshkpdeveloper.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbstractActivity implements MainActivityView {

    ImageView imgBack;
    Button btnAddNote, btnLogout;
    EditText edtNote;
    RecyclerView recyclerViewNote;

    MainPresenter mPresenter = new MainPresenter(this);
    NotesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBack = findViewById(R.id.imgBack);
        btnAddNote = findViewById(R.id.btnAddNote);
        btnLogout = findViewById(R.id.btnLogout);
        edtNote = findViewById(R.id.edtNote);
        recyclerViewNote = findViewById(R.id.recyclerViewNote);

        initListener();
        initRecyclerView();

        mPresenter.onCreate(getIntent());

    }


    Presenter getPresenter() {
        return mPresenter;
    }

    private void initListener() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addNote(edtNote.getText().toString());
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.logoutApp();
            }
        });
    }

    private void initRecyclerView() {
        recyclerViewNote.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new NotesAdapter(new ArrayList<Note>(), mPresenter);
        recyclerViewNote.setAdapter(mAdapter);
    }

    @Override
    public void setAdapter(List<Note> noteList) {
        mAdapter.updateAdapter(noteList);
    }

    @Override
    public void clearEdittext() {
        edtNote.setText("");
    }

    @Override
    public void showError(String msg) {
        showToast(msg);
    }

    @Override
    public void showLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        finish();
    }

}