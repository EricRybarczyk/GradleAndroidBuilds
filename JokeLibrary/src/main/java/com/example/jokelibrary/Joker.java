package com.example.jokelibrary;

public class Joker {

    // TODO - make this a little more robust, such as a collection and return a random-ish joke each time
    public Joke getJoke() {
        return new Joke("Why did the chicken cross the road?", "To get to the other side.");
    }
}
