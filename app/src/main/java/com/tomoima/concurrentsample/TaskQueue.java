package com.tomoima.concurrentsample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tomoaki on 2/6/16.
 */
public class TaskQueue {

    private final ThreadPoolExecutor threadPoolExecutor;
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_TIME = 1;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final BlockingQueue<Runnable> poolWorkQueue;

    private static TaskQueue sInstance = null;

    static {
        sInstance = new TaskQueue();
    }

    public static TaskQueue getInstance() {
        return sInstance;
    }

    private TaskQueue(){
        poolWorkQueue = new LinkedBlockingQueue<>();
        threadPoolExecutor = new ThreadPoolExecutor(
                NUMBER_OF_CORES,
                NUMBER_OF_CORES,
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                poolWorkQueue
        );
    }

    public void startTask(Runnable task){
        threadPoolExecutor.execute(task);
    }


}
