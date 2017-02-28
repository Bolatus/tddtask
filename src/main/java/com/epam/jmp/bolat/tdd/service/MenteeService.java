package com.epam.jmp.bolat.tdd.service;

import com.epam.jmp.bolat.tdd.dao.MenteeRepository;
import com.epam.jmp.bolat.tdd.dao.MentorRepository;
import com.epam.jmp.bolat.tdd.model.Mentee;
import com.epam.jmp.bolat.tdd.model.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by dom on 25.02.2017.
 */
@Service
public class MenteeService {

    public static Long iditerator = 1000L;

    @Autowired
    MenteeRepository menteeRepository;

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    MentorService mentorService;

    public List<Mentee> getAllMentees(){
        return  menteeRepository.findAll();
    }

    public boolean addMentee(Mentee m){
        try{
            menteeRepository.save(m);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public void deleteMentee(Long id){
        menteeRepository.delete(id);
    }

    public void updateMentee(Mentee m){
        menteeRepository.save(m);
    }


    public boolean setMentor(Long mentorId, Long menteeId){
        try {
            Mentor mentor = mentorRepository.getOne(mentorId);
            Mentee mentee = menteeRepository.getOne(menteeId);
            mentee.setMentor(mentor);
            menteeRepository.save(mentee);
            return true;
        } catch (Exception e){
            return false;
        }
    }
//    @PostConstruct
//    public void fillRandomData(){
//        Mentor m = mentorRepository.findOneByName("Mike");
//        addMentee(new Mentee(null, "Smith",m));
//        addMentee(new Mentee(null, "Phil",m));
//        addMentee(new Mentee(null, "Max",m));
//        System.out.println("Added custom data.");
//    }
}
