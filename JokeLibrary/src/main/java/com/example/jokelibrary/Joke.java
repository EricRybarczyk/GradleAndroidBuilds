package com.example.jokelibrary;

public class Joke {
    private String setup;
    private String punchLine;

    public Joke(String jokeSetup, String jokePunchLine) {
        this.setup = jokeSetup;
        this.punchLine = jokePunchLine;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchLine() {
        return punchLine;
    }

    public String getJoke() {
        return this.setup + " " + this.punchLine;
    }

    @Override
    public String toString() {
        return this.getJoke();
    }
}
