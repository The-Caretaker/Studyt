package com.example.studyt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class messenger extends AppCompatActivity {
    private ImageButton profile;
    private ImageButton disciplines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        disciplines = (ImageButton) findViewById(R.id.Discs);
        disciplines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(messenger.this, discs.class));
            }
        });
        profile = (ImageButton) findViewById(R.id.Profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(messenger.this, ProfileActivity.class));
            }
        });
    }

}