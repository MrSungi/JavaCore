public class HelloWorld {
    public static void main(String[] args) {

        int x = 35, y = 55, z = 21;
        System.out.println("==========================================");
        System.out.println("Biggest number out of 3");
        if (x > y){
            if (x > z){
                System.out.println("Biggest number is x: " + x);
            }
            else {
                System.out.println("Biggest number is z: " + z);
            }
            }
        else if (y > z){
            System.out.println("Biggest number is y: " + y);
            }
            else{
            System.out.println("Biggest number is z:" + z);
            }

        System.out.println("=======================================");

        int k = 10;
        System.out.println("value of k: " + k);

    }//psvm
}//class
