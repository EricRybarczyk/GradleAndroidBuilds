package com.example.jokeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
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

        // Fade-in animation for joke punchline. Longer offset for longer joke setups, minimum 2 seconds
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        int wordCount = jokeSetup.split("\\s+").length;
        int offset = 200 * (wordCount < 10 ? 10 : wordCount);
        fadeIn.setDuration(1500);
        fadeIn.setStartOffset(offset);

        setupText.setText(jokeSetup);
        punchlineText.setText(jokePunchline);

        punchlineText.startAnimation(fadeIn);
    }
}
