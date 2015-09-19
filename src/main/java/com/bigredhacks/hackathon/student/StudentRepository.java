package com.bigredhacks.hackathon.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{
    public Student findByEmailAndPassword(String email, String password);
}
