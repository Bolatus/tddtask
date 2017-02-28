package com.epam.jmp.bolat.tdd.test;

import com.epam.jmp.bolat.tdd.app.Application;
import com.epam.jmp.bolat.tdd.controller.MenteeController;
import com.epam.jmp.bolat.tdd.controller.MentorController;
import com.epam.jmp.bolat.tdd.model.Mentee;
import com.epam.jmp.bolat.tdd.model.Mentor;
import com.epam.jmp.bolat.tdd.service.MenteeService;
import com.epam.jmp.bolat.tdd.service.MentorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anything;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.notNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by dom on 26.02.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
@AutoConfigureMockMvc
public class EndpointTest {

    @Mock
    MenteeService menteeService;


    @InjectMocks
    MenteeController menteeController;

    private MockMvc mockMvc;

    @Before
    public void init(){


        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(menteeController).build();
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/mentee")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello from MenteeController")));
    }

    @Test
    public void shouldReturnDefaultMentees() throws Exception {
        Mentee m =  new Mentee(1000L,"Batman",null);
        List<Mentee> mentees = new ArrayList<Mentee>();
        mentees.add(m);
        Mockito.when(menteeService.getAllMentees()).thenReturn(mentees);
        this.mockMvc.perform(get("/mentee/all")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(content().json("[{\"id\":1000,\"name\":\"Batman\"}]"));
    }

   @Test
    public void shouldAddMenteeAndReturn4Mentees() throws Exception {
       Mockito.when(menteeService.addMentee(anyObject())).thenReturn(true);

        this.mockMvc.perform(post("/mentee/add").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"Talgat\",\"id\":0}")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\"result\":\"success\"}"));
    }

    @Test
    public void shouldAssignMentorForMentee() throws Exception{
        Mockito.when(menteeService.setMentor(anyObject(),anyObject())).thenReturn(true);
        this.mockMvc.perform(post("/mentee/assign-mentor?mentor=1&mentee=9")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\"result\":\"success\"}"));
    }


}
