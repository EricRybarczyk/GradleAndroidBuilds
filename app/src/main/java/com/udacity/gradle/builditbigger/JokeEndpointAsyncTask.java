package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.jokelibrary.Joke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.JokeData;

import java.io.IOException;

public class JokeEndpointAsyncTask extends AsyncTask<Void, Void, Void> {

    private static MyApi myApiService = null;
    private JokeEndpointCallbackHandler jokeEndpointCallbackHandler;
    private Joke joke;

    public JokeEndpointAsyncTask(JokeEndpointCallbackHandler callbackHandler) {
        jokeEndpointCallbackHandler = callbackHandler;
    }

    /*
    * This code was directly adapted from
    * https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints#2-connecting-your-android-app-to-the-backend
    * as recommended by Udacity in the preparation materials for this project.
    * */
    @Override
    protected Void doInBackground(Void... voids) {

        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),
                    null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(
                            new GoogleClientRequestInitializer() {
                                @Override
                                public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                                    request.setDisableGZipContent(true);
                                }
                            }
                    );
            myApiService = builder.build();
        }

        try {
            JokeData jokeData = myApiService.getJoke().execute();
            joke = new Joke(jokeData.getJokeSetup(), jokeData.getJokePunchline());
        } catch (IOException e) {
            joke = new Joke("Exceptions are not funny.", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void theVoid) {
        jokeEndpointCallbackHandler.onTaskComplete(this.joke);
    }
}