package com.bigredhacks.hackathon.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
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
        s.lastActive = new Date();
        repository.save(s);
        return session;
    }

    public boolean register(Student student)
    {
        if (student == null)
            throw new IllegalArgumentException("student cannot be null");
        if (exists(student))
        {
            return false;
        }
        repository.save(student);
        return true;
    }

    public Student getProfile(String session)
    {
        if (session == null || session.isEmpty())
            throw new IllegalArgumentException("session cannot be null or empty");
        List<Student> s = repository.findBySession(session);
        if (s.size() != 1)
            throw new IllegalArgumentException("invalid session");
        return s.get(0);
    }

    public boolean editProfile(Student student)
    {
        if (student == null)
            throw new IllegalArgumentException("s cannot be null");
        String session = student.session;
        if (session == null || session.isEmpty())
            throw new IllegalArgumentException("session cannot be null or empty");
        List<Student> students = repository.findBySession(session);
        if (students.size() != 1)
            throw new IllegalArgumentException("invalid session");
        Student s = students.get(0);
        s.gender = student.gender;
        s.password = student.password;
        s.phoneNumber = student.phoneNumber;
        s.languages = student.languages;
        repository.save(student);
        return true;
    }

    public boolean logout(String session)
    {
        if (session == null || session.isEmpty())
            throw new IllegalArgumentException("session cannot be null or empty");
        List<Student> students = repository.findBySession(session);
        if (students.size() != 1)
            throw new IllegalArgumentException("invalid session");
        Student student = students.get(0);
        student.session = null;
        repository.save(student);
        return true;
    }

    public boolean exists(Student student)
    {
        List<Student> results = repository.findByEmailAndPassword(student.email, student.password);
        return results.size() > 0;
    }
}
