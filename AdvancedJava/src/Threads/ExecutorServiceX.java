package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceX {public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(2);

    Future<String> F_str = service.submit(new Task4String());
    Future<Integer> F_score =service.submit(new Task4Int());
    Future<Void> F_waiting = service.submit(new Task4waiting());

    //keep doing what you want
    //...................
    //...................
    //...................
    //...................
    //when you require the values back from the Callable threads....

    System.out.println("Now give me the answers.....");
    try {
        String str =  F_str.get();
        System.out.println("=> " + str);
        Integer score = F_score.get();
        System.out.println("=> " + score);
        F_waiting.get();
        System.out.println(str + score);

    } catch (ExecutionException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    System.out.println("xxxxxxxxxxxxxxxxxxxxx");
    service.shutdown();
}
}


class Task4String implements Callable<String>{
    String str=null;

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        str="My Score is: ";
        return str;
    }
}

class Task4Int implements Callable<Integer>{
    int score=0;
    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        score = 100;
        return score;
    }
}

class Task4waiting implements Callable<Void>{

    @Override
    public Void call() throws Exception {
        Thread.sleep(5000);
        return null;
    }
}