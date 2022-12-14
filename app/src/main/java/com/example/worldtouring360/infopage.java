package com.example.worldtouring360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.worldtouring360.BuildConfig;

import com.google.android.material.shape.MaterialShapeDrawable;

public class infopage extends AppCompatActivity {

    public ImageButton homebutton;
    public ImageButton favbutton;
    public ImageButton worldbutton;
    public ImageButton settingbutton;
    public ImageButton infobutton;

    public String isactive ="";
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopage);
        navbarmethod();
        //TextView textView = findViewById(R.id.appinfotitle);
        //MaterialShapeDrawable shapeDrawable = new MaterialShapeDrawable();
        //shapeDrawable.setFillColor(ContextCompat.getColorStateList(this,android.R.color.transparent));
        //shapeDrawable.setStroke(2.0f, ContextCompat.getColor(this,R.color.black));
        //ViewCompat.setBackground(textView,shapeDrawable);
        String versionCode = BuildConfig.VERSION_NAME;
        String appname = BuildConfig.APPLICATION_ID;
        TextView versionnum = (TextView) findViewById(R.id.version);
        versionnum.setText(versionCode);
        TextView appID = (TextView) findViewById(R.id.appname);
        appID.setText(appname);
        TextView infoiconText = (TextView) findViewById(R.id.infoText);
        infoiconText.setTextColor(Color.WHITE);
        sp = getSharedPreferences("myUserPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        boolean isDark = sp.getBoolean("nightState", true);
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

