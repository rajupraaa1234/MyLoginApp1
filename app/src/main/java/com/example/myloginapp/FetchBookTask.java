package com.example.myloginapp;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.myloginapp.Utility.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONObject;

public class FetchBookTask extends AsyncTask<String,Void,String> {
    private TextView mTitleText;
    private TextView mAuthorText;


    public FetchBookTask(TextView mTitleText, TextView mAuthorText) {
        this.mTitleText = mTitleText;
        this.mAuthorText = mAuthorText;
    }
    @Override
    protected String doInBackground(String... inputString) {
        return NetworkUtils.getBookInfo(inputString[0]);
    }

    @Override
    protected void onPostExecute(String jsonString) {
        super.onPostExecute(jsonString);

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            for(int i = 0; i<itemsArray.length(); i++){
                JSONObject book = itemsArray.getJSONObject(i);
                String title=null;
                String authors=null;
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e){
                    e.printStackTrace();
                }
                if (title != null && authors != null){
                    mTitleText.setText(title);
                    mAuthorText.setText(authors);
                    return;
                }
            }
            mTitleText.setText("No Results Found");
            mAuthorText.setText("");
        } catch (Exception e){
            mTitleText.setText("No Results Found");
            mAuthorText.setText("");
            e.printStackTrace();
        }
    }
}