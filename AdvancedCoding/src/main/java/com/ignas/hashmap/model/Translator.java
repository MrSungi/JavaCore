package com.ignas.hashmap.model;

public class Translator {
    private String greet;
    private String Bye;

    public Translator(String greet, String bye) {
        this.greet = greet;
        this.Bye = bye;
    }

    public String getGreet() {
        return greet;
    }

    public String getBye() {
        return Bye;
    }

    public void translator(String ... name) {
        System.out.print(getGreet());
        for (String s : name) {
            System.out.print(" ," + s);
        }
        System.out.println(" ," + getBye() + "!");
    }
}
