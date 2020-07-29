package ua.com.rafael;

import java.util.*;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

public class App {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("dog", "spaniel"));
        animals.add(new Animal("cat", "scottish"));
        animals.add(new Animal("dog", "grand"));
        animals.add(new Animal("dog", "buldog"));

        Map<Integer, Map<String, Double>> data = ImmutableMap.of(
                1, ImmutableMap.of("spaniel", 1.0, "scottish", 2.0, "grand", 3.0, "buldog", 4.0),
                2, ImmutableMap.of("spaniel", 2.0, "scottish", 2.0, "grand", 3.0, "buldog", 5.0),
                3, ImmutableMap.of("spaniel", 3.0, "scottish", 4.0, "grand", 5.0, "buldog", 6.0)
        );

       Map<Boolean, Map<String, Double>> maps = data.values().stream()
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(Collectors.partitioningBy(entry -> entry.getKey().equals("scottish"),
                        Collectors.groupingBy(Map.Entry::getKey, Collectors.summingDouble(Map.Entry::getValue))));
       maps.get(true).entrySet().forEach(entry -> entry.setValue(entry.getValue()/3));
       Map<String, Double> stringDoubleMap = maps.values().stream()
               .map(Map::entrySet)
               .flatMap(Collection::stream)
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

       System.out.println(stringDoubleMap);

    }
}
