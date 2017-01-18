package com.alanchern.floordirectory;

import android.app.Application;
import android.content.Intent;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by alanchern on 1/12/17.
 */

public class App extends Application {
    private static final String RESTART_ACTIVITY = "com.alanchern.floordirectory.RESTART_ACTIVITY";
    private static final String ERROR_MESSAGE = "error_message";

    @Override
    public void onCreate() {
        super.onCreate();

        Iconify.with(new FontAwesomeModule());

        /*Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                restartApp(e);
            }
        });*/
    }

    private void restartApp(Throwable e) {
        Intent intent = new Intent();
        intent.setAction(RESTART_ACTIVITY);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // required when starting from Application
        intent.putExtra(ERROR_MESSAGE, e.toString());
        startActivity(intent);

        System.exit(1); // kill off the crashed app
    }
}
