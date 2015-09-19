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
