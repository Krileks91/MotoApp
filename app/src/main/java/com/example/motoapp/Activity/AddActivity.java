package com.example.motoapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.motoapp.R;

public class AddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String data = getIntent().getExtras().getString("Item", "");

        super.onCreate(savedInstanceState);
        if (data.equals("Motor")) {
            setContentView(R.layout.activity_add_motor);
        } else {
            setContentView(R.layout.activity_add_kategorija);
        }
    }
}