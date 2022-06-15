package com.example.studyt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class messenger extends AppCompatActivity {
    private ImageButton profile;
    private ImageButton disciplines;
    private Button dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

//        dialog = (Button) findViewById(R.id.dialog);
//        dialog.setOnClickListener((new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(messenger.this, activity_message.class));
//            }
//        }));

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