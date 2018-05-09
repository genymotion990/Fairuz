package com.example.hp1.fairuz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class User extends AppCompatActivity implements View.OnClickListener{
        Intent i,j,o,w,s,c;
    Button im;
    SharedPreferences preferences;
    ImageView UserImage;
    TextView userName;
    Bitmap imageBmap;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        name = (EditText) findViewById(R.id.editText);
        UserImage = (ImageView) findViewById(R.id.UserImage);
        userName = (TextView) findViewById(R.id.UserNameTv);


        preferences = getSharedPreferences("profile",MODE_PRIVATE);

        String nameFromShared = preferences.getString("name", null);
        if( nameFromShared!= null) {
            userName.setText(nameFromShared+" ");
        }
        String image = preferences.getString("image", null);
        if(image != null){
            imageBmap = BitmapFactory.decodeFile(image);
            UserImage.setImageBitmap(imageBmap);
        }

        im = (Button) findViewById(R.id.button8);
        im.setOnClickListener(this);
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

                Intent i = new Intent(User.this, MainActivity.class);

                startActivity(i);
                finish();
            }
        });
        AlertDialog ad = builder.create();
        ad.show();
    }

    @Override
    public void onClick(View view) {
        if (view == im) {
            Intent s = new Intent(User.this, Camera.class);
            s.putExtra("name", name.getText().toString());
            startActivity(s);
        }
    }
}