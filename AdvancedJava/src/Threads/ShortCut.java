package Threads;

public class ShortCut {

    public static void main(String[] args) {


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i+"-Short Cut...");
                }

            }
        });
        t.start();

        //... now make it still shorter

    }
}
