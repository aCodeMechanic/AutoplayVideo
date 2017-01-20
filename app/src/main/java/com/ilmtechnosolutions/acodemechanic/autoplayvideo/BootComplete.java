package com.ilmtechnosolutions.acodemechanic.autoplayvideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by aCodeMechanic on 15/01/17.
 */
public class BootComplete extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Do your work here.. Call the service. here delay is 10 sec.
        final Context ct = context;
        final Intent service = new Intent(ct, AutoStartUp.class);
        service.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(service);
        Toast.makeText(ct, "BootComplete working!!", Toast.LENGTH_SHORT).show();
    }
}
