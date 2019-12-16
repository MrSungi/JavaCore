package Streams;

import java.util.*;

public class Streams5 {
    public static void main(String[] args) {

        List<Integer> numlist = Arrays.asList(-15, 66, 10, 0, 73, 13, 45);

        System.out.println("SORTED: ");
        numlist.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Reverse SORTED: ");
        numlist.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        Optional<Integer> max = numlist.stream()
                                        .reduce(Math::max);
        System.out.println("Ther max Value is: " + max.get());

        List<String> strList = Arrays.asList("abcde", "abcd", "abc", "ab", "a");
        strList.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);

        //==========================================================================

        List<Integer> list = Arrays.asList(12, 21, 21, 12, 16 , 6, 15, 47, 33, 97);
        System.out.println("ONLY DIstinct:");
        list.stream().
                distinct().
                forEach(System.out::println);

        System.out.println("========================");

    }
}
