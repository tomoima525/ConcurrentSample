package com.tomoima.concurrentsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
//    private static final int NUM = 3;
//    CountDownLatch doneSignal = new CountDownLatch(NUM);
//    boolean isRunning = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "¥start");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (isRunning) {
//                    try {
//                        sleep(100);
//                        Log.v(TAG, "¥ running: " + Thread.currentThread().getName());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        //TwoTaskWorker.getInstance().startTask();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.v(TAG, "¥second TwoTask");
//                TwoTaskWorker.getInstance().startTask();
//            }
//        }).start();
//        new Test1(doneSignal).start(1);
//        new Test1(doneSignal).start(2);
//        new Test1(doneSignal).start(3);

//        for(int i = 0; i<NUM; i++) {
//            new Thread(new Worker(i, doneSignal)).start();
//        }


//        try {
//            doneSignal.await();
//            isRunning = false;
//            Log.v(TAG, "¥done");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void startTask(View view){
        Log.v(TAG, "¥¥startTask");
        new Thread(new Runnable() {
            @Override
            public void run() {
                TwoTaskWorker.getInstance().startTask();
            }
        }).start();

    }
}
