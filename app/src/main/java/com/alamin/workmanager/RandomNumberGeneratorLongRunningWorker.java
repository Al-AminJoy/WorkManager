package com.alamin.workmanager;

import android.app.Notification;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.ForegroundInfo;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.Random;

public class RandomNumberGeneratorLongRunningWorker extends Worker {
    private static final String TAG = "RandomNumberGeneratorWorker" ;
    Context context;
    WorkerParameters workerParameters;

    private int mRandomNumber;
    private boolean isRandomNumberGeneratorOn;
    private final int MIN=0;
    private final int MAX=100;
    MyAppsNotificationManager myAppsNotificationManager;

    public RandomNumberGeneratorLongRunningWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context=context;
        this.workerParameters=workerParams;
        isRandomNumberGeneratorOn=true;
        myAppsNotificationManager= MyAppsNotificationManager.getInstance(context);
    }

    private void startRandomNumberGenerator(){
        int i=0;
        while (i<5 && !isStopped()){
            try {
                Thread.sleep(1000);
                if (isRandomNumberGeneratorOn){
                    mRandomNumber=new Random().nextInt(MAX)+MIN;
                    Log.d(TAG, "startRandomNumberGenerator: "+mRandomNumber);
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
        setForegroundAsync(createForegroundInfo("Random Counter"));
        startRandomNumberGenerator();
        return Result.success();
    }

    @Override
    public void onStopped() {
        super.onStopped();
    }

    private ForegroundInfo createForegroundInfo(String message){
        Notification notification=myAppsNotificationManager.getNotification(
                MainActivity.class,
                message,
                1,
                false,
                10
        );
        return new ForegroundInfo(10,notification);
    }
}
