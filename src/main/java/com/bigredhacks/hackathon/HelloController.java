package com.bigredhacks.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Autowired
    private HelloRepository helloRepository;

    @RequestMapping("/hello")
    public Iterable<Hello> index()
    {
        return helloRepository.findAll();
    }

}
