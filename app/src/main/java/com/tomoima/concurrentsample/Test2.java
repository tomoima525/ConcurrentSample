package com.tomoima.concurrentsample;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

/**
 * Created by tomoaki on 2/14/16.
 */
public class Test2 implements Runnable {
    private final static String TAG = Test2.class.getSimpleName();
    private final CountDownLatch doneSignal;
    private String params;
    public Test2(CountDownLatch doneSignal, String params){
        this.doneSignal = doneSignal;
        this.params = params;
    }
    @Override
    public void run() {
        try {
            Log.v(TAG, "¥Thread test(" + params + "):" + Thread.currentThread().getName() + " start");
            sleep(2000);
            Log.v(TAG, "¥Thread test(" + params + "):" + Thread.currentThread().getName() + " done");
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
