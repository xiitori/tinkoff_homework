package edu.hw3.task5;

import java.util.Arrays;

public class PhoneBook {

    private PhoneBook() {

    }

    public static Contact[] parseContacts(String[] names, SortTypes type) {
        Contact[] contacts = new Contact[names.length];
        for (int i = 0; i < names.length; i++) {
            contacts[i] = new Contact(names[i]);
        }
        Arrays.sort(contacts, ((o1, o2) -> {
            String firstComparable = o1.getSurname() == null
                ? (o1.getName() == null ? "" : o1.getName()) : o1.getSurname();
            String secondComparable = o2.getSurname() == null
                ? (o2.getName() == null ? "" : o2.getName()) : o2.getSurname();
            return firstComparable.compareTo(secondComparable) * (type == SortTypes.ASC ? 1 : -1);
        }));
        return contacts;
    }
}
