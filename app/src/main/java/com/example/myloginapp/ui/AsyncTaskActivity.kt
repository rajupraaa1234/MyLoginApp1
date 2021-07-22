package com.example.myloginapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.example.myloginapp.DownloadInBackGround
import com.example.myloginapp.R

class AsyncTaskActivity : AppCompatActivity() {

    lateinit var progressbar : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        progressbar = findViewById(R.id.progressbar)

    }

    private fun simulateProgress(){
        Thread.sleep(100)
        for(i in 1..100){
            progressbar.setProgress(i)
        }
    }

    fun AsnkClickHandler(view: View){
        when(view.id){
            R.id.probtn->startDownload();
        }
    }

    private fun startDownload() {
        var download : DownloadInBackGround = DownloadInBackGround(progressbar)
        download.execute("https//download");
    }
}