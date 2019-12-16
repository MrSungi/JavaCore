package Streams;

import java.util.ArrayList;
import java.util.List;

public class Stream4 {
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

        int sumOfPrices =
                phoneList.stream()
                .map(p -> p.price)
                .reduce(0,(sum, price) -> sum + price);

        System.out.println("Total Price of all phones: " + sumOfPrices);

        sumOfPrices =
                phoneList.stream()
                        .filter(p -> p.price>35000)
                        .map(p -> p.price)
                        .reduce(0,(sum, price) -> sum + price);

        System.out.println("Total Price of all phones: " + sumOfPrices);

        long count = phoneList.stream()
                .filter(p -> p.price<=35000)
                .count();
        System.out.println("Phones less than 35k: " + count);



    }


}
