package com.ilmtechnosolutions.acodemechanic.autoplayvideo;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.File;


/**
 * Created by aCodeMechanic on 15/01/17.
 */
public class AutoStartUp extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Log.i("....AutoStartup.....", "In ... onStartCommand");
        //Toast.makeText(this, "onStartCommand Running", Toast.LENGTH_SHORT).show();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        Log.i("Service Status", "Started");
        // do something when the service is created
        String pathtoimage = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/mov_new.mp4";
        File file = new File(pathtoimage);
        if (file.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(MediaStore.EXTRA_FINISH_ON_COMPLETION, true);
            intent.setDataAndType(Uri.fromFile(file), "video/*");
            startActivity(intent);
        }
    }
}
