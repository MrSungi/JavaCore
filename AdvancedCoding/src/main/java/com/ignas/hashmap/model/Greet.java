package com.ignas.hashmap.model;

public class Greet {
    private String greetingL = "Labas";
    private String greetingF = "Bonjour";
    private String greetingE = "Hello";
    private String name;


    public Greet(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println(greetingL + ", " + name + "!");
        System.out.println(greetingF + ", " + name + "!");
        System.out.println(greetingE + ", " + name + "!");

    }
}
