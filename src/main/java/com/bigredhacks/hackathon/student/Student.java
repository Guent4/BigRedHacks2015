package com.bigredhacks.hackathon.student;

import com.bigredhacks.hackathon.preferences.AvailableTime;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String session;
    public boolean gender;
    public String email;
    public String password;
    public String name;
    public Date lastActive;
    public List<String> locations;
    public List<String> languages;
    public List<AvailableTime> availableTimes;
}
