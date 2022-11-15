package com.example.alarm_clock_implementation_de_service;

import android.app.Service;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

import java.net.URI;

public class MyService extends Service {

    Uri uri ;
    Ringtone ringtone ;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this,"alarm created",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"alarm started",Toast.LENGTH_LONG).show();
      uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
      ringtone = RingtoneManager.getRingtone(this,uri);
        ringtone.play();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        ringtone.stop();

        Toast.makeText(this,"alarm stopped",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }
}