package com.bigredhacks.hackathon.preferences;

import javax.persistence.*;

@Entity
@Table(name = "LANGUAGE")
public class Language
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String language;
}
