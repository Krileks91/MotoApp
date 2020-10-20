package com.example.motoapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.motoapp.R;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String data = getIntent().getExtras().getString("Item", "");

        super.onCreate(savedInstanceState);
        if (data.equals("Motor")) {
            setContentView(R.layout.activity_edit_motor);
        } else {
            setContentView(R.layout.activity_edit_kategorija);
        }
    }
}
