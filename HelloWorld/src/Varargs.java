public class Varargs {
    public void addition(int ... numbers){
        int total=0;
        for(int x : numbers){
            System.out.println("Value of x: " + x);
            total = total + x;
        }
        System.out.println("Addition: " + total);
    }

    public void billInfo(String who, int ... numbers){

        int total=0;
        for(int x : numbers){
            total = total + x;
        }
        System.out.println("The bill for " + who + " is " + total);
    }


    public static void main(String[] args) {
        Varargs obj = new Varargs();
        obj.addition(1,2,3,4,5,6,45,2,14,16,15,14,4);
        obj.billInfo("Yohan", 5,7,3);



    }
}
