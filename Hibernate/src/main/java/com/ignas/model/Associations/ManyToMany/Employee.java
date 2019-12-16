package com.ignas.model.Associations.ManyToMany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Employee_Project",
            joinColumns = { @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "EMPLOYEE_ID")) },
            inverseJoinColumns = { @JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "PROJECT_ID")) }
    )
    Set<Project> projects = new HashSet<>();

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}