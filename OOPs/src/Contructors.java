
public class Contructors {

    public static void main(String[] args) {
        Car myCar = new Car();
        System.out.println("MyCar specs: " + myCar.color + " | " + myCar.max_Speed);
        myCar.max_Speed = 50;
        myCar.color = "Red";
        System.out.println("MyCar specs: " + myCar.color + " | " + myCar.max_Speed);

        System.out.println("\n===========================");





        Audi audi1 = new Audi();
        Audi audi2 = new Audi("Yellow", 220, false);
        Audi audi3 = new Audi(true);

        audi1.getSpecifications();
        audi2.getSpecifications();
        audi3.getSpecifications();
    }

}

//========================================================
//differecnt type of classes

class Car{
    String color;
    int max_Speed;

    public Car(){

    }

}

class Audi extends Car{

    boolean SUV;

    public Audi(){}//........1

    public Audi(String color, int max_Speed, boolean SUV){//.....2
        this.color = color;
        this.max_Speed = max_Speed;
        this.SUV = SUV;
    }

    public Audi(boolean SUV){//..........3
        this.SUV = SUV;
    }


    public void getSpecifications(){
        System.out.println("Color: " + color);
        System.out.println("MaxSpeed: " + max_Speed);
        System.out.println("SUV: " + SUV);
        System.out.println("===================");
    }

}