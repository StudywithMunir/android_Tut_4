package com.example.android_tut_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;


//Flow
//1. first onCreate method runs and activity_2 runs for 5sec
//2. then MainActivity Opens up and our activity_2 is on onPause() state
//3. We are calling finish() method in onPause() so when our MainActivity runs activity_2 kills itself


public class activity_2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Thread timer = new Thread() {

            public void run() {

                try {
                    sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent OpenStartingActivity = new Intent("com.example.android_tut_4.MainActivity");
                    startActivity(OpenStartingActivity);
                }


            }

        };
        timer.start();

    }

    //onCreate, onResume(), and onPause() are most used methods in mostly cases
    //so we are making splash activity to kill itself by onPause() method
    //same procedure to create onPause() method like onCreate
    //Press Ctrl+O to insert OnPause method through method list


    @Override
    protected void onPause() {
        super.onPause();

        //using finish method to get rid of activity_2 and it will be destroyed forever util user runs application again
        finish();

    }
}
