package edu.hw4;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {

    private static final int COUNT_SPIDER_LEGS = 8;

    private static final int COUNT_CAT_AND_DOG_LEGS = 4;

    private static final int COUNT_BIRD_LEGS = 2;

    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> COUNT_CAT_AND_DOG_LEGS;
            case BIRD -> COUNT_BIRD_LEGS;
            case FISH -> 0;
            case SPIDER -> COUNT_SPIDER_LEGS;
        };
    }
}
