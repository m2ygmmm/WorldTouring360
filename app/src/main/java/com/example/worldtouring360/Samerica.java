package com.example.worldtouring360;

import androidx.appcompat.app.AppCompatActivity;

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

public class Samerica extends AppCompatActivity {

    public ImageButton homebutton;
    public ImageButton favbutton;
    public ImageButton worldbutton;
    public ImageButton settingbutton;
    public ImageButton infobutton;

    public ImageButton returnbutton;
    public ImageButton returnbutton2;

    public ImageButton Europe;
    public ImageButton africa;
    public ImageButton asia;
    public ImageButton Namerica;
    public ImageButton Samerica;
    public ImageButton australia;

    public ImageButton brazil;
    public ImageButton argentina;
    public ImageButton chile;

    public static String countryName = "";
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samerica);
        navbarmethod();
        sidebarOneMethod();
        TextView worldiconText = (TextView) findViewById(R.id.southAmText);
        worldiconText.setTextColor(Color.WHITE);
        sp = getSharedPreferences("myUserPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Allname", countryName);
        boolean isDark = sp.getBoolean("nightState", true);
        editor.commit();
        if(isDark == true)
        {
            LinearLayout layoutscreen = (LinearLayout) findViewById(R.id.linearLayout);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            Toolbar sidebar = (Toolbar) findViewById(R.id.sidebar);
            Toolbar sidebar1 = (Toolbar) findViewById(R.id.sidebarExtend);
            Toolbar sidebar2 = (Toolbar) findViewById(R.id.sidebarExtend2);
            layoutscreen.setBackgroundColor(getResources().getColor(R.color.darkModeScreen));
            toolbar.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
            sidebar.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
            sidebar1.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
            sidebar2.setBackgroundColor(getResources().getColor(R.color.darkModeToolbar));
        }
    }
    public void sidebarOneMethod(){
        Europe = (ImageButton) findViewById(R.id.europeButton);
        africa = (ImageButton) findViewById(R.id.africaButton);
        asia = (ImageButton) findViewById(R.id.asiaButton);
        australia = (ImageButton) findViewById(R.id.australiaButton);
        Samerica = (ImageButton) findViewById(R.id.southAmButton);
        Namerica = (ImageButton) findViewById(R.id.northAmButton);

        brazil = (ImageButton) findViewById(R.id.brazilButton);
        chile = (ImageButton) findViewById(R.id.chileButton);
        argentina = (ImageButton) findViewById(R.id.argentinaButton);

        returnbutton = (ImageButton) findViewById(R.id.backButton);
        returnbutton2 = (ImageButton) findViewById(R.id.backButton2);

        Europe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEurope();
            }
        });
        africa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAfrica();
            }
        });
        asia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAsia();
            }
        });
        australia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAustralia();
            }
        });
        Samerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSamerica();
            }
        });
        Namerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNamerica();
            }
        });

        brazil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countrySelect();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Allname", "brazil");
                editor.commit();
            }
        });
        argentina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countrySelect();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Allname", "argentina");
                editor.commit();
            }
        });
        chile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countrySelect();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Allname", "chile");
                editor.commit();
            }
        });
        returnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomeAC();
            }
        });
        returnbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorldAC();
                TextView worldiconText = (TextView) findViewById(R.id.worldText);
                worldiconText.setTextColor(Color.WHITE);
            }
        });

    }
    public void openEurope()
    {
        Intent intent = new Intent(this, europe.class);
        startActivity(intent);
    }
    public void openNamerica()
    {
        Intent intent = new Intent(this, Namerica.class);
        startActivity(intent);
    }
    public void openSamerica()
    {
        Intent intent = new Intent(this, Samerica.class);
        startActivity(intent);
    }
    public void openAfrica()
    {
        Intent intent = new Intent(this, africa.class);
        startActivity(intent);
    }
    public void openAsia()
    {
        Intent intent = new Intent(this, asia.class);
        startActivity(intent);
    }
    public void openAustralia() {
        Intent intent = new Intent(this, australia.class);
        startActivity(intent);
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
    }
    public void openfavAC()
    {
        Intent intent = new Intent(this, favpage.class);
        startActivity(intent);
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
    }
    public void openinfoAC()
    {
        Intent intent = new Intent(this, infopage.class);
        startActivity(intent);
    }

    public void countrySelect()
    {
        Intent intent = new Intent(this, countrypage.class);
        startActivity(intent);

    }
}