package br.com.abc.javacore.ZZKstreams.test;

import br.com.abc.javacore.ZZKstreams.classes.Adulthood;
import br.com.abc.javacore.ZZKstreams.classes.Gender;
import br.com.abc.javacore.ZZKstreams.classes.Person;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamTest6Collectors2 {
    public static void main(String[] args) {
//        grouping by gender
        List<Person> personList = Person.personDataBase();
//        old way
        Map<Gender, List<Person>> genderListMap = new HashMap<>();
        List<Person> males = new ArrayList<>();
        List<Person> females = new ArrayList<>();
        for (Person p : personList) {
            if (p.getGender().equals(Gender.FEMININO))
                females.add(p);
            else
                males.add(p);
        }
        genderListMap.put(Gender.FEMININO, females);
        genderListMap.put(Gender.MASCULINO, males);
        System.out.println(genderListMap);

        // streams
        Map<Gender, List<Person>> genderListMapStream = personList.stream().collect(groupingBy(Person::getGender));
        System.out.println(genderListMapStream);

//        grouping by adulthood
        Map<Adulthood, List<Person>> adulthoodListMap = personList.stream().collect(groupingBy(p -> {
            if (p.getAge() < 18) return Adulthood.MINOR;
            else return Adulthood.OLDER;
        }));
        System.out.println(adulthoodListMap);

//        grouping by gender and adulthood
//        Map<Gender, Map<Adulthood, List<Person>>> genderAdulthoodMap;
        Map<Gender, Map<Adulthood, List<Person>>> genderAdulthoodMap = personList.stream().collect(groupingBy(Person::getGender, groupingBy(p -> {
            if (p.getAge() < 18) return Adulthood.MINOR;
            else return Adulthood.OLDER;
        })));
        System.out.println(genderAdulthoodMap);

//        grouping by gender and quantity
        Map<Gender, Long> genderQuantityMap = personList.stream().collect(groupingBy(Person::getGender, Collectors.counting()));
        System.out.println(genderQuantityMap);

//        grouping by gender and biggest salary with and without optional
        Map<Gender, Optional<Person>> genderBiggestSalaryMap = personList
                .stream()
                .collect(groupingBy(Person::getGender, Collectors.maxBy(Comparator.comparing(Person::getSalary))));
        System.out.println(genderBiggestSalaryMap);
        Map<Gender, Person> genderBiggestSalaryMapWithoutOptional = personList.stream()
                .collect(groupingBy(Person::getGender,
                        collectingAndThen(Collectors.maxBy(Comparator.comparing(Person::getSalary)), Optional::get)));
        System.out.println(genderBiggestSalaryMapWithoutOptional);

//        grouping by gender and statistics
        Map<Gender, DoubleSummaryStatistics> genderDoubleSummaryStatisticsMap = personList.stream()
                .collect(groupingBy(Person::getGender, summarizingDouble(Person::getSalary)));
        System.out.println(genderDoubleSummaryStatisticsMap);

//        grouping by gender and adulthood without Person object
        Map<Gender, List<Adulthood>> genderListMapWithoutPerson = personList.stream().collect(groupingBy(Person::getGender, mapping(p -> {
            if (p.getAge() < 18) return Adulthood.MINOR;
            else return Adulthood.OLDER;
        }, toList())));
        System.out.println(genderListMapWithoutPerson);
//        to get a distinct list
        Map<Gender, Set<Adulthood>> genderListMapWithoutPersonDistinct = personList.stream().collect(groupingBy(Person::getGender, mapping(p -> {
            if (p.getAge() < 18) return Adulthood.MINOR;
            else return Adulthood.OLDER;
        }, toSet())));
        System.out.println(genderListMapWithoutPersonDistinct);

        Map<Gender, Set<Adulthood>> genderListMapWithoutPersonDistinctOrdered = personList.stream().collect(groupingBy(Person::getGender, mapping(p -> {
            if (p.getAge() < 18) return Adulthood.MINOR;
            else return Adulthood.OLDER;
        }, toCollection(LinkedHashSet::new))));
        System.out.println(genderListMapWithoutPersonDistinctOrdered);
    }
}
