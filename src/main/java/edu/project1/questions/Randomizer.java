package edu.project1.questions;

import java.util.Random;

public class Randomizer {

    private final Random random = new Random();

    public Randomizer() {
    }

    public int getRandom(int lowerBound, int higherBound) {
        return random.nextInt(lowerBound, higherBound);
    }
}
