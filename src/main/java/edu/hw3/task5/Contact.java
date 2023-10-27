package edu.hw3.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private String name;

    private String surname;

    private static final Pattern REGEX = Pattern.compile("[а-яА-Яa-zA-Z]+(\\s)[а-яА-Яa-zA-Z]*$");

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Contact(String data) {
        Matcher matcher = REGEX.matcher(data.toLowerCase());
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        String[] info = data.split(" ");
        this.name = info[0];
        if (info.length > 1) {
            this.surname = info[1];
        }
    }

    public Contact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override public String toString() {
        return name + " " + surname;
    }
}
