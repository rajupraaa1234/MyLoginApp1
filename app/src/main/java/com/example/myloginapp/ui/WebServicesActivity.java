package com.example.myloginapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myloginapp.FetchBook;
import com.example.myloginapp.FetchBookTask;
import com.example.myloginapp.R;

public class WebServicesActivity extends AppCompatActivity {

    EditText mBookInput;
    TextView mTitleText,mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_services);

        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
    }

    public void searchBooksApi(View view) {
        String queryString = mBookInput.getText().toString();
        FetchBookTask fetchBookTask = new FetchBookTask(mTitleText,mAuthorText);
        fetchBookTask.execute(queryString);
    }

    public void searchBooks(View view) {
        String mQueryString = mBookInput.getText().toString();

        new FetchBook(mTitleText, mAuthorText).execute(mQueryString);
    }
}