package com.example.rahmetex1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Handler handler;
    private int progressStatus;
    private ProgressBarActivity ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        ref = this;

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        handler = new Handler();

        startProgress();
    }

    public void startProgress() {
        progressStatus = 0;
        progressBar.setProgress(progressStatus);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(final Void... param) {
                while (progressStatus < 100) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ++progressStatus;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                }
                Log.d("MyLogs", "Here i can go forward");
                Intent intent = new Intent(ref, BooksListActivity.class);
                startActivity(intent);
                return null;

            }
        }.execute();
    }

}
