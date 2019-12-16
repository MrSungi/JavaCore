
public class ScopeVariables {

    int x_global;//instance variable//member variables

    public void display(){
        int x_local = 10 ;// belongs to display method.. local variables

        System.out.println("\nDisplay Method============================");
        System.out.println("Local Variable x: " + x_local);
        System.out.println("Global Variable x: " + x_global);


    }


    public static void main(String[] args) {
        int y=100; // access this in Blocks

        ScopeVariables obj = new ScopeVariables();
        System.out.println("\nMain()============================");
        System.out.println("Global Variable x: " + obj.x_global);

        //obj.x_local; // not possible

        obj.display();

        System.out.println("\nFOR block============================");
        for(int x=0; x<3; x++){
            System.out.println("Inside for Block x = " + x);//block variable
        }
        System.out.println("FOR block ENDs=========================");
        //System.out.println(x);//error


        System.out.println("\nIf block============================");
        if(6 > 4){
            String str = "Six is Greater than Four!";// block variable
            System.out.println("Inside IF Block");
            System.out.println("str value: " + str);
        }
        System.out.println("IF block ENDs=========================");
        //System.out.println(str);//error

    }

}


