package com.bigredhacks.hackathon.preferences;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Language
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String language;
}
