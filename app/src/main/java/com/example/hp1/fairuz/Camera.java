package com.example.hp1.fairuz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

public class Camera extends AppCompatActivity implements View.OnClickListener {
    private Bitmap bitmap;
    private ImageView imageView;
    Button btCamera,btGalery;
    static final int SELECT_IMAGE=1;
    static final int TAKE_IMAGE=0;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        btCamera = (Button) findViewById(R.id.button4);
        btGalery = (Button) findViewById(R.id.button5);
        btCamera.setOnClickListener(this);
        btGalery.setOnClickListener(this);

        imageView = (ImageView)findViewById(R.id.imageView);
        preferences = getSharedPreferences("profile",MODE_PRIVATE);

    }

    @Override
    public void onClick(View v) {

        if(v==btCamera){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,TAKE_IMAGE);

        }else{
            Intent l = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(l, SELECT_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode== TAKE_IMAGE && resultCode== RESULT_OK){
            Bundle extra = data.getExtras();
            bitmap = (Bitmap) extra.get("data");
            imageView.setImageBitmap(bitmap);
            saveImage(bitmap);
            Intent i = new Intent(this, User.class);
            startActivity(i);
        }else{
            Uri targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                saveImage(bitmap);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Intent i = new Intent(this, User.class);
            startActivity(i);
        }
    }

    public File saveImage(Bitmap bitmap){
        File root= Environment.getExternalStorageDirectory();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String filePath = root.getAbsolutePath()+"/IMG_"+timeStamp+".jpg";
        File file = new File(filePath);// determinig the type of the file and its place.

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("image",filePath);
        editor.putString("name",getIntent().getStringExtra("name"));
        editor.commit();

        try
        {
            // if gallary nit full create a file and save images
            file.createNewFile();// create new file to save image.
            FileOutputStream ostream = new FileOutputStream(file);//saves root in this file
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);// compass bitmap in file
            ostream.close();// close
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Faild to save image", Toast.LENGTH_SHORT).show();
        }
        return file;
    }

}



