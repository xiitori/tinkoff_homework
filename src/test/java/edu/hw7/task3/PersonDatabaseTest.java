package edu.hw7.task3;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class PersonDatabaseTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void synchronizedDatabaseTest() throws InterruptedException {
        SynchronizedDatabase synchronizedDatabase = new SynchronizedDatabase();

        Thread adder = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronizedDatabase.add(new Person(1, "Антон", "ул. Пушкина д. 3", "89304166163"));
            LOGGER.info("Человек добавлен в базу данных");
        });

        Thread finderByName = new Thread(() -> {
            List<Person> persons = synchronizedDatabase.findByName("Антон");
            while (persons == null) {
                persons = synchronizedDatabase.findByName("Антон");
            }
            LOGGER.info(persons);
        });

        Thread finderByAddress = new Thread(() -> {
            List<Person> persons = synchronizedDatabase.findByAddress("ул. Пушкина д. 3");
            while (persons == null) {
                persons = synchronizedDatabase.findByAddress("ул. Пушкина д. 3");
            }
            LOGGER.info(persons);
        });

        Thread finderByPhone = new Thread(() -> {
            List<Person> persons = synchronizedDatabase.findByPhone("89304166163");
            while (persons == null) {
                persons = synchronizedDatabase.findByPhone("89304166163");
            }
            LOGGER.info(persons);
        });

        adder.start();
        finderByName.start();
        finderByAddress.start();
        finderByPhone.start();

        finderByPhone.join();
        finderByName.join();
        finderByAddress.join();
        adder.join();
    }
}
