package Threads;

import java.util.Random;

public class StopThread {

    public static void main(String[] args) {
        totalThread tt = new totalThread();
        tt.start();

    }
}

class totalThread extends Thread {
    public boolean stopped = false;

    int total = 0;

    public void run() {
        while (!stopped) {
            Random rnd = new Random();
            int x = rnd.nextInt(5);
            total = total + x;
            if(total>100){stopped=true;}
            System.out.println("Total: " + total);

            try {
                sleep(100);
            } catch (InterruptedException e) {  }

        }
    }
}
