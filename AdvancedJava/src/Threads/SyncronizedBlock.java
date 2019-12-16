package Threads;

public class SyncronizedBlock {
    static int counter=0;

    static public synchronized void Increasecounter(){//sync
        counter++;
    }//sync threads

    static public void PrintCounter(){
        System.out.println("Counter is: " + counter);
    }

    //================================================program starts
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    Increasecounter();
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    Increasecounter();
                }

            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) { e.printStackTrace(); }


        PrintCounter();
    }





}
