package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.PhoneBook;
import edu.hw3.task5.SortTypes;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneBookTest {
    @Test
    void parseContactsTest() {
        Contact[] contacts = PhoneBook.parseContacts(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, SortTypes.DESC);
        assertThat(contacts[0].toString()).isEqualTo("Carl Gauss");
        assertThat(contacts[1].toString()).isEqualTo("Leonhard Euler");
        assertThat(contacts[2].toString()).isEqualTo("Paul Erdos");
    }

    @Test
    void noSurnameTest() {
        Contact[] contacts = PhoneBook.parseContacts(new String[] {"Paul Erdos", "Boris", "Leonhard Euler", "Anthony"}, SortTypes.ASC);
        assertThat(contacts[0].toString()).isEqualTo("Anthony");
        assertThat(contacts[1].toString()).isEqualTo("Boris");
        assertThat(contacts[2].toString()).isEqualTo("Paul Erdos");
        assertThat(contacts[3].toString()).isEqualTo("Leonhard Euler");
    }

    @Test
    void emptyContactTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            PhoneBook.parseContacts(new String[]{"Steve Jobs", "Elon Musk", ""}, SortTypes.ASC);
        });
    }
}
