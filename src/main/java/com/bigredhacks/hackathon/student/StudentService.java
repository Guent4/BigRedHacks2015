package com.bigredhacks.hackathon.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

@Service
public class StudentService
{
    @Autowired
    StudentRepository repository;

    public String login(Student student)
    {
        if (student == null)
            throw new IllegalArgumentException("student cannot be null");
        List<Student> students = repository.findByEmailAndPassword(student.email, student.password);
        if (students.size() != 1)
            throw new IllegalArgumentException("student has bad credentials");
        Student s = students.get(0);
        SecureRandom random = new SecureRandom();
        String session = new BigInteger(130, random).toString(32);
        s.session = session;
        repository.save(s);
        return session;
    }
}
