
import java.io.File;// because we are using FileIO package
import java.util.Arrays;//because we are using Arrays package

public class Student {
//Feilds... variables
    String name, email;
    int age;
    boolean membership;




//Constructor
    public Student(){

    }





//void method
    public void cancel_Membership(){
        membership=false;
    }

//Mehtod: returning a int value
    public int getAge(){
        return age;
    }

//Mehtod: returning a String value
    public String getName(){
        return name;
    }

//Mehtod: returning a int value ... and... takes 2 parameters
    public int getAge(int add, int minus){

        age = age + add;
        age = age - minus;

        return age;
    }



    public String doIT(){
        String str;
        if (age>10){
            str = "great";
        }
        else {
            str = "not so great";
        }

        return str;
    }





    //...Example for the import java.util.Arrays;
    int[] arr = {2,3,5,4};
    String str = Arrays.toString(arr);

    //...Example for the import java.io.File;
    File f = new File("document1.txt");



}
