package com.example.getfoodie.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.getfoodie.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView next_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        next_activity = findViewById(R.id.get_started);
        next_activity.setOnClickListener(this);

    }




    @Override
    public void onClick(View view) {
        if (view == next_activity){
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            startActivity(intent);
        }
    }
}