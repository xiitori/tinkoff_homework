package edu.hw10.task2;

import edu.hw10.task2.annotation.Cache;

public interface Nameable {
    @Cache(persists = true)
    String name();
}
