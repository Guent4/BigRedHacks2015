package com.bigredhacks.hackathon.student;

import com.bigredhacks.hackathon.preferences.Language;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String session;
    public boolean gender;
    public String email;
    public String password;
    public String name;
    public Date lastActive;
    public String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Language.class)
    public List<Language> languages;
}
