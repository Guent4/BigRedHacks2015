package com.bigredhacks.hackathon.preferences;

import javax.persistence.*;

@Entity
@Table(name = "BUILDING")
public class Building
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String name;
    public float x;
    public float y;
}
