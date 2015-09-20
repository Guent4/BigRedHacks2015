package com.bigredhacks.hackathon.match;

import com.bigredhacks.hackathon.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MatchController
{
    @Autowired
    private MatchService service;

    @RequestMapping(value="/match",method= RequestMethod.POST)
    public ResponseEntity<HashMap<String,Student>> login(@RequestBody Match match)
    {
        Student result = null;
        result = service.getMatch(match);
        HttpStatus httpStatus = HttpStatus.OK;
        HashMap<String,Student> response = new HashMap<>();
        response.put("match", result);
        return new ResponseEntity<>(response, httpStatus);
    }

}
