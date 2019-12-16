public class OopDemo {
    public static void main(String[] args) {
        // Car car1 = new Car(4, 5, 306);
        // Car car2 = new Car(5, 77, 306);
        Car1 car = new Car1(220,2.4,4,5);

        Engine eng = new Engine(220,2.2);


        System.out.println(car.getHorsepower());
        car.setHorsepower(260);
        System.out.println(car.getHorsepower());




    }
}

class Car1 extends Engine{
    private int numOfWheels;
    private int seatCount;

    public Car1(int horsepower, double displacement, int numOfWheels, int seatCount) {
        super(horsepower, displacement);
        this.numOfWheels = numOfWheels;
        this.seatCount = seatCount;
    }


    public int getNumOfWheels() {
        return numOfWheels;
    }

    public void setNumOfWheels(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }


}

class Engine{

     private   int horsepower;
     private double displacement;

public Engine(int horsepower, double displacement) {
        this.horsepower = horsepower;
        this.displacement = displacement;
        }

public int getHorsepower() {
        return horsepower;
        }

public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
        }

public double getDisplacement() {
        return displacement;
        }

public void setDisplacement(double displacement) {
        this.displacement = displacement;
        }



        }
