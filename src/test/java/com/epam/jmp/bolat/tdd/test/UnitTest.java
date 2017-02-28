package com.epam.jmp.bolat.tdd.test;

import com.epam.jmp.bolat.tdd.controller.MenteeController;
import com.epam.jmp.bolat.tdd.dao.MenteeRepository;
import com.epam.jmp.bolat.tdd.dao.MentorRepository;
import com.epam.jmp.bolat.tdd.model.Mentee;
import com.epam.jmp.bolat.tdd.model.Mentor;
import com.epam.jmp.bolat.tdd.service.MenteeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.isNotNull;

/*
 * Created by Bolat_Tussupzhanov on 2/27/2017.
 */
public class UnitTest {


    @Mock
    MenteeRepository menteeRepository;
    @Mock
    MentorRepository mentorRepository;


    @InjectMocks
    MenteeService menteeService;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfMenteeServiceExists() throws Exception{
        assertThat(menteeService,  is(notNullValue()));
    }
    @Test
    public void shouldReturnDefaultMentees() throws Exception {
        List<Mentee> mentees = new ArrayList<Mentee>();
        mentees.add(new Mentee(1000L,"Superman",null));
        mentees.add(new Mentee(1001L,"Joker",null));
        Mockito.when(menteeRepository.findAll()).thenReturn(mentees);

        List<Mentee> all = menteeService.getAllMentees();
        assertThat(all, is(notNullValue()));
        assertThat(all.size(), is(2));
    }

    @Test
    public void shouldAddMentee() throws Exception {
        Assert.assertTrue(menteeService.addMentee(new Mentee(Long.valueOf(0),"Maria",null)));
    }

    @Test
    public void shouldAssignMentorForMentee() throws Exception{
        Mockito.when(menteeRepository.getOne(1000L)).thenReturn(new Mentee(1000L,"Bake",null));
        Mockito.when(mentorRepository.getOne(500L)).thenReturn(new Mentor(500L,"Sake"));
        Mockito.when(menteeRepository.getOne(700L)).thenReturn(null);
        Assert.assertTrue(menteeService.setMentor(500L,1000L));

        Assert.assertFalse(menteeService.setMentor(500L,700L));
     }
}
