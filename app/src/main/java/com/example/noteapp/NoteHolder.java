package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NoteHolder extends AppCompatActivity {
    private TextView textView,textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_holder);

        textView= findViewById(R.id.textView1);
        textView2= findViewById(R.id.textView2);

        YoYo.with(Techniques.Tada)
                .duration(700)
                .repeat(10)
                .playOn(findViewById(R.id.textView1));



        }
    }
