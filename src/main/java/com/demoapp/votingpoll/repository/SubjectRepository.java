package com.demoapp.votingpoll.repository;

import com.demoapp.votingpoll.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findByName(String name);
}