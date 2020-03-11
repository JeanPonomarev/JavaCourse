package ru.jeanponomarev.person_lambdas;

import ru.jeanponomarev.person.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonLambdas {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Иван", 22), new Person("Петр", 15),
                new Person("Сергей", 16), new Person("Иван", 40),
                new Person("Петр", 17), new Person("Олег", 27));

        List<String> uniqueNames = persons.stream().map(Person::getName).distinct().collect(Collectors.toList());
        System.out.println(uniqueNames);
        System.out.println();

        System.out.println(persons.stream().map(Person::getName).distinct().collect(Collectors.joining(", ", "Имена: ", ".")));
        System.out.println();

        List<Person> youngPersons = persons.stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());
        System.out.println("Молодые люди: " + youngPersons);

        youngPersons.stream().mapToDouble(Person::getAge).average().ifPresent(x -> System.out.println("Средний возраст молодых людей: " + x + " лет"));
        System.out.println();

        Map<String, Double> personsByName = persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        for (Map.Entry<String, Double> entry : personsByName.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        List<Person> adultPersons = persons.stream().filter(p -> p.getAge() >= 20 && p.getAge() <= 45).collect(Collectors.toList());
        adultPersons.stream().sorted((p1, p2) -> p2.getAge() - p1.getAge()).forEach(System.out::println);
    }
}
