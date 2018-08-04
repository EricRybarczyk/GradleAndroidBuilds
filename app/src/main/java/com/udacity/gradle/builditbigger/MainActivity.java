package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jokeactivity.DisplayJokeActivity;
import com.example.jokelibrary.Joke;


public class MainActivity extends AppCompatActivity implements JokeEndpointCallbackHandler {

    private ProgressBar spinner;
    private Button jokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.progressSpinner);
        jokeButton = findViewById(R.id.getJokeButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        setWorkingIndicators(true);
        new JokeEndpointAsyncTask(this).execute();
    }


    @Override
    public void onTaskComplete(Joke joke) {
        Intent jokeDisplayIntent = new Intent(this, DisplayJokeActivity.class);
        jokeDisplayIntent.putExtra("setup", joke.getSetup());
        jokeDisplayIntent.putExtra("punchline", joke.getPunchLine());
        setWorkingIndicators(false);
        startActivity(jokeDisplayIntent);
    }

    private void setWorkingIndicators(boolean workIsInProcess) {
        if (workIsInProcess) {
            spinner.setVisibility(View.VISIBLE);
            jokeButton.setEnabled(false);
        } else {
            spinner.setVisibility(View.INVISIBLE);
            jokeButton.setEnabled(true);
        }
    }
}
