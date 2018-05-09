package com.example.hp1.fairuz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LyricsActivity extends AppCompatActivity {
    InputStream is=null;
    InputStreamReader in;
    BufferedReader br;

    //parameters for file reading used in both methods
    String temp="", all="";
    int num;

    TextView tvLyrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);

        tvLyrics = (TextView) findViewById(R.id.tvlyrics);

        int lyricsFile = getIntent().getIntExtra("lyrics",0);
        String lyrics = readLyrics(lyricsFile);
        tvLyrics.setText(lyrics);

    }
    public String readLyrics(int fileName){
        try{
            temp="";
            all="";
            //4. open the file for reading
            is=getResources().openRawResource(fileName);
            //open a channel for file reading
            in= new InputStreamReader(is);
            br= new BufferedReader(in);
            //while end of file not reached
            //readline() reads one line at a time
            while((temp=br.readLine())!=null)
                all+=temp+"\n";//concatinate all lines to a string
            is.close();//file close
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return all;
    }
}
