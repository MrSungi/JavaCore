import java.util.Random;

public class ArraySimple {

    int[] myArray = new int[20];
    int sizeKeeper = 10;



    public void makeRandomArray(){

        Random rnd = new Random();
        for(int i = 0; i < sizeKeeper; i++){
            myArray[i] = rnd.nextInt(20);
        }

    }



    public void getsizeKeeper(){

        System.out.println("The present size is: " + sizeKeeper);
    }



    public void printArray(){

        System.out.println("----------");

        for(int i = 0; i < sizeKeeper; i++){
            System.out.print("| " + i + " | " + myArray[i] + " |");
            System.out.println();
            System.out.println("----------");
        }

    }



    public boolean isValueInArray(int searchValue){

        boolean ans = false;

        for(int i = 0; i < sizeKeeper; i++){
            if(myArray[i] == searchValue){
                ans = true;
            }
        }

        return ans;
    }



    public void deleteA_ValueFrom(int index){

        if(index < sizeKeeper){
            for(int i = index; i < (sizeKeeper - 1); i++){// all working will end with 1 less iteration. No need to do the last iteration
                myArray[i] = myArray[i+1];
            }

            sizeKeeper--;//reduce size keeper
        }

    }

    public void insertValue(int value){

        if(sizeKeeper < 20){
            myArray[sizeKeeper] = value;
            sizeKeeper++;
        }
        else{
            System.out.println("Sorry... Max size reached");
        }

    }

    public void insertValueAt(int index, int value){
        getsizeKeeper();

        int waiting = value;
        int pulledout = myArray[index];
        if(index < sizeKeeper){
            for(int i = index; i <= (sizeKeeper ); i++){// all working will end with 1 less iteration. No need to do the last iteration
                myArray[i] = waiting;
                waiting = pulledout;
                pulledout = myArray[i+1];
                //System.out.println(i + "= " + waiting + "|" + pulledout);
            }

            sizeKeeper++;
        }

        getsizeKeeper();
    }



    public void SearchOneByOne(int value){
        boolean answer = false;

        System.out.println("The Value was Found in the Following Indexes: ");

        for(int i = 0; i < sizeKeeper; i++){
            if(myArray[i] == value) {
                answer = true;
                System.out.print(i + " ");
            }
        }

        if(!answer){
            System.out.print("Sorry No match found");
        }
    }




    public static void main(String[] args){

        ArraySimple arrObj = new ArraySimple();
        arrObj.makeRandomArray();
        arrObj.printArray();


        System.out.println(arrObj.isValueInArray(13));

        arrObj.deleteA_ValueFrom(4);
        arrObj.printArray();

        arrObj.insertValue(37);
        arrObj.printArray();

        arrObj.insertValueAt(6,99);
        arrObj.printArray();


        arrObj.SearchOneByOne(15);
    }





}