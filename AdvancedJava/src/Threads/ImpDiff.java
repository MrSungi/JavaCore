package Threads;

public class ImpDiff {
    public static void main(String[] args) throws InterruptedException {
        //now cant extend any other class...
        ExtendingThread t1 = new ExtendingThread();
        t1.start();
        ExtendingThread t2 = new ExtendingThread();
        t2.start();
        ExtendingThread t3 = new ExtendingThread();
        t3.start();

        Thread t11 = new Thread(new RunnableThread());
        t11.start();
        Thread t22 = new Thread(new RunnableThread());
        t22.start();
        Thread t33 = new Thread(new RunnableThread());
        t33.start();

        Thread.sleep(100);//just for pausing

        RunnableThread Rt = new RunnableThread();
        System.out.println("============" + Rt.counter);
        Thread t111 = new Thread(Rt);
        t111.start();
        Thread t222 = new Thread(Rt);
        t222.start();
        Thread t333 = new Thread(Rt);
        t333.start();

        Thread.sleep(100);//just for pausing
        System.out.println("============" + Rt.counter);




    }
}

class ExtendingThread extends Thread{
    int counter=0;
    public void run() {
        counter++;
        System.out.println("Extending Thread: " + counter);
    }
}

class RunnableThread implements Runnable{
    int counter=0;
    public void run() {
        counter++;
        System.out.println("Runnable Thread: " + counter);
    }
}



