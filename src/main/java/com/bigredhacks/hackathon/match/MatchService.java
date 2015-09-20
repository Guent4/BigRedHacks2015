package com.bigredhacks.hackathon.match;

import com.bigredhacks.hackathon.student.Student;
import com.bigredhacks.hackathon.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchService
{
    @Autowired
    StudentRepository studentRepository;

    public static HashSet<Match> Matches = new HashSet<>();
    public static int AUTOGEN = 0;

    public Student getMatch(Match match)
    {
        // reasonable matches

        List<Match> reasonableMatches = new ArrayList<>();
        for(Match m : Matches)
        {
            if (m.course.equals(match.course) /*&& match.availableTime.startTime.compareTo(m.availableTime.endTime) < 0 && match.availableTime.endTime.compareTo(m.availableTime.startTime) > 0*/)
            {
                reasonableMatches.add(m);
            }
        }

        // todo: check for time, location
        if (reasonableMatches.isEmpty())
        {
            // get student id
            Student s = studentRepository.findBySession(match.session).get(0);
            // match.student = s;
            // we could find no one, so save it
            // matchRepository.save(match);
            match.id = AUTOGEN++;
            match.student = s;
            Matches.add(match);
            return null;
        }
        else
        {
            // we found someone!
            // update that particular match in db
            Match m = reasonableMatches.get(0);
            m.matched = true;
            Matches.add(m);
            // send back that user
            Student s = studentRepository.findOne(m.student.id);
            return s;
        }
    }
}
