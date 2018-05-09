package com.example.hp1.fairuz;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // ta3rif motaghayirat
    Button wiki, cinema, nas, lyr, urshalim;

    // ta3rif motaghayirat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setNotification();
        wiki = (Button) findViewById(R.id.button);
        wiki.setOnClickListener((View.OnClickListener) this);
        cinema = (Button) findViewById(R.id.button2);
        cinema.setOnClickListener((View.OnClickListener) this);
        nas = (Button) findViewById(R.id.button3);
        nas.setOnClickListener((View.OnClickListener) this);
        lyr = (Button) findViewById(R.id.button4);
        lyr.setOnClickListener((View.OnClickListener) this);
        urshalim = (Button) findViewById(R.id.button6);
        urshalim.setOnClickListener((View.OnClickListener) this);
    }
     // pe3ola larabet ailkabasat ma3 ailsaf7at
    @Override
    public void onClick(View view) {
        if (view == wiki) {
            Intent i = new Intent(MainActivity.this, Info.class);
            startActivity(i);
        }
        if (view == cinema) {
            Intent x = new Intent(MainActivity.this, Acts.class);
            startActivity(x);
        }
        if (view == nas) {
            Intent a = new Intent(MainActivity.this, Video.class);
            startActivity(a);
        }
        if (view == lyr) {
            Intent b = new Intent(MainActivity.this, Lyrics.class);
            startActivity(b);
        }
        if (view == urshalim) {
            Intent d = new Intent(MainActivity.this, User.class);
            startActivity(d);
        }
    }

    public void setNotification() {//delay is after how much time(in millis) from current time you want to schedule the notification

        Intent intent1 = new Intent(MainActivity.this, Notifacation.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+5000, 1000*60*24, pendingIntent);


    }
}
