

public class Incapsulation {

        private String firstName;
        private String lastName;

        public Incapsulation(){}

        public Incapsulation(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }

        public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
        public void setLastName(String lastName) {
        this.lastName = lastName;
    }

public static void main(String[] args) {
        Incapsulation obj = new Incapsulation("Ignas","Sungaila");
        System.out.println("========");
        System.out.println(obj.firstName);
        System.out.println(obj.getFirstName());

    System.out.println("========2222");
    obj.firstName="Pavel";
    System.out.println(obj.firstName);
    System.out.println(obj.getFirstName());
    }
}

class stuff extends Incapsulation{

    public static void main(String[] args) {
        Incapsulation obj = new Incapsulation("yohan","ohhh");
        System.out.println("========");
        System.out.println(obj.getFirstName());
        //System.out.println(obj.firstName);
        obj.setFirstName("Ignas");
        System.out.println(obj.getFirstName());
    }

}

class Game {
    private int score;
    private int secret_score11;
    private int secret_score22;

    public Game(){}

    public int getScore() {
        return score;
    }

    public void setScore(int val) {
        this.score = val;//May be algorithm is hidden eg. score=[val + kills - (bullets/2)]
        secret_score11 = val*11;//you can hide datatype too
        secret_score22 = val*22;
    }

    public void showSecrets(){
        System.out.println(secret_score11 + "|" + secret_score22);
    }
}

class stuff2 extends Game{

    public static void main(String[] args) {
        Game obj = new Game();
        System.out.println("========");
        //System.out.println(obj.score);

        System.out.println(obj.getScore());

        obj.setScore(3);
        System.out.println(obj.getScore());
        obj.showSecrets();


        obj.setScore(5);
        System.out.println(obj.getScore());
        obj.showSecrets();

    }

}

