package com.alamin.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.Random;

public class RandomNumberGeneratorWorker2 extends Worker {
    private static final String TAG = "RandomNumberGeneratorWorker" ;
    Context context;
    WorkerParameters workerParameters;

    private int mRandomNumber;
    private boolean isRandomNumberGeneratorOn;
    private final int MIN=0;
    private final int MAX=100;

    public RandomNumberGeneratorWorker2(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context=context;
        this.workerParameters=workerParams;
        isRandomNumberGeneratorOn=true;
    }

    private void startRandomNumberGenerator(){
        int i=0;
        while (i<5 && !isStopped()){
            try {
                Thread.sleep(1000);
                if (isRandomNumberGeneratorOn){
                    mRandomNumber=new Random().nextInt(MAX)+MIN;
                    Log.d(TAG, "work 2"+mRandomNumber);
                    i++;

                }
            }
            catch (Exception e){

            }
        }
    }

    @NonNull
    @Override
    public Result doWork() {
        startRandomNumberGenerator();
        return Result.success();
    }

    @Override
    public void onStopped() {
        super.onStopped();
    }
}
