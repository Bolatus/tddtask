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

    public List<Mentee> getAllMentees(){
        return  menteeRepository.findAll();
    }

    public void addMentee(Mentee m){
        MenteeService.iditerator++;
        m.setId(MenteeService.iditerator);
        menteeRepository.save(m);
    }

    public void deleteMentee(Long id){
        menteeRepository.delete(id);
    }

    public void updateMentee(Mentee m){
        menteeRepository.save(m);
    }

    @PostConstruct
    public void fillRandomData(){
        addMentee(new Mentee(null, "Smith"));
        addMentee(new Mentee(null, "Phil"));
        addMentee(new Mentee(null, "Max"));
        System.out.println("Added custom data.");
    }
}
