package com.example.myloginapp;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

public class DownloadInBackGround extends AsyncTask<String, Integer, Void> {
    public String TAG = DownloadInBackGround.class.getSimpleName();
    private ProgressBar progressbar;
    public DownloadInBackGround(ProgressBar pro){
        progressbar = pro;
    }

    @Override
    protected Void doInBackground(String... strings) {
        for(int i=0;i<100;i++){
            try{
                publishProgress(i);
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressbar.setProgress(values[0]);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        progressbar.setVisibility(View.GONE);
    }
}
