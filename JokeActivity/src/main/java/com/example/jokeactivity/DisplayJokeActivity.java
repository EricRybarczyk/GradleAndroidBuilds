package com.example.jokeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        Intent starter = getIntent();

        String jokeSetup = starter.getStringExtra("setup");
        String jokePunchline = starter.getStringExtra("punchline");

        TextView setupText = findViewById(R.id.joke_setup_text);
        TextView punchlineText = findViewById(R.id.joke_punchline_text);

        setupText.setText(jokeSetup);
        punchlineText.setText(jokePunchline);
    }
}
