package edu.hw7.task3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDatabase implements PersonDatabase {

    private final Map<String, List<Person>> phoneMap = new HashMap<>();
    private final Map<String, List<Person>> addressMap = new HashMap<>();
    private final Map<String, List<Person>> nameMap = new HashMap<>();
    private final Map<Integer, Person> idMap = new HashMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
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
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
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
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return nameMap.get(name);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return addressMap.get(address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return phoneMap.get(phone);
        } finally {
            lock.readLock().unlock();
        }
    }
}
