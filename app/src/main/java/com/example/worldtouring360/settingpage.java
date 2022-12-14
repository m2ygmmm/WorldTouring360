package com.example.worldtouring360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class settingpage extends AppCompatActivity {

    public ImageButton homebutton;
    public ImageButton favbutton;
    public ImageButton worldbutton;
    public ImageButton settingbutton;
    public ImageButton infobutton;
    public static boolean isclear = false;
    public String isactive ="";

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingpage);
        navbarmethod();
        TextView settingiconText = (TextView) findViewById(R.id.settingsText);
        settingiconText.setTextColor(Color.WHITE);
        Button closebtn = (Button) findViewById(R.id.quitButton);
        Button clearbtn = (Button) findViewById(R.id.clearButton);
        Switch soundSwitch = (Switch) findViewById(R.id.soundswitch);
        Switch notiSwitch = (Switch) findViewById(R.id.notiSwitch);
        Switch nightSwitch = (Switch) findViewById(R.id.nightSwitch);
        sp = getSharedPreferences("myUserPref", Context.MODE_PRIVATE);
        boolean isSound = sp.getBoolean("soundState", false);
        boolean isNoti = sp.getBoolean("notiState", false);
        boolean isDark = sp.getBoolean("nightState", true);
        notiSwitch.setChecked(isNoti);
        soundSwitch.setChecked(isSound);
        nightSwitch.setChecked(isDark);
        if(isDark == true)
        {
            LinearLayout layoutscreen = (LinearLayout) findViewById(R.id.linearLayout);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            Toolbar sidebar = (Toolbar) findViewById(R.id.sidebar);
            layoutscreen.setBackgroundColor(getResources().getColor(R.color.darkModeScreen));
            toolbar.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
            sidebar.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
        }
        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("soundState", isChecked);
                    editor.commit();
                    Toast.makeText(settingpage.this, "Sound off", Toast.LENGTH_LONG).show();
                }
                else
                {
                    AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("soundState", isChecked);
                    editor.commit();
                    Toast.makeText(settingpage.this, "Sound on", Toast.LENGTH_LONG).show();
                }
            }
        });
        notiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("notiState", isChecked);
                    editor.commit();
                    Toast.makeText(settingpage.this, "Notifications off", Toast.LENGTH_LONG).show();
                }
                else
                {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("notiState", isChecked);
                    editor.commit();
                    Toast.makeText(settingpage.this, "Notifications on", Toast.LENGTH_LONG).show();
                }
            }
        });
        nightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    LinearLayout layoutscreen = (LinearLayout) findViewById(R.id.linearLayout);
                    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                    Toolbar sidebar = (Toolbar) findViewById(R.id.sidebar);
                    layoutscreen.setBackgroundColor(getResources().getColor(R.color.darkModeScreen));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
                    sidebar.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("nightState", isChecked);
                    editor.commit();
                    Toast.makeText(settingpage.this, "Night mode on", Toast.LENGTH_LONG).show();
                }
                else
                {
                    LinearLayout layoutscreen = (LinearLayout) findViewById(R.id.linearLayout);
                    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                    Toolbar sidebar = (Toolbar) findViewById(R.id.sidebar);
                    layoutscreen.setBackgroundColor(getResources().getColor(R.color.defaultScreen));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.defaultToolbar));
                    sidebar.setBackgroundColor(getResources().getColor(R.color.defaultToolbar));
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("nightState", isChecked);
                    editor.commit();
                    Toast.makeText(settingpage.this, "Night mode Off", Toast.LENGTH_LONG).show();
                }
            }
        });
        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(settingpage.this, "Data cleared!", Toast.LENGTH_LONG).show();
                isclear = true;
            }
        });
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

