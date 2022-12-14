package com.example.worldtouring360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.gson.Gson;

import java.util.HashSet;
import org.w3c.dom.Text;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class countrypage extends AppCompatActivity {

    public ImageButton homebutton;
    public ImageButton favbutton;
    public ImageButton worldbutton;
    public ImageButton settingbutton;
    public ImageButton infobutton;

    public String newcnName;

    public ImageButton starBtn;

    public TextView addedfav;

    public int imgpos = 0;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrypage);
        navbarmethod();
        TextView worldtext = (TextView) findViewById(R.id.worldText);
        worldtext.setTextColor(Color.WHITE);
        sp = getSharedPreferences("myUserPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String cname = sp.getString("Allname", "");
        newcnName = cname;
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
        switch (cname) {
            case ("Newzealand"):
                ImageView cnflag = (ImageView) findViewById(R.id.flag);
                ImageView imagescroll = (ImageView) findViewById(R.id.imagescroller);
                TextView cntext = (TextView) findViewById(R.id.countryName);
                TextView cnInfotext = (TextView) findViewById(R.id.countryinfo);
                TextView cnpoptext = (TextView) findViewById(R.id.pop);
                TextView cnlantext = (TextView) findViewById(R.id.lan);
                TextView cncaptext = (TextView) findViewById(R.id.cap);
                ImageButton nextimage = (ImageButton) findViewById(R.id.nextImage);
                String cntextfile = getResources().getString(R.string.Newzealand);
                String cninfotextfile = getResources().getString(R.string.newzealandnfo);
                String cnpop = getResources().getString(R.string.Newzealandopulation);
                String cncap = getResources().getString(R.string.Newzealandacapital);
                String cnlan = getResources().getString(R.string.Newzealandlanguage);
                cnflag.setImageResource(R.drawable.newzealand);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                int[] images = {R.drawable.newzeland1, R.drawable.newzeland2, R.drawable.newzeland3, R.drawable.newzeland4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("australia"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Australia);
                cninfotextfile = getResources().getString(R.string.Australianfo);
                cnpop = getResources().getString(R.string.australiapopulation);
                cncap = getResources().getString(R.string.australiacapital);
                cnlan = getResources().getString(R.string.australialanguage);
                cnflag.setImageResource(R.drawable.australiaflag);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.australia1, R.drawable.australia2, R.drawable.australia3, R.drawable.australia4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("indonesia"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.indonesia);
                cninfotextfile = getResources().getString(R.string.indonesianfo);
                cnpop = getResources().getString(R.string.indonesiapopulation);
                cncap = getResources().getString(R.string.indonesiacapital);
                cnlan = getResources().getString(R.string.indonesialanguage);
                cnflag.setImageResource(R.drawable.indonesia);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                images = new int[]{R.drawable.indonesia1, R.drawable.indonesia2, R.drawable.indonesia3, R.drawable.indonesia4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("russia"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Russia);
                cninfotextfile = getResources().getString(R.string.Russianfo);
                cnpop = getResources().getString(R.string.russiaopulation);
                cncap = getResources().getString(R.string.russiacapital);
                cnlan = getResources().getString(R.string.russialanguage);
                cnflag.setImageResource(R.drawable.russia);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.russia1, R.drawable.russia2, R.drawable.russia3, R.drawable.russia4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("china"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.China);
                cninfotextfile = getResources().getString(R.string.chinanfo);
                cnpop = getResources().getString(R.string.chinapopulation);
                cncap = getResources().getString(R.string.chinacapital);
                cnlan = getResources().getString(R.string.chinalanguage);
                cnflag.setImageResource(R.drawable.china);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.china1, R.drawable.china2, R.drawable.china3, R.drawable.china4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("southafrica"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Southafrica);
                cninfotextfile = getResources().getString(R.string.Southafricalnfo);
                cnpop = getResources().getString(R.string.safricapopulation);
                cncap = getResources().getString(R.string.safricacapital);
                cnlan = getResources().getString(R.string.safricalanguage);
                cnflag.setImageResource(R.drawable.southafrica);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                images = new int[]{R.drawable.southafrica1, R.drawable.southafrica2, R.drawable.southafrica3, R.drawable.southafrica4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("algeria"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Algeria);
                cninfotextfile = getResources().getString(R.string.Algerianfo);
                cnpop = getResources().getString(R.string.algeriaopulation);
                cncap = getResources().getString(R.string.algeriacapital);
                cnlan = getResources().getString(R.string.algerialanguage);
                cnflag.setImageResource(R.drawable.algeria);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.algeria1, R.drawable.algeria2, R.drawable.algeria3, R.drawable.algeria4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("egypt"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Egypt);
                cninfotextfile = getResources().getString(R.string.egyptnfo);
                cnpop = getResources().getString(R.string.egyptpopulation);
                cncap = getResources().getString(R.string.egyptcapital);
                cnlan = getResources().getString(R.string.egyptlanguage);
                cnflag.setImageResource(R.drawable.egypt);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                newcnName = cname;
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.egypt1, R.drawable.egypt2, R.drawable.egypt3, R.drawable.egypt4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case("brazil"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Brazil);
                cninfotextfile = getResources().getString(R.string.Brazilnfo);
                cnpop = getResources().getString(R.string.brazilpopulation);
                cncap = getResources().getString(R.string.brazilcapital);
                cnlan = getResources().getString(R.string.brazillanguage);
                cnflag.setImageResource(R.drawable.brazil);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                images = new int[]{R.drawable.brazil1, R.drawable.brazil2, R.drawable.brazil3, R.drawable.brazil4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("argentina"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Argentina);
                cninfotextfile = getResources().getString(R.string.Argentinanfo);
                cnpop = getResources().getString(R.string.argentinapopulation);
                cncap = getResources().getString(R.string.argentinacapital);
                cnlan = getResources().getString(R.string.argentinalanguage);
                cnflag.setImageResource(R.drawable.argentina);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.argentina1, R.drawable.argentina2, R.drawable.argentina3, R.drawable.argentina4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("chile"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Chile);
                cninfotextfile = getResources().getString(R.string.Chilenfo);
                cnpop = getResources().getString(R.string.chilepopulation);
                cncap = getResources().getString(R.string.chilecapital);
                cnlan = getResources().getString(R.string.chilelanguage);
                cnflag.setImageResource(R.drawable.chile);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.chile1, R.drawable.chile2, R.drawable.chile3, R.drawable.chile4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("usa"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Usa);
                cninfotextfile = getResources().getString(R.string.UsaInfo);
                cnpop = getResources().getString(R.string.usapopulation);
                cncap = getResources().getString(R.string.usacapital);
                cnlan = getResources().getString(R.string.usalanguage);
                cnflag.setImageResource(R.drawable.usa);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                images = new int[]{R.drawable.usa1, R.drawable.usa2, R.drawable.usa3, R.drawable.usa4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("mexico"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Mexico);
                cninfotextfile = getResources().getString(R.string.MexicoInfo);
                cnpop = getResources().getString(R.string.mexicopopulation);
                cncap = getResources().getString(R.string.mexicocapital);
                cnlan = getResources().getString(R.string.mexicolanguage);
                cnflag.setImageResource(R.drawable.mexico);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.mexico1, R.drawable.mexico2, R.drawable.mexico3, R.drawable.mexico4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("canada"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Canada);
                cninfotextfile = getResources().getString(R.string.Canadanfo);
                cnpop = getResources().getString(R.string.canadapopulation);
                cncap = getResources().getString(R.string.canadacapital);
                cnlan = getResources().getString(R.string.canadalanguage);
                cnflag.setImageResource(R.drawable.canadaflag);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.canada1, R.drawable.canada2, R.drawable.canada3, R.drawable.canada4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("france"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.France);
                cninfotextfile = getResources().getString(R.string.FranceInfo);
                cnpop = getResources().getString(R.string.francepopulation);
                cncap = getResources().getString(R.string.francecapital);
                cnlan = getResources().getString(R.string.francelanguage);
                cnflag.setImageResource(R.drawable.france);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                images = new int[]{R.drawable.france1, R.drawable.france2, R.drawable.france3, R.drawable.france4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("germany"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Germany);
                cninfotextfile = getResources().getString(R.string.GermanyInfo);
                cnpop = getResources().getString(R.string.germanypopulation);
                cncap = getResources().getString(R.string.germanycapital);
                cnlan = getResources().getString(R.string.germanylanguage);
                cnflag.setImageResource(R.drawable.germany);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.germany1, R.drawable.germany2, R.drawable.germany3, R.drawable.germany4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("england"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.England);
                cninfotextfile = getResources().getString(R.string.EnglandInfo);
                cnpop = getResources().getString(R.string.englandpopulation);
                cncap = getResources().getString(R.string.englandcapital);
                cnlan = getResources().getString(R.string.englandlanguage);
                cnflag.setImageResource(R.drawable.england);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.england1, R.drawable.england2, R.drawable.england3, R.drawable.england4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });

                break;
            case ("italy"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Italy);
                cninfotextfile = getResources().getString(R.string.ItalyInfo);
                cnpop = getResources().getString(R.string.italypopulation);
                cncap = getResources().getString(R.string.italycapital);
                cnlan = getResources().getString(R.string.italylanguage);
                cnflag.setImageResource(R.drawable.italy);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.italy1, R.drawable.italy2, R.drawable.italy3, R.drawable.italy4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("spain"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Spain);
                cninfotextfile = getResources().getString(R.string.SpainInfo);
                cnpop = getResources().getString(R.string.spainpopulation);
                cncap = getResources().getString(R.string.spaincapital);
                cnlan = getResources().getString(R.string.spainlanguage);
                cnflag.setImageResource(R.drawable.spain);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.spain1, R.drawable.spain2, R.drawable.spain3, R.drawable.spain4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
            case ("norway"):
                cnflag = (ImageView) findViewById(R.id.flag);
                imagescroll = (ImageView) findViewById(R.id.imagescroller);
                cntext = (TextView) findViewById(R.id.countryName);
                cnInfotext = (TextView) findViewById(R.id.countryinfo);
                cnpoptext = (TextView) findViewById(R.id.pop);
                cnlantext = (TextView) findViewById(R.id.lan);
                cncaptext = (TextView) findViewById(R.id.cap);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                nextimage = (ImageButton) findViewById(R.id.nextImage);
                cntextfile = getResources().getString(R.string.Norway);
                cninfotextfile = getResources().getString(R.string.NorwayInfo);
                cnpop = getResources().getString(R.string.norwaypopulation);
                cncap = getResources().getString(R.string.norwaycapital);
                cnlan = getResources().getString(R.string.norwaylanguage);
                cnflag.setImageResource(R.drawable.norway);
                cntext.setText(cntextfile);
                cnInfotext.setText(cninfotextfile);
                cncaptext.setText(cncap);
                cnlantext.setText(cnlan);
                cnpoptext.setText(cnpop);
                starBtn = (ImageButton) findViewById(R.id.starbtn);
                addedfav = (TextView) findViewById(R.id.addtofavtext);
                images = new int[]{R.drawable.norway1, R.drawable.norway2, R.drawable.norway3, R.drawable.norway4};
                imagescroll.setImageResource(images[imgpos]);
                nextimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imagescroll.setImageResource(images[imgpos++]);
                        if (images.length <= imgpos) {
                            imgpos = 0;
                        }
                    }
                });
                break;
        }
        ImageButton starBtn = (ImageButton) findViewById(R.id.starbtn);
        TextView addedfav = (TextView) findViewById(R.id.addtofavtext);
        starBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starBtn.setImageResource(R.drawable.yellowstar);
                String newtext = "Added!";
                addedfav.setText(newtext);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("cnName", newcnName);
                editor.commit();
                Toast.makeText(countrypage.this, "Saved!", Toast.LENGTH_SHORT).show();
            }
        });
        String favCn = sp.getString("cnName", "");
        if (favCn == newcnName)
        {
            starBtn.setImageResource(R.drawable.yellowstar);
            String newtext = "Added!";
            addedfav.setText(newtext);
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
            public void onClick(View v) {
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



}