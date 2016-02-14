package com.tomoima.concurrentsample;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

/**
 * Created by tomoaki on 2/4/16.
 */
public class Test1 extends BaseLoader<Integer> {
    private final static String TAG = BaseLoader.class.getSimpleName();
    private final CountDownLatch doneSignal;
    public Test1(CountDownLatch doneSignal){

        this.doneSignal = doneSignal;
    }
    @Override
    protected void call(Integer params) {
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
