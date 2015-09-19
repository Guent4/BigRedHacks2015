package com.bigredhacks.hackathon.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController
{
    @Autowired
    StudentRepository repository;

    public void login(Student student)
    {

    }
}
