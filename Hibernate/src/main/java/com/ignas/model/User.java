package com.ignas.model;
import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(
                name = "get_user_by_name",
                query = "select u from User u where name = :name"
        ),
        @NamedQuery(
                name = "get_user_by_name_fuzzy",
                query = "select u from User u where name like :name"
        )
})

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private int height;
    private int age;

    public User() {}

    public User(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public long getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}