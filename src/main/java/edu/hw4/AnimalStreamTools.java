package edu.hw4;

import edu.hw4.validate.AnimalValidator;
import edu.hw4.validate.ValidationError;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnimalStreamTools {

    private AnimalStreamTools() {
    }

    //task1
    public static List<Animal> heightSort(List<Animal> list) {
        return list.stream().sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    //task2
    public static List<Animal> firstKMostHeaviest(List<Animal> list, int k) {
        return list.stream().sorted(Comparator.comparingInt(Animal::weight).reversed()).limit(k).toList();
    }

    //task3
    public static Map<Animal.Type, Integer> mapByType(List<Animal> list) {
        return list.stream().collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(o1 -> 1)));
    }

    //task4
    public static Animal longestName(List<Animal> list) {
        return list.stream().max(Comparator.comparingInt(a -> a.name().length())).get();
    }

    //task5
    public static Animal.Sex mostFrequentBySex(List<Animal> list) {
        return list.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.summingInt(o1 -> 1)))
            .entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    //task6
    public static Map<Animal.Type, Animal> heaviestAnimalOfEveryType(List<Animal> list) {
        return list.stream().collect(Collectors.toMap(Animal::type, Function.identity(),
            BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
        ));
    }

    //task7
    public static Animal oldestAnimal(List<Animal> list, int k) {
        return list.stream().sorted(Comparator.comparingInt(Animal::age).reversed()).skip(k).findFirst().get();
    }

    //task8
    public static Optional<Animal> mostHeaviestUnderK(List<Animal> list, int k) {
        return list.stream().filter(a1 -> a1.height() < k).max(Comparator.comparingInt(Animal::weight));
    }

    //task9
    public static Integer sumOfPaws(List<Animal> list) {
        return list.stream().mapToInt(Animal::paws).sum();
    }

    //task10
    public static List<Animal> listAnimalsAgeNotEqualsPaws(List<Animal> list) {
        return list.stream().filter(a1 -> a1.age() != a1.paws()).toList();
    }

    //task11
    @SuppressWarnings("MagicNumber")
    public static List<Animal> listBitesAnimalsOver100(List<Animal> list) {
        return list.stream().filter(a1 -> a1.bites() && a1.height() > 100).toList();
    }

    //task12
    public static Integer countAnimalsWeightMoreThanHeight(List<Animal> list) {
        return (int) list.stream().filter(a1 -> a1.weight() > a1.height()).count();
    }

    //task13
    public static List<Animal> listAnimalsTwoWordsName(List<Animal> list) {
        return list.stream().filter(a1 -> a1.name().split(" ").length > 1).toList();
    }

    //task14
    public static Boolean findDogOverK(List<Animal> list, int k) {
        return list.stream().anyMatch(a1 -> a1.type() == Animal.Type.DOG && a1.height() > k);
    }

    //task15
    public static Map<Animal.Type, Integer> sumWeightWithCertainHeight(List<Animal> list, int k, int l) {
        return list.stream().filter(a1 -> a1.height() >= k && a1.height() < l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    //task16
    public static List<Animal> sortByTypeSexName(List<Animal> list) {
        return list.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    //task17
    public static Boolean isSpidersBitesMoreThanDogs(List<Animal> list) {
        return list.stream().filter(a -> a.type() == Animal.Type.SPIDER && a.bites()).count()
            > list.stream().filter(a -> a.type() == Animal.Type.DOG && a.bites()).count();
    }

    //task18
    public static Animal mostHeaviestFish(List<Animal>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).filter(a1 -> a1.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight)).get();
    }

    //task19
    public static Map<String, Set<ValidationError>> getAnimalErrorSets(List<Animal> list) {
        return list.stream().collect(Collectors.toMap(Animal::name, AnimalValidator::validateAnimal));
    }

    //task20
    public static Map<String, String> getAnimalErrorStrings(List<Animal> list) {
        return list.stream().collect(Collectors.toMap(Animal::name, a -> AnimalValidator.validateAnimal(a).toString()));
    }
}
