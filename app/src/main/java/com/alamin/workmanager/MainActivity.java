package com.alamin.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btStart,btStop;
    private TextView tvThreadCounter;
    private WorkManager workManager;
    private WorkRequest workRequest;
    private OneTimeWorkRequest workRequest1,workRequest2,workRequest3;
    private boolean mStopLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStart=findViewById(R.id.bt_start);
        btStop=findViewById(R.id.bt_stop);
        tvThreadCounter=findViewById(R.id.tv_thread_counter);

        //workManager=WorkManager.getInstance(this);
       // workRequest=new PeriodicWorkRequest.Builder(RandomNumberGeneratorWorker.class,15, TimeUnit.MINUTES).build();

      /*  workRequest1=new OneTimeWorkRequest.Builder(RandomNumberGeneratorWorker1.class).addTag("worker1").build();
        workRequest2=new OneTimeWorkRequest.Builder(RandomNumberGeneratorWorker2.class).addTag("worker2").build();
        workRequest3=new OneTimeWorkRequest.Builder(RandomNumberGeneratorWorker3.class).addTag("worker3").build();
        workManager=WorkManager.getInstance(this);*/

        workManager=WorkManager.getInstance(this);
       // workRequest=OneTimeWorkRequest.from(RandomNumberGeneratorLongRunningWorker.class);
        btStart.setOnClickListener(this);
        btStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bt_start){
            //workManager.enqueue(workRequest);
            mStopLoop=true;
            //workManager.beginWith(Arrays.asList(workRequest1,workRequest2)).then(workRequest3).enqueue();
           // workManager.enqueue(workRequest);
        }
        else if(v.getId()==R.id.bt_stop){
            //workManager.cancelWorkById(workRequest.getId());
            //workManager.cancelAllWorkByTag("work3");
           // workManager.cancelWorkById(workRequest.getId());

        }
    }
}