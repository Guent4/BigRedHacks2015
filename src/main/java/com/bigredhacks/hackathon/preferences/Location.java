package com.bigredhacks.hackathon.preferences;

import javax.persistence.*;

@Entity
@Table(name = "LOCATION")
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String name;
    public float x;
    public float y;
}
