import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Randomise {
    public static void main(String[] args) {

        /*for (int i = 0; i<=10; i++){
            Random rnd = new Random();
            int x = rnd.nextInt(10);
            System.out.println(x);
        }*/

        Random rnd = new Random();
        int[] card = new int[10];
        int i=0;

        while(i<10){

            int num = rnd.nextInt(11);

            boolean contains = IntStream.of(card).anyMatch(x -> x == num);

            if(contains){
                System.out.println("NO to: " + num);
            }
            else{
                card[i] = num;
                System.out.println(Arrays.toString(card));
                i++;
            }

        }




    }
}
