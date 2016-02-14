package com.tomoima.concurrentsample;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tomoaki on 2/7/16.
 */
public class TwoTaskWorker {
    private final static String TAG = "TwoTaskWorker";
    private CountDownLatch doneSignal;
    private boolean isTaskRunning = false;

    private static TwoTaskWorker twoTaskWorker = null;
    static {
        twoTaskWorker = new TwoTaskWorker();
    }

    private TwoTaskWorker(){}

    public static TwoTaskWorker getInstance(){
        return twoTaskWorker;
    }

    public void startTask() {
        doneSignal = new CountDownLatch(2);
        if (isTaskRunning) {
            Log.v(TAG, "¥can not run TwoTaskWorker twice!");
            return;
        }
        Log.v(TAG, "¥start run TwoTaskWorker getCountDownLatch " + doneSignal.getCount());
        isTaskRunning = true;
        new Test1(doneSignal).start(1);
        new Test1(doneSignal).start(2);
        try {
            doneSignal.await();
            isTaskRunning = false;
            Log.v(TAG, "¥finished TwoTaskWorker getCountDownLatch " + doneSignal.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
