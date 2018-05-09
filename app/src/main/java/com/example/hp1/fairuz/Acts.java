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

import java.util.ArrayList;

public class Acts extends AppCompatActivity implements AdapterView.OnItemClickListener{
    Intent a,i,j,o,w,s,c,x;
    ListView show;
    ArrayAdapter<String>theatre;
    ArrayList<String> cinema= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cinema.add("مسرحية ميس الريم");
        cinema.add("فيلم سفر برلك");
        cinema.add("مسرحية اللولو");
        cinema.add("فيلم بنت الحارس");
        cinema.add("مسرحية المحطة");
        cinema.add("مسرحية الشخص");
        cinema.add("فيلم بياع الخواتم");
        cinema.add("مسرحية الليل والقنديل");
        cinema.add("مسرحية المصالحة");
        cinema.add("سهرة حب");
        cinema.add("مسرحية هالة والملك");
        show= (ListView)findViewById(R.id.lv);
        theatre= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cinema); // rabet ben ilmo3tayat wil listview
        show.setAdapter(theatre);
        show.setOnItemClickListener(this);

    }

    // mola2ami bein il item wil link

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=boNgOgj7_80"));
            startActivity(x);
        }
        if(i==1){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=rFmTWKnsMpA"));
            startActivity(x);

        }
        if(i==2){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=qM8mV39HVu4"));
            startActivity(x);

        }
        if(i==3){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=K85VlU87CI4"));
            startActivity(x);

        }
        if(i==4){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=iBP6nalk1Qs"));
            startActivity(x);

        }
        if(i==5){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=M0d8jU-9sPw"));
            startActivity(x);

        }
        if(i==6){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=hpQ8XORfJ8c"));
            startActivity(x);

        }
        if(i==7){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=Ifor9uxN6dc"));
            startActivity(x);


        }
        if(i==8){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=-bP57p_KCOw"));
            startActivity(x);

        }
        if(i==9){
            Intent x = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=iKjLfC1C454"));
            startActivity(x);

        }
        if(i==10) {
            Intent x = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=tbeQg6oPIh8"));
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

                Intent i = new Intent(Acts.this, MainActivity.class);

                startActivity(i);
                finish();
            }
        });
        AlertDialog ad = builder.create();
        ad.show();
    }

        }
