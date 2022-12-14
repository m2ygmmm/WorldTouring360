package com.example.worldtouring360;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ImageButton homebutton;
    public ImageButton favbutton;
    public ImageButton worldbutton;
    public ImageButton settingbutton;
    public ImageButton infobutton;

    public String isactive ="";
    public String lastAc = "";
    public String randomname = "";

    public settingpage stpage;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isactive = "MainActivity";
        navbarmethod();
        TextView homeiconText = (TextView) findViewById(R.id.HomeText);
        homeiconText.setTextColor(Color.WHITE);
        sp = getSharedPreferences("myUserPref", Context.MODE_PRIVATE);
        boolean isDark = sp.getBoolean("nightState", true);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("worldT", "worldT", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        dailyFact();
        if(isDark == true)
        {
            LinearLayout layoutscreen = (LinearLayout) findViewById(R.id.linearLayout);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            Toolbar sidebar = (Toolbar) findViewById(R.id.sidebar);
            layoutscreen.setBackgroundColor(getResources().getColor(R.color.darkModeScreen));
            toolbar.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
            sidebar.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
        }
    }

    void dailyFact() {
        String[] array = getResources().getStringArray(R.array.randomFact);
        int randomIndex = new Random().nextInt(array.length);
        String randomName = array[randomIndex];
        TextView tv = (TextView) findViewById(R.id.randomFactView);
        tv.setText(randomName);
        sp = getSharedPreferences("mySettings", Context.MODE_PRIVATE);
        boolean isNoti = sp.getBoolean("notiState", false);
        if(isNoti == false)
        {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "worldT")
                    .setSmallIcon(R.drawable.about)
                    .setContentTitle("WorldTouring360")
                    .setContentText(randomName)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationmanager = NotificationManagerCompat.from(this);
            notificationmanager.notify(100, builder.build());
        }
    }

    public void navbarmethod(){
        homebutton = (ImageButton) findViewById(R.id.homeButton);
        favbutton = (ImageButton) findViewById(R.id.favButton);
        worldbutton = (ImageButton) findViewById(R.id.worldButton);
        settingbutton = (ImageButton) findViewById(R.id.settingsButton);
        infobutton = (ImageButton) findViewById(R.id.infoButton);
        homebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openhomeAC();
            }
        });
        favbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openfavAC();
            }
        });
        worldbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {  openWorldAC();
            openWorldAC();
            }
        });
        settingbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opensettingAC();
            }
        });
        infobutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openinfoAC();
            }
        });
        }


    public void openhomeAC()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        isactive = "MainActivity";


    }
    public void openfavAC()
    {
        Intent intent = new Intent(this, favpage.class);
        startActivity(intent);
        isactive = "favpage";

    }
    public void openWorldAC()
    {
        Intent intent = new Intent(this, worldPage.class);
        startActivity(intent);

    }
    public void opensettingAC()
    {
        Intent intent = new Intent(this, settingpage.class);
        startActivity(intent);
        isactive = "settingpage";


    }
    public void openinfoAC()
    {
        Intent intent = new Intent(this, infopage.class);
        startActivity(intent);
        isactive = "infopage";

    }



}

