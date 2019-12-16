package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Streams1 {
    public static void main(String[] args) {

        List<String> music = new ArrayList<>();
        music.add("Rock");
        music.add("Classic");
        music.add("Metal");
        music.add("Alternative");
        music.add("Soul");
        music.add("Rap");

        //regular
        for (String m : music) {
            if (!m.equals("Alternative")) {
                System.out.println(m);
            }
        }

        //Streams
        System.out.println("Inside Streams=============");

        music.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return (!s.equals("Alternative"));
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });

        System.out.println("Stream Code=============");
        music.stream()
                .filter(m -> (!m.equals("Alternative")))
                .forEach(m -> System.out.println(m));


        System.out.println("Stream with MethodReferencing=============");
        music.stream()
                .filter(m -> (!m.equals("Alternative")))
                .forEach(m -> System.out.println(m));


    }
}