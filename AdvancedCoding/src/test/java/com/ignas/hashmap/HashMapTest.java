package com.ignas.hashmap;

import com.ignas.hashmap.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HashMapTest {
    @Test
    public void testHashmap(){

        User luke = new User("Luke");
        User simona = new User("Simona");

        List<User> group = Arrays.asList(luke, simona);

        Conversations conversations = new Conversations();

        conversations.addMessageToGroup(group, new Message(luke, "Hey, what's up"));
        conversations.addMessageToGroup(group, new Message(simona, "Good, how are you?"));

        List<User> sameGroupButDuplicated = Arrays.asList(new User("Luke"), new User("Simona"));
        List<Message> thread = conversations.listMessages(sameGroupButDuplicated);

        Assert.assertEquals(2, thread.size());
        Assert.assertEquals("Good, how are you?", thread.get(1).getText());
        // TODO Assertions about message content
    }

    @Test
    public void testLike() {
        User luke = new User("Luke");
        User simona = new User("Simona");

        Message message = new Message(luke, "Just left work");
        message.new Like(simona);
        // -> 'Simona liked "Just left work"'
    }

    @Test
    public void testEitherOr() {
        EitherOr<String, Integer> eo1 = EitherOr.either("Luke");
        EitherOr<String, Double> eo2 = EitherOr.or(5.1);
        EitherOr<Character, User> eo4 = EitherOr.either('K');

        Assert.assertTrue(eo1.isEither());
        Assert.assertFalse(eo1.isOr());
        Assert.assertEquals("Luke", eo1.getEither());
    }


    @Test
    public void testPredicate() {
        List<String> myList = Arrays.asList("Luke", "Simona", null);


        List<String> result = myList.stream().filter(o -> o != null).collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList("Luke", "Simona"), result);
    }

    @Test
    public void testSimple(){
////////////////////////////////////////////////////////////////////////////////////////////
        /*String greeting = "Hello";
        String name = "Ignas";

        System.out.println(translator(greeting, name));*/
////////////////////////////////////////////////////////////////////////////////////////////

        // Greet g1 = new Greet("Jonai");
        // g1.translator();
        // Greet g2 = new Greet("Ignai");
        // g2.translator();
        // Greet g3 = new Greet("Florent");
        // g3.translator();
        //
        // List<String> greetings = Arrays.asList("Hola", "Labas", "Bonjour", "Hello");
        //         // List<String> names = Arrays.asList("Ignas", "Jonas", "Polo", "Lucifer");
        //         // //
        //         // // for (String name:names){
        //         // //     for(String greeting:greetings){
        //         // //         System.out.println(greeting + ", " + name + "!");
        //         // //     }
        //         // // }
        //         //
        //         // // translator(greetings,names);
        //         //
        //         // Translator g = new Translator("labas");
        //         // g.translator("Jonas ", "Paulius");





    }

   /* public void translator(List<String> greetings, List<String> names){
        for (String greeting:greetings){
            System.out.print(greeting + ", ");
            for(String name:names){
                System.out.print(name + ", ");
            }
            System.out.println("!");
        }
*/


    @Test
    public void testGreeter() {
        List<Translator> translators = Arrays.asList(
                new Translator("Hola", "Adios"),
                new Translator("Labas", "Ate"),
                new Translator("Bonjour", "Aurevoir"),
                new Translator("Priviet", "Paka"),
                new Translator("Hi", "Goodbye")
        );

        List<String> names = Arrays.asList("Juan", "Ignas", "Florent", "Valera", "David");


      /*  int i = 0;
        int k = 0;
        for (Translator translator : translators){
            for(String name:names){
                if(i == k){
                    System.out.println(i + " | " + k);
                    System.out.println(name + " says " + translator.getGreet() + greetAll(names) );
                }
                k++;
            }
            k = 0;
            i++;

        }*/




        // for (Translator translator : translators) {
        //     System.out.print(translator.getGreet());
        //     for (String name : names) {
        //         System.out.print(", " + name);
        //     }
        //     System.out.println(", " + translator.getBye() + "!");
        // }

        // for (Translator translator : translators) {
        //
        //     for (String name : names) {
        //         System.out.println(translator.getGreet() + ", " + name + "!");
        //         System.out.println(name + ", " + translator.getBye() + "!");
        //
        //     }
        //
        // }

    }

    public String greetAll(List<String> names) {
        String line = "";

        line = line + names;

        for (String person : names) {
            line = line + ", " + person;
        }

        line = line + "!";

        return line;


    }

    class Translator {
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

       /* public void translator(String ... name) {
            System.out.print(getGreet());
            for (String s : name) {
                System.out.print(" ," + s);
            }
            System.out.println(" ," + getBye() + "!");
        }*/
    }


    @Test
    public void testGreeter2() {
        List<Translator> translators = Arrays.asList(
                new Translator("Hola", "Adios"),
                new Translator("Labas", "Iki"),
                new Translator("Bonjour", "Aurevoir"),
                new Translator("Priviet", "Paka"),
                new Translator("Hi", "Goodbye")
        );
        List<String> people = Arrays.asList("Pijus", "Marco", "Indre", "Donata", "Guoda");

        for (Translator translator : translators) {
            System.out.println(greetAll(people));
        }
    }

    class Translator2 {
        private String greeting;
        private String handshake;

        public Translator2(String greeting, String handshake) {
            this.greeting = greeting;
            this.handshake = handshake;
        }

        public String greet(String name) {
            return greeting + " " + name + "!";
        }

        public String goodbye(String name) {
            return handshake + " " + name + " :)";
        }

        public String greetAll(List<String> people) {
            String line = "";

            line = line + greeting;

            for (String person: people) {
                line = line + ", " + person;
            }

            line = line + "!";

            return line;
        }
    }



    }



