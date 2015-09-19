package com.bigredhacks.hackathon;


import javax.persistence.*;

@Entity
@Table(name = "hello")
public class Hello
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    public long id;
}
