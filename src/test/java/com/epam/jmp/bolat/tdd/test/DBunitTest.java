package com.epam.jmp.bolat.tdd.test;

import com.epam.jmp.bolat.tdd.app.Application;
import com.epam.jmp.bolat.tdd.model.Mentor;
import com.epam.jmp.bolat.tdd.service.MentorService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Created by dom on 26.02.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("/dataset.xml")
public class DBunitTest {

    @Autowired
    MentorService mentorService;
    @Test
    public void contextLoads() {
        List<Mentor> all = mentorService.getAllMentors();
        assertThat(all, is(notNullValue()));
        assertThat(all.size(), is(2));
    }

}
