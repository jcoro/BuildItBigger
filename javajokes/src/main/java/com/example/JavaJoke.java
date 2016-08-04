package com.example;

import java.util.ArrayList;

public class JavaJoke {

    private ArrayList<String> mJokes;

    public JavaJoke() {
        mJokes = new ArrayList<String>();
        mJokes.add("You don\'t need a parachute to go skydiving. You need a parachute to go skydiving twice.");
        mJokes.add("Working in a mirror factory is something I can totally see myself doing.");
        mJokes.add("I entered what I ate today into my new fitness app. It just sent an ambulance to my house.");
        mJokes.add("What\'s the best part about living in Switzerland? Not sure, but the flag is a big plus.");
        mJokes.add("My poor knowledge of Greek Mythology has been my Achilles elbow.");
    }

    public String getJoke() {
        int jokeIndex = (int) Math.floor(Math.random() * mJokes.size());
        return mJokes.get(jokeIndex);
    }
}
