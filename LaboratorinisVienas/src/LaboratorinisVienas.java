import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class LaboratorinisVienas {
    public static void main(String[] args) {
        //1.
        /*
        * ISit-17
        * Ignas Sungaila
        *  */

        //2.
        int n = 5, m = 8;
        int[][] dMasyvas = new int[n][m];

        //3.
        int a = 3, b = 13;
        Random rnd = new Random();
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dMasyvas[i][j] = rnd.nextInt(11)+3;
            }
        }

        //4.
        int k = 0;
        System.out.print("\t");
        for (int i = 0; i < m; i++)
            System.out.format(" %2d:", i);

        System.out.println();

        for (int i = 0; i < n; i++){
            System.out.format("%3d: ", k);
            for(int j = 0; j < m; j++){
                System.out.format("|%3d" , dMasyvas[i][j]);
            }
            k++;
            System.out.println();
        }
        System.out.println("--------------------------------------------------");


        //5.

        float[] vidEiluciu = new float[5];
        float[] vidStulpeliu = new float[8];
        for (int i = 0; i < n; i++){
            float vid =0;
            for (int j = 0; j <m; j++){
                vid += dMasyvas[i][j];
            }
            vidEiluciu[i] = vid /8;
        }

        for (int i = 0; i < m; i++){
            float vid =0;
            for (int j = 0; j <n; j++){
                vid += dMasyvas[j][i];
            }
            vidStulpeliu[i] = vid /5;
        }

        for (int i = 0; i < n; i++){
            System.out.format("|%.3f",vidEiluciu[i]);
        }
        System.out.println("|\n--------------------------------------------------");
        for (int i = 0; i < m; i++){
            System.out.format("|%.3f",vidStulpeliu[i]);
        }

        System.out.println("|\n--------------------------------------------------");

        //6.

        for(int i = 0; i < n; i++){
            int sk = 0;
            for (int j = 0; j < m; j++){
                if(dMasyvas[i][j] > vidEiluciu[i]){
                    sk++;
                }
            }
            System.out.println( (i + 1) + " eiluteje yra " + sk + " skaiciai, kurie didesni nei vidurkis: " + vidEiluciu[i]);
        }
        System.out.println("--------------------------------------------------");

        //7.
        int max = dMasyvas[0][0];
        for (int i = 0; i < n; i++){
            for (int j = 1; j < m; j++){
                if (i != a && j !=a && dMasyvas[i][j] > max){
                    max = dMasyvas[i][j];
                }
            }
        }

        System.out.println("Didziausias skaicius yra: " + max);


        System.out.println("--------------------------------------------------");

        //8.

        int aEil[] = dMasyvas[a].clone();
        Arrays.sort(aEil);
        for (int t : aEil){
            System.out.print(t + " ");
        }

        System.out.println("\n--------------------------------------------------");


        //9.


        int aStulp[] = new int[n];
        for (int i =0; i < n; i++){
            aStulp[i] = dMasyvas[i][a];
        }
        Arrays.sort(aStulp);
        for (int i = n-1; i >= 0; i--){
            System.out.print(aStulp[i] + " ");
        }

        System.out.println("\n--------------------------------------------------");


        //10.
        int index = 0;
        float min = vidStulpeliu[0];
        for(int s = 1; s < vidStulpeliu.length; s++ ){
            if (vidStulpeliu[s] < min){
                min = vidStulpeliu[s];
                index = s;
            }
        }


        System.out.println("Maziausias stulpeliu vidurkis yra: " + min + " , kuris yra masyvo vietoje su indeksu: " + index);



    }//main
}
