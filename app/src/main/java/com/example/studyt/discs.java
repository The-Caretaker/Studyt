package com.example.studyt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class discs extends AppCompatActivity {

    private ImageButton profile;
    private ImageButton messenger;
    private ImageButton unreal_engine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discs);
        unreal_engine = (ImageButton) findViewById(R.id.unreal);
        profile = (ImageButton) findViewById(R.id.Profile);
        messenger = (ImageButton) findViewById(R.id.Messenger);
        unreal_engine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(discs.this, activity_message.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(discs.this, ProfileActivity.class));
            }
        });
        messenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(discs.this, messenger.class));
            }
        });
    }
}