package com.tomoima.concurrentsample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BaseLoader using threadExecutorService
 * @param <T>
 */
public abstract class BaseLoader<T> {
    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    public void start(final T params){
        mExecutor.submit(new Runnable() {
            @Override
            public void run() {
                call(params);
            }
        });
//        mExecutor.shutdown();
//        while (!mExecutor.isTerminated()){
//
//        }
    }

    abstract protected void call(T params);
}
