package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WhowroteItActivity extends AppCompatActivity {

    EditText mBookInput;
    TextView mTitleText,mAuthorText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whowrote_it);
        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
    }

    public void searchBooks(View view) {
        String mQueryString = mBookInput.getText().toString();

        new FetchBook(mTitleText, mAuthorText).execute(mQueryString);
    }
}