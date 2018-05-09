package com.example.hp1.fairuz;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lyrics extends AppCompatActivity implements AdapterView.OnItemClickListener{

    InputStream is=null;
    InputStreamReader in;
    BufferedReader br;

    //parameters for file reading used in both methods
    String temp="", all="";
    int num;
    Intent i,j,o,w,s,c;
    ListView word;
    ArrayAdapter<String>lyr;
    ArrayList<String> lib= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        lib.add("بكتب اسمك يا حبيبي");
        lib.add("انا لحبيبي");
        lib.add("لبيروت");
        lib.add("كيفك انت");
        lib.add("زهرة المدائن");
        lib.add("اعطني الناي");
        lib.add("وحدن");
        lib.add("بعدك على بالي");
        lib.add(" عودك رنان");
        lib.add("حبيتك");
        lib.add("اشتقتلك");

        word= (ListView)findViewById(R.id.lv);
        lyr= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lib);
        word.setAdapter(lyr);
        word.setOnItemClickListener(this);

    }

    // mola2ami bein il item wil kitabi
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent x = new Intent(this, LyricsActivity.class);

        if(i==0){
            x.putExtra("lyrics",R.raw.bakteb);
            startActivity(x);
        }
       if(i==1){
           x.putExtra("lyrics",R.raw.ana);
            startActivity(x);

        }
        if(i==2){
            x.putExtra("lyrics",R.raw.beirut);
            startActivity(x);

        }
        if(i==3){
            x.putExtra("lyrics",R.raw.kifak);
            startActivity(x);

        }
        if(i==4){
            x.putExtra("lyrics",R.raw.zahra);
            startActivity(x);

        }
        if(i==5){
            x.putExtra("lyrics",R.raw.nay);
            startActivity(x);

        }
        if(i==6){
            x.putExtra("lyrics",R.raw.wahdon);
            startActivity(x);

        }
        if(i==7){
            x.putExtra("lyrics",R.raw.bali);
            startActivity(x);


        }
        if(i==8){
            x.putExtra("lyrics",R.raw.aud);
            startActivity(x);

        }
        if(i==9){
            x.putExtra("lyrics",R.raw.habaytak);
            startActivity(x);

        }
        if(i==10) {
            x.putExtra("lyrics",R.raw.shtaqet);
            startActivity(x);
        }

    }




    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {// the code that tells every option in the menu what to do
            alertBuilder();

        }
        if (item.getItemId() == R.id.item2) {

            Intent j = new Intent(this, Info.class);

            startActivity(j);
            finish();
        }
        if (item.getItemId() == R.id.item3) {

            Intent o = new Intent(this, Acts.class);

            startActivity(o);
            finish();
        }
        if (item.getItemId() == R.id.item4) {
            Intent w = new Intent(this, Video.class);



            startActivity(w);

            finish();
        }
        if (item.getItemId() == R.id.item5) {
            Intent c = new Intent(this,Lyrics.class);

            startActivity(c);
            finish();
        }

        if (item.getItemId() == R.id.item6) {
            Intent s = new Intent(this, User.class);



            startActivity(s);

            finish();
        }

        return true;
    }


    public void alertBuilder(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
				/*builder.setTitle("Play Again?");*/
        builder.setTitle("الصفحة الرئيسية");
        builder.setMessage(" هل تريد الذهاب الى الصفحة الرئيسية؟");
        builder.setNegativeButton("لا",null);
        builder.setPositiveButton("نعم",new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which){

                Intent i = new Intent(Lyrics.this, MainActivity.class);

                startActivity(i);
                finish();
            }
        });
        AlertDialog ad = builder.create();
        ad.show();
    }



}
