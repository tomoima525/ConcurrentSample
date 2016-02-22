package com.tomoima.concurrentsample;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tomoaki on 2/14/16.
 */
public class TwoTaskWorker2 extends Thread {
    private CountDownLatch doneSignal;
    private final static String TAG = TwoTaskWorker2.class.getSimpleName();
    public TwoTaskWorker2(){
        doneSignal = new CountDownLatch(2);
    }

    @Override
    public void run() {
        TaskQueue queue = TaskQueue.getInstance();
        queue.startTask(new Test2(doneSignal,"1"));
        queue.startTask(new Test2(doneSignal,"2"));
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.v(TAG, "¥finished TwoTaskWorker getCountDownLatch ");
    }
}
