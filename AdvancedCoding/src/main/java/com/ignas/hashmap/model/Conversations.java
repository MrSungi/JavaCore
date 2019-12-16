package com.ignas.hashmap.model;

import java.util.*;

public class Conversations {

    private Map<List<User>, List<Message>> threads = new HashMap<>();



    public void addMessageToGroup (List<User> group , Message message){
        List<Message> thread = threads.get(group);

        if (thread == null){
            thread = new ArrayList<>();
            threads.put(group, thread);
        }

        thread.add(message);
    }


    public List<Message> listMessages (List<User> group){
        return threads.get(group);
    }
}
