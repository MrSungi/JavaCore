package Lambda;

public class Lambda2 {
    public static void main(String[] args) {

        // Screen scr = new Plancheta();
        // scr.Display();

        Screen scr = new Screen() {
            @Override
            public void Display() {
                System.out.println("Display Home Screen");
            }
        };
        scr.Display();

       // Screen scr = () -> {System.out.println("Display Home Screen");};
       // Screen scr = () -> System.out.println("Display Home Screen");
       // scr.Display();

       // Screen scr = (str) -> System.out.println("Display Home Screen" + str);
       // scr.Display(" in 720 x 1080");



    }
}

interface Screen{
    void Display();//(String str);
}

class Plancheta implements Screen{

    @Override
    public void Display() {
        System.out.println("Displaying Home Screen");
    }
}

