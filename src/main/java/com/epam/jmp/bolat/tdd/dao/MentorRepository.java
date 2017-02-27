package com.epam.jmp.bolat.tdd.dao;

import com.epam.jmp.bolat.tdd.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dom on 25.02.2017.
 */
public interface MentorRepository  extends JpaRepository<Mentor,Long> {
    Mentor findOneByName(String name);
}
