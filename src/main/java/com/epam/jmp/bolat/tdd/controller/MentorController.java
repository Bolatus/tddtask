package com.epam.jmp.bolat.tdd.controller;

/**
 * Created by dom on 25.02.2017.
 */
import com.epam.jmp.bolat.tdd.model.Mentor;
import com.epam.jmp.bolat.tdd.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MentorController {

    @Autowired
    MentorService mentorService;

    @RequestMapping("/mentor")
    public @ResponseBody String greeting() {
        return "Hello from MentorController";
    }

    @RequestMapping("/mentor/all")
    public @ResponseBody
    List<Mentor> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @RequestMapping(value = "/mentor/add", method = RequestMethod.POST)
    public @ResponseBody
    String addMentor( @RequestBody Mentor mentor) {
        mentorService.addMentor(mentor);
        return "success";
    }

    @RequestMapping(value = "/mentor/update", method = RequestMethod.POST)
    public @ResponseBody
    String updateMentor( @RequestBody Mentor mentor) {
        mentorService.updateMentor(mentor);
        return "success";
    }

    @RequestMapping(value = "/mentor/delete", method = RequestMethod.POST)
    public @ResponseBody
    String deleteMentor( @RequestParam Long id) {
        mentorService.deleteMentor(id);
        return "success";
    }
}
