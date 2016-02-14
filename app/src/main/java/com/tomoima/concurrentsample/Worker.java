package com.tomoima.concurrentsample;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

/**
 * Created by tomoaki on 2/4/16.
 */
public class Worker implements Runnable {
    private final static String TAG = "worker";
    private final CountDownLatch doneSignal;
    private final int num;
    public Worker(int num,CountDownLatch countDownLatch){
        doneSignal = countDownLatch;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.v(TAG, "¥Thread worker is now: " + Thread.currentThread().getName());
        //new Test1().start(num);
        doneSignal.countDown();
    }
}
