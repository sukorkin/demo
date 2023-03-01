package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String password;

    private String email;

    private Integer age;
}
