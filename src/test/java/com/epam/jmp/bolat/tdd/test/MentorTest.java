package com.epam.jmp.bolat.tdd.test;

import com.epam.jmp.bolat.tdd.app.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
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
public class MentorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/mentor")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello from MentorController")));
    }

    @Test
    public void shouldReturnDefaultMentors() throws Exception {
        this.mockMvc.perform(get("/mentor/all")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(content().json("[{\"id\":1001,\"name\":\"John\"},{\"id\":1002,\"name\":\"Mike\"},{\"id\":1003,\"name\":\"Susan\"}]"));
    }

    @Test
    public void shouldAddMentorAndReturn4Mentors() throws Exception {
        this.mockMvc.perform(post("/mentor/add").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"Bolat\",\"id\":0}")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("success"));
        this.mockMvc.perform(get("/mentor/all")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(content().json("[{\"id\":1001,\"name\":\"John\"},{\"id\":1002,\"name\":\"Mike\"},{\"id\":1003,\"name\":\"Susan\"},{\"id\":1004,\"name\":\"Bolat\"}]"));

    }

    @Test
    public void shouldReturnDefaultMessageMentee() throws Exception {
        this.mockMvc.perform(get("/mentee")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello from MenteeController")));
    }

    @Test
    public void shouldReturnDefaultMentees() throws Exception {
        this.mockMvc.perform(get("/mentee/all")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(content().json("[{\"id\":1001,\"name\":\"Smith\"},{\"id\":1002,\"name\":\"Phil\"},{\"id\":1003,\"name\":\"Max\"}]"));
    }

    @Test
    public void shouldAddMenteeAndReturn4Mentees() throws Exception {
        this.mockMvc.perform(post("/mentee/add").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"Askhat\",\"id\":0}")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("success"));
        this.mockMvc.perform(get("/mentee/all")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(content().json("[{\"id\":1001,\"name\":\"Smith\"},{\"id\":1002,\"name\":\"Phil\"},{\"id\":1003,\"name\":\"Max\"},{\"id\":1004,\"name\":\"Askhat\"}]"));

    }
}
