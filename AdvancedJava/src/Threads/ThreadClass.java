package Threads;

public class ThreadClass {
    public static void main(String[] args) {

        MySimpleThread t = new MySimpleThread();
        t.start();
        // t.run();


        /*MyThreadClass t = new MyThreadClass();
        t.start();
        MyThreadClass t1 = new MyThreadClass();
        t1.start();*/

        System.out.println("MainThread xxxxxxxxxxxxxxxxxxxxxxxx ");
        System.out.println("END!... Name: "+ Thread.currentThread().getName()+"|id: " + Thread.currentThread().getId());

    }
}

class MySimpleThread extends Thread{
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " from new Thread");
        }
    }
}

class MyThreadClass extends Thread{
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+"- name: " + getName()+"| id: " + getId());
        }

        //Thread.sleep(100);//showing mix up

    }
}