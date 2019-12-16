package com.ignas.ex7_mvc.service;

import com.ignas.ex7_mvc.model.BlogPost;

import java.util.ArrayList;
import java.util.List;

public class BlogPostService {

    List<BlogPost> blogPosts;

    public BlogPostService() {
        // ... imagine this was from the database
        this.blogPosts = new ArrayList<BlogPost>(){{
            add(new BlogPost(1, "First post", "Karbauskio dienoraštis"));
            add(new BlogPost(2, "Second post", "Richard McClintock, a Latin scholar from Hampden-Sydney College, is credited with discovering the source behind the ubiquitous filler text. In seeing a sample of lorem ipsum, his interest was piqued by consectetur—a genuine, albeit rare, Latin word. Consulting a Latin dictionary led McClintock to a passage from De Finibus Bonorum et Malorum (, a first-century B.C. text from the Roman philosopher Cicero."));
            add(new BlogPost(3, "Rigas balyams", "Cukierkų fabrikas"));
        }};
    }

    public List<BlogPost> getAll() {
        return blogPosts;
    }

    // public BlogPost getById(long id) { }
}