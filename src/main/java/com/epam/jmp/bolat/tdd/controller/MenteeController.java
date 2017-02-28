package com.epam.jmp.bolat.tdd.controller;

/**
 * Created by dom on 25.02.2017.
 */
import com.epam.jmp.bolat.tdd.model.Mentee;
import com.epam.jmp.bolat.tdd.service.MenteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenteeController {

    @Autowired
    MenteeService menteeService;

    @RequestMapping("/mentee")
    public @ResponseBody String greeting() {
        return "Hello from MenteeController";
    }

    @RequestMapping("/mentee/all")
    public @ResponseBody
    List<Mentee> getAllMentees() {
        return menteeService.getAllMentees();
    }

    @RequestMapping(value = "/mentee/add", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,String> addMentee( @RequestBody Mentee mentee) {
        HashMap<String,String> answer = new HashMap<String,String>();
        if (menteeService.addMentee(mentee))
            answer.put("result","success");
        else
            answer.put("result","fail");
        return answer;
    }

    @RequestMapping(value = "/mentee/update", method = RequestMethod.POST)
    public @ResponseBody
    String updateMentee( @RequestBody Mentee mentee) {
        menteeService.updateMentee(mentee);
        return "success";
    }

    @RequestMapping(value = "/mentee/delete", method = RequestMethod.POST)
    public @ResponseBody
    String deleteMentee( @RequestParam Long id) {
        menteeService.deleteMentee(id);
        return "success";
    }

    @RequestMapping(value = "/mentee/assign-mentor", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,String> assignMentor(@RequestParam Long mentor, @RequestParam Long mentee ) {
        HashMap<String,String> answer = new HashMap<String,String>();
        if (menteeService.setMentor(mentor,mentee))
            answer.put("result","success");
        else
            answer.put("result","fail");
        return answer;
    }

}
