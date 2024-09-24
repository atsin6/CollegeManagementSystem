package com.atsin.Week3Homework.CollegeManagementSystem.repositories;

import com.atsin.Week3Homework.CollegeManagementSystem.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}
