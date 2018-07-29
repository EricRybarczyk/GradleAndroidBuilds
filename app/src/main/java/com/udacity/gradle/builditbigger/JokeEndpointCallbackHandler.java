package com.udacity.gradle.builditbigger;

import com.example.jokelibrary.Joke;

public interface JokeEndpointCallbackHandler {
    void onTaskComplete(Joke joke);
}
