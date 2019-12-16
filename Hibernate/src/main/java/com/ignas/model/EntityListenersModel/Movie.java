package com.ignas.model.EntityListenersModel;
import com.ignas.entityListeners.AuditListener;
import com.ignas.entityListeners.LogListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
// @EntityListeners(AuditListener.class)
@EntityListeners({AuditListener.class, LogListener.class})
public class Movie {

    @Id
    private Long id;
    protected String movieName;
    private Integer releaseYear;
    private String language;
    @Transient
    private long age;

    @PostLoad
    public void calculateAge() {
        System.out.println("calculateAge() was called!");
        age = ChronoUnit.YEARS.between(LocalDate.of(releaseYear, 1, 1), LocalDate.now());
    }

    @PrePersist
    public void prepersist(){
        System.out.println("prepersist called from Movie");
    }
    // @PostPersist
    // public void postpersist(){
    //     setMovieName(movieName + "2");
    //     System.out.println("postpersist was called from MOVIE");
    //     System.out.println(movieName);
    // }


    // @PostLoad
    @PreUpdate
    public void preUpdate(){
        System.out.println("preUpdate was called");
    }
    // @PostUpdate
    // @PreRemove
    // @PostRemove

    public long getAge() {
        return age;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}