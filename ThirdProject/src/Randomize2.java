import java.util.Arrays;
import java.util.Random;


public class Randomize2 {
    public static void main(String[] args) {

    Random rnd = new Random();
    char[] card = new char[10];
    int i=0;

        while(i<10){

        // For Randomise boundaries (max-min) + min
        //[10-20]               (20-10) + 10
        //[250-300]             (300-250) + 250

        int num = rnd.nextInt(10) +65 ;      //// nuo 15 iki 19

        card[i] = (char)num;
        System.out.println(Arrays.toString(card));
        i++;
        }

        }


        }

