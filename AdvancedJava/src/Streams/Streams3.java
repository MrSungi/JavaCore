package Streams;

import java.util.stream.Stream;

public class Streams3 {
    public static void main(String[] args) {
        Stream.iterate(1, x -> x+1)
                .filter(x -> x %5==0)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("xxxxxxxxxx");

        Stream.iterate(10, x -> x+2)
                .filter(x -> x % 5 != 0)
                .limit(10)
                .forEach(System.out::println);





    }

}
