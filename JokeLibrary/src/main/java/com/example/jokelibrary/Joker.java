package com.example.jokelibrary;


import java.util.Random;

public class Joker {

    // Source of Jokes: https://gist.github.com/textarcana/7198c776a2fc8b2196117f120dd40fdf

    private static Joke jokeList[] = new Joke[] {
            new Joke("How many programmers does it take to change a lightbulb?", "None. That is a hardware problem."),
            new Joke("How many programmers does it take to change a lightbulb?", "This is a known issue. When we installed the lightbulb we knew it had a finite TTL."),
            new Joke("A QA Engineer walks into a bar.", "The QA engineer orders a beer. Orders 0 beers. Orders 999999999 beers. Orders a lizard. Orders -1 beers. Orders a sfdeljknesv."),
            new Joke("A QA Engineer walks into a bar. Orders a beer. Orders 0 beers. Orders 999999999 beers. Orders a lizard. Orders -1 beers. Orders a sfdeljknesv.", "The bartender pours one beer and says \"it works on my machine.\""),
            new Joke("Why did the developer cross the road?", "There was something he wanted to C."),
            new Joke("Why did the developer cross the road?", "To get to the other IDE."),
            new Joke("Why did the developer cross the road?", "The chicken wasn't committed."),
            new Joke("Why are assembly programmers always wet?", "Because they work under C level."),
            new Joke("There are 10 kinds of people in this world:", "those who understand binary and those who don't."),
            new Joke("*Knock knock*\nWho's there?", "[long pause] \nJava!")
    };

    public Joke getJoke() {
        int randomIndex = new Random(System.currentTimeMillis()).nextInt(jokeList.length);
        return jokeList[randomIndex];
    }
}
