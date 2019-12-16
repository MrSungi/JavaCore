import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {

        int[]arr = new int[10];

        Array(arr);
        mergeSort(arr, arr.length);

        for(int i = 0; i<arr.length; i++){
            System.out.println("sorted " + i + ". : " + arr[i]);
        }
    }


    public static void mergeSort(int[] a, int n) {
            if (n < 2) {
            return;
            }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }


    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /////////////Enter elements for Array ///////////////////
    public static int[] Array(int[]Arr){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 10 Array elements: ");
        for(int k = 0; k < 10; k++){
            Arr[k] = in.nextInt();
        }
        in.close();
        return Arr;
    }



}
