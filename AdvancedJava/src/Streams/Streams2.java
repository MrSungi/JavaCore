package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams2 {

    public static void main(String[] args) {


    Phone obj1 = new Phone("Xiaomi",28000);
    Phone obj2 = new Phone("OnePlus7",13000);
    Phone obj3 = new Phone("Pixel",35000);
    Phone obj4 = new Phone("Sony",80000);
    Phone obj5 = new Phone("iPhone", 100000);

    List<Phone> phoneList = new ArrayList<Phone>();

    //Add the phone Objects
        phoneList.add(obj1);
        phoneList.add(obj2);
        phoneList.add(obj3);
        phoneList.add(obj4);
        phoneList.add(obj5);

        phoneList.stream()
                .filter(p -> p.price > 30000)
                .map(p -> p.giveDiscount(p.price))
                .forEach(p -> System.out.println(p));

        System.out.println("To LIST========================");

        List<Integer> phonePrices =
                phoneList.stream()
                        .filter(p -> p.price > 30000)
                        .map(p -> p.price)
                        .collect(Collectors.toList());
                    System.out.println(phonePrices);

        System.out.println("To MAP========================");

        Map<String,Integer> phoneMap =
                phoneList.stream()
                        //.filter(p -> p.price > 30000)
                        .collect(Collectors.toMap(p->p.name, p->p.price));
        System.out.println(phoneMap);


    }
}

class Phone {
    String name;
    int price;

    public Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int giveDiscount(int p){
        return (p - 1000);
    }
}