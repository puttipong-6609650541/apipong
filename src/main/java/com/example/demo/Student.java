package com.example.demo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("username")
    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "type" , nullable = false)
    private String type;

    @JsonProperty("displayname_en")
    @Column(name = "eng_name", nullable = false)
    private String engName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "faculty")
    private String faculty;
}