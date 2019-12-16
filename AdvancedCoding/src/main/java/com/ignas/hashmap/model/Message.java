package com.ignas.hashmap.model;

public class Message {

    private final User user;
    private final String text;

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public User getUser() {
        return user;
    }


    public String getText() {
        return text;
    }




    public class Like{


        public Like (User u){
            System.out.println(u.getName() + " liked \"" + getText() +"\"");

        }


        public String getText(){
            return text;
        }


    }
}
