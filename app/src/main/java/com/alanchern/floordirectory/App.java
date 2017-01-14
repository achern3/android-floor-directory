package com.alanchern.floordirectory;

import android.app.Application;
import android.content.Intent;

/**
 * Created by alanchern on 1/12/17.
 */

public class App extends Application {
    private static final String RESTART_ACTIVITY = "com.alanchern.floordirectory.RESTART_ACTIVITY";

    @Override
    public void onCreate() {
        super.onCreate();

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException (Thread thread, final Throwable e) {
                restartApp();
            }
        });
    }

    private void restartApp() {
        Intent intent = new Intent();
        intent.setAction(RESTART_ACTIVITY);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // required when starting from Application
        startActivity(intent);

        System.exit(1); // kill off the crashed app
    }
}
