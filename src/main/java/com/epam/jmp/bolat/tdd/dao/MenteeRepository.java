package com.epam.jmp.bolat.tdd.dao;

import com.epam.jmp.bolat.tdd.model.Mentee;
import com.epam.jmp.bolat.tdd.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dom on 25.02.2017.
 */
public interface MenteeRepository extends JpaRepository<Mentee,Long> {
}
