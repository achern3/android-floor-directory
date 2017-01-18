package com.alanchern.floordirectory;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by alanchern on 1/13/17.
 */

public class RestartActivity extends AppCompatActivity {
    private static final String ERROR_MESSAGE = "error_message";
    private static final String RESTART_KEY = "restart_key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String error = getIntent().getExtras().getString(ERROR_MESSAGE);
        if (error != null) {
            Log.e("APP CRASHED", error);
        }

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Recovering from crash...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }

    @Override
    protected void onStop() {
        super.onStop();

        finish();
    }
}
