package com.example;

import java.util.ArrayList;
import java.util.Random;

public class JokeSupplier {

    public static String getJoke(){
        ArrayList<String> jokes = new ArrayList<>();
        jokes.add("Moses had the first tablet that could connect to the cloud.");
        jokes.add("When I was a boy, I had a disease that required me to eat dirt three times a day in order to survive... It's a good thing my older brother told me about it.");
        jokes.add("Talking to a liberal is like trying to explain social media to a 70 years old.");
        jokes.add("About a month before he died, my uncle had his back covered in lard. After that, he went down hill fast.");

        return jokes.get(new Random().nextInt(jokes.size()));
    }
}
