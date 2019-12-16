public class Dog {

    int num_legs;
    String breed;

    public void doBarking(){
        System.out.println("Woof...Woof...Woof!!! " + num_legs);
    }

    public Dog(){}

    public Dog(String breed, int numlegs){
        this.breed = breed;
        this.num_legs = numlegs;
    }

    public void getProperties(){
        System.out.println("Dog's breed is: " + breed);
        System.out.println("Dog has " + num_legs + " legs");

    }
}

class ProgramToRun{
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.breed ="Ciau ciau";
        dog.num_legs = 4;

        dog.doBarking();
        dog.getProperties();
        dog.doBarking();


        System.out.println("\n---------Second Dog-----------\n");

        Dog bigDog = new Dog();
        bigDog.num_legs = 5;
        bigDog.breed = "German Shepherd";

        bigDog.doBarking();
        bigDog.getProperties();
        bigDog.doBarking();

        System.out.println("\n---------Second Dog-----------\n");


        Dog smallDog = new Dog("pug", 3);

        smallDog.doBarking();
        smallDog.getProperties();
        smallDog.doBarking();

    }
}