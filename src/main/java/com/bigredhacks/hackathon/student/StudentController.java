package com.bigredhacks.hackathon.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    private StudentService service;

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ResponseEntity<HashMap<String,String>> login(@RequestBody Student student)
    {
        String session = null;
        HttpStatus httpStatus = null;
        try
        {
            session = service.login(student);
            httpStatus = HttpStatus.OK;
        }
        catch(IllegalArgumentException ex)
        {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        HashMap<String,String> response = new HashMap<>();
        response.put("session", session);
        return new ResponseEntity<>(response, httpStatus);
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public ResponseEntity<HashMap<String,Boolean>> register(@RequestBody Student student)
    {
        boolean result = false;
        HttpStatus httpStatus = null;
        try
        {
            result = service.register(student);
            httpStatus = HttpStatus.OK;
        }
        catch(IllegalArgumentException ex)
        {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        HashMap<String,Boolean> response = new HashMap<>();
        response.put("data", result);
        return new ResponseEntity<>(response, httpStatus);
    }

    @RequestMapping(value="/profile", method=RequestMethod.POST)
    public ResponseEntity<HashMap<String,Student>> getProfile(@RequestBody Student student)
    {
        Student result = null;
        HttpStatus httpStatus = null;
        try
        {
            result = service.getProfile(student.session);
            httpStatus = HttpStatus.OK;
        }
        catch(IllegalArgumentException ex)
        {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        HashMap<String,Student> response = new HashMap<>();
        response.put("data", result);
        return new ResponseEntity<>(response, httpStatus);
    }

    @RequestMapping(value="/profile/edit", method=RequestMethod.PUT)
    public ResponseEntity<HashMap<String,Boolean>> editProfile(@RequestBody Student student)
    {
        boolean result = false;
        HttpStatus httpStatus = null;
        try
        {
            result = service.editProfile(student);
            httpStatus = HttpStatus.OK;
        }
        catch(IllegalArgumentException ex)
        {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        HashMap<String,Boolean> response = new HashMap<>();
        response.put("data", result);
        return new ResponseEntity<>(response, httpStatus);
    }

    @RequestMapping(value="/logout", method=RequestMethod.POST)
    public ResponseEntity<HashMap<String,Boolean>> logout(@RequestBody Student student)
    {
        boolean result = false;
        HttpStatus httpStatus = null;
        try
        {
            result = service.logout(student.session);
            httpStatus = HttpStatus.OK;
        }
        catch(IllegalArgumentException ex)
        {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        HashMap<String,Boolean> response = new HashMap<>();
        response.put("data", result);
        return new ResponseEntity<>(response, httpStatus);
    }
}
