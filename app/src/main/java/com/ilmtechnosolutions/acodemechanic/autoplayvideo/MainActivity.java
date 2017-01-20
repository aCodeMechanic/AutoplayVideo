package com.ilmtechnosolutions.acodemechanic.autoplayvideo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    String SERVICE = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (isMyServiceRunning(AutoStartUp.class)) {
            stopService(new Intent(MainActivity.this,AutoStartUp.class));
            ;
        }
        Intent serviceIntent = new Intent(MainActivity.this, AutoStartUp.class);
        MainActivity.this.startService(serviceIntent);
        finish();
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                SERVICE = service.service.getClassName();
                return true;
            }
        }
        return false;
    }
}
