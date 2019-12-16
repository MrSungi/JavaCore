package Threads;

public class RunnableInterface {
    public static void main(String[] args) {

        //MyRunnableThread t = new MyRunnableThread();
        //t.start();//why this cant be called

        Thread t = new Thread(new MyRunnableThread());
        t.start();
        Thread t1 = new Thread(new MyRunnableThread());
        t1.start();

        System.out.println("MainThread xxxxxxxxxxxxxxxxxxxxxxxx ");
        System.out.println("END!... Name: "+ Thread.currentThread().getName()+"|id: " + Thread.currentThread().getId());


    }
}

class MyRunnableThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //System.out.println(i+"- name: " + getName()+"| id: " + getId());//why this error
        }
    }
}
