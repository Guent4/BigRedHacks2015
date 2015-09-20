package com.bigredhacks.hackathon.preferences;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AVAILABLE_TIME")
public class AvailableTime
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public Date startTime;
    public Date endTime;
    public String location;
}

package com.bigredhacks.hackathon.match;

import com.bigredhacks.hackathon.preferences.AvailableTime;
import com.bigredhacks.hackathon.student.Student;

import javax.persistence.*;

@Entity
@Table(name = "MATCH")
public class Match
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public AvailableTime availableTime;
    public String course;
    public String location;
    public boolean matched;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Student.class)
    public Student student;
    public String session;
}


public static List<Match> overlapTime(Set<Matches> others, Match self) {
	
}