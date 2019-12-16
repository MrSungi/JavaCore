public class PolymorphicArray {
    public static void main(String[] args) {

        SportsMan obj = new Athlete();

        SportsMan obj2 = new WeightLifter();
        obj.GoPlay();
        obj2.GoPlay();
        System.out.println("****************************************");

        SportsMan[] arrObj = new SportsMan[5];
        arrObj[0] = new Athlete();
        arrObj[1] = new WeightLifter();
        arrObj[2] = new Wrestler();
        arrObj[3] = new Footballer();
        arrObj[4] = new Cricketer();




        for(int i=0; i<5; i++){
            arrObj[i].GoPlay();
        }

    }
}

class SportsMan{
int x;
    public void GoPlay(){
        System.out.println("Playing all sports");
    }
}

class Athlete extends SportsMan{

    @Override
    public void GoPlay() {
        System.out.println("I sprint 100m");
    }
}

class WeightLifter extends SportsMan{

    @Override
    public void GoPlay() {
        System.out.println("I lift heavy stuff");
    }
}

class Wrestler extends SportsMan{

    @Override
    public void GoPlay() {
        System.out.println("I love free style grapling");
    }
}

class Footballer extends SportsMan{

    @Override
    public void GoPlay() {
        System.out.println("I kick balls!");
    }
}

class Cricketer extends SportsMan{

    @Override
    public void GoPlay() {
        System.out.println("I bat, bowl & field");
    }
}



