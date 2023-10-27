package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.PhoneBook;
import edu.hw3.task5.SortTypes;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {
    @Test
    void test() {
        Contact[] contacts = PhoneBook.parseContacts(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, SortTypes.DESC);
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
