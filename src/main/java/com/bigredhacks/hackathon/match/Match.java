package com.bigredhacks.hackathon.match;

import com.bigredhacks.hackathon.preferences.AvailableTime;
import com.bigredhacks.hackathon.student.Student;

public class Match
{
    public long id;

    public AvailableTime availableTime;
    public String course;
    public String location;
    public boolean matched;
    // @OneToOne(cascade = CascadeType.ALL, targetEntity = Student.class)
    public Student student;
    public String session;
}
