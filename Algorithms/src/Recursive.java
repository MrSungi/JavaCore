public class Recursive {

    public void abc(int a,int b){

        if (a == b){
            System.out.println("*****value of a: " + a);
        }
        else {
            a++;
            System.out.println("Value of a: " + a);
            abc(a,b);
            System.out.println("=================");

        }

        System.out.println("Value of a: " + a);
    }




    public static void main(String[] args) {

        Recursive obj = new Recursive();
        obj.abc(1,7);


    }//psvm
}//class
