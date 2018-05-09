package com.example.hp1.fairuz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Info extends AppCompatActivity {

    Intent i,j,o,w,s,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


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
				//*builder.setTitle
        builder.setTitle("الصفحة الرئيسية");
        builder.setMessage(" هل تريد الذهاب الى الصفحة الرئيسية؟");
        builder.setNegativeButton("لا",null);
        builder.setPositiveButton("نعم",new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which){

                Intent i = new Intent(Info.this, MainActivity.class);

                startActivity(i);
                finish();
            }
        });
        AlertDialog ad = builder.create();
        ad.show();
    }


}


