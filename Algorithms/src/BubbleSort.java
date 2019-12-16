public class BubbleSort {
    public static void main(String[] args) {
        int[] Arr = {2, 5, 1, 6, 7, 3, 13};

        for(int k=0; k<Arr.length;k++){
            System.out.println("Array num " + Arr[k]);
        }
        Sort(Arr);


        for(int k=0; k<Arr.length;k++){
            System.out.println("Array num " + Arr[k]);
        }
    }

    public static void Sort(int[]Arr){
        int n = Arr.length;

        for(int i = 0; i<n-1;i++){
            for(int j=0; j< n-i-1;j++){
                if(Arr[j]>Arr[j+1]){
                    int temp = Arr[j];
                    Arr[j] = Arr[j+1];
                    Arr[j+1] = temp;
                }
            }
        }


    }

}
