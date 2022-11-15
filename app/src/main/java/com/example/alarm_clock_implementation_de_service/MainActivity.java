package com.example.alarm_clock_implementation_de_service;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText hours,minuts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hours = (EditText) findViewById(R.id.hours);
        minuts = (EditText) findViewById(R.id.minuts);
    }

    public void setAlarm(View view) {

        Toast.makeText(this,"Alarm set",Toast.LENGTH_LONG).show();

       Intent it = new Intent(this,MyService.class);
//       startService(it);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
     PendingIntent pendingIntent = PendingIntent.getService(this,0,it,PendingIntent.FLAG_MUTABLE);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours.getText().toString()));
        calendar.set(Calendar.MINUTE,Integer.parseInt(minuts.getText().toString()));
        calendar.set(Calendar.SECOND,00);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),0,pendingIntent);

    }

    public void cancelAlarm(View view) {
        Intent it = new Intent(this,MyService.class);
        stopService(it);

    }
}