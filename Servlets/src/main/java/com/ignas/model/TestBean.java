package com.ignas.model;

import java.util.ArrayList;
import java.util.List;

public class TestBean {
    private String message = "Message from the bean";
    private List<String> someCollection;

    public String getMessage() {
        return(message);
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getSomeCollection() {
        return new ArrayList(){{ add("ABC"); add("DEF"); add("DEF"); }};
    }

    public void setSomeCollection(List<String> someCollection) {
        this.someCollection = someCollection;
    }
}