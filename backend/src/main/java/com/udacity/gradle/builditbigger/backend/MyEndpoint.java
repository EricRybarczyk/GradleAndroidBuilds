package com.udacity.gradle.builditbigger.backend;

import com.example.jokelibrary.Joke;
import com.example.jokelibrary.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "getJoke")
    public JokeData getJoke() {

        Joke joke = (new Joker()).getJoke();
        JokeData response = new JokeData();
        response.setJokeSetup(joke.getSetup());
        response.setJokePunchline(joke.getPunchLine());

        // Thread.sleep() is only here to make sure we always see the spinner ProgressBar in the Android client app.
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }

}
