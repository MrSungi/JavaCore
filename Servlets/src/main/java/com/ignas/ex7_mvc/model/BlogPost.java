package com.ignas.ex7_mvc.model;
public class BlogPost {
    private long id;
    private String title;
    private String postBody;

    public BlogPost(long id, String title, String postBody) {
        this.id = id;
        this.title = title;
        this.postBody = postBody;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}