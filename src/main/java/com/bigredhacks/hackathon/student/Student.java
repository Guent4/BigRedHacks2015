package com.bigredhacks.hackathon.student;

import com.bigredhacks.hackathon.AvailableTime;

import java.util.Date;
import java.util.List;

public class Student
{
    public long id;
    public boolean gender;
    public String email;
    public String password;
    public String name;
    public Date lastActive;
    public List<String> locations;
    public List<String> languages;
    public List<AvailableTime> availableTimes;
}
