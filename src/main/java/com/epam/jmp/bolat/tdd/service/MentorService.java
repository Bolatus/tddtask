package com.epam.jmp.bolat.tdd.service;

import com.epam.jmp.bolat.tdd.dao.MentorRepository;
import com.epam.jmp.bolat.tdd.model.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by dom on 25.02.2017.
 */
@Service
public class MentorService {


    @Autowired
    MentorRepository mentorRepository;

    public List<Mentor> getAllMentors(){
        return  mentorRepository.findAll();
    }

    public void addMentor(Mentor m){
        mentorRepository.save(m);
    }

    public void deleteMentor(Long id){
        mentorRepository.delete(id);
    }

    public void updateMentor(Mentor m){
        mentorRepository.save(m);
    }

//    @PostConstruct
//    public void fillRandomData(){
//        addMentor(new Mentor(null, "John"));
//        addMentor(new Mentor(null, "Mike"));
//        addMentor(new Mentor(null, "Susan"));
//        System.out.println("Added custom data.");
//    }
}
