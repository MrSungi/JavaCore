package Threads;

public class ThreadVariables {
    public static void main(String[] args) {
        WorkToDo workBaby = new WorkToDo("baby", 1);
        WorkToDo workMan = new WorkToDo("MAN", 5);
        workBaby.start();
        workMan.start();

        try {
            workBaby.join();
            workMan.join();
        } catch (InterruptedException e) { e.printStackTrace(); } //Join is blocking
        System.out.println(workBaby.position);
        System.out.println(workMan.position);
    }
}

class WorkToDo extends Thread{
    String who;
    int jump;
    int position=0;

    public WorkToDo(String who, int jump) {
        this.who = who;
        this.jump = jump;
    }

    public void makeJump(){
        position = position + jump;
    }

    public void run() {
        for(int i=0; i<10 ;i++) {
            makeJump();
            System.out.println(who + " is at " + position);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}