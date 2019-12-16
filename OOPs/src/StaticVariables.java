
public class StaticVariables {

    public static void main(String[] args) {

        //System.out.println(seats); //error
        //System.out.println(Theatre.max_seats);

        Theatre operaObj = new Theatre();
        Theatre balletObj = new Theatre();

        operaObj.seats = 25;
        balletObj.seats = 45;
        System.out.println("================");

        System.out.println("Opera Seats: " + operaObj.seats);
        System.out.println("Ballet Seats: " + balletObj.seats);
        System.out.println("Opera MAX Seats: " + operaObj.max_seats);
        System.out.println("Ballet MAX Seats: " + balletObj.max_seats);




        operaObj.seats = operaObj.seats + 5;
        System.out.println("================ Opera seats +5");

        System.out.println("Opera Seats: " + operaObj.seats);
        System.out.println("Ballet Seats: " + balletObj.seats);




        balletObj.max_seats = 65;
        System.out.println("================ Ballet changes MAX_seats");
        System.out.println("Opera MAX Seats: " + operaObj.max_seats);
        System.out.println("Ballet MAX Seats: " + balletObj.max_seats);
        System.out.println("Theatre Class MAX Seats: " + Theatre.max_seats);

        Theatre.max_seats += 10;
        System.out.println("================ Ballet changes MAX_seats");
        System.out.println("Opera MAX Seats: " + operaObj.max_seats);
        System.out.println("Ballet MAX Seats: " + balletObj.max_seats);
        System.out.println("Theatre Class MAX Seats: " + Theatre.max_seats);



    }
}





class Theatre{

   int seats = 0;
   public static int max_seats = 50;

}