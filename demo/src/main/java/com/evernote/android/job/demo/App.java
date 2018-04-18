package com.evernote.android.job.demo;

import android.app.Application;
import android.util.Log;

import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.facebook.stetho.Stetho;

import java.util.Set;

/**
 * @author rwondratschek
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        JobManager.create(this).addJobCreator(new DemoJobCreator());

        Set<JobRequest> jobRequests = JobManager.instance().getAllJobRequests();
        if(jobRequests != null){
            Log.d("danxx","dataBase Size :" + jobRequests.size());
        }
    }
}

