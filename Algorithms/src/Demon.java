import java.util.Arrays;
import java.util.Random;

public class Demon {
    public static void main(String[] args) {

        Random rnd = new Random();
        int[] a = new int[3];
        int count = 0, k = 0;

        while (k < 3) {
            int num = rnd.nextInt(10);
            if (num == 6) {
                a[k] = num;
                k++;
            }
            count++;
        }

        System.out.println("It came in this much moves: " + count);
        System.out.println(Arrays.toString(a));

    }
}
