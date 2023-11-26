package edu.hw7.task3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SynchronizedDatabase implements PersonDatabase {

    private final Map<String, List<Person>> phoneMap = new HashMap<>();
    private final Map<String, List<Person>> addressMap = new HashMap<>();
    private final Map<String, List<Person>> nameMap = new HashMap<>();
    private final Map<Integer, Person> idMap = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        if (idMap.containsKey(person.id())) {
            throw new IllegalArgumentException("Person with such id is already exists!");
        } else {
            idMap.put(person.id(), person);
        }

        if (phoneMap.containsKey(person.phoneNumber())) {
            phoneMap.get(person.phoneNumber()).add(person);
        } else {
            var list = new LinkedList<Person>();
            list.add(person);
            phoneMap.put(person.phoneNumber(), list);
        }

        if (nameMap.containsKey(person.name())) {
            nameMap.get(person.name()).add(person);
        } else {
            var list = new LinkedList<Person>();
            list.add(person);
            nameMap.put(person.name(), list);
        }

        if (addressMap.containsKey(person.address())) {
            addressMap.get(person.address()).add(person);
        } else {
            var list = new LinkedList<Person>();
            list.add(person);
            addressMap.put(person.address(), list);
        }
    }

    @Override
    public synchronized void delete(int id) {
        var person = idMap.get(id);
        if (person == null) {
            return;
        }

        String address = person.address();
        String phone = person.phoneNumber();
        String name = person.name();

        addressMap.remove(address);
        phoneMap.remove(phone);
        nameMap.remove(name);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return nameMap.get(name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return addressMap.get(address);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return phoneMap.get(phone);
    }
}
