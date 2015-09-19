package com.bigredhacks.hackathon.student;

import javax.persistence.*;
import java.util.Date;

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
    /*
    public List<String> locations;
    public List<String> languages;
    public List<AvailableTime> availableTimes;
    */
}
