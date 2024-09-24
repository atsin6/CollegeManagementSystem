package com.atsin.Week3Homework.CollegeManagementSystem.services;

import com.atsin.Week3Homework.CollegeManagementSystem.entities.ProfessorEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.entities.SubjectEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.repositories.ProfessorRepository;
import com.atsin.Week3Homework.CollegeManagementSystem.repositories.SubjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;

    public SubjectService(SubjectRepository subjectRepository, ProfessorRepository professorRepository) {
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
    }

    public SubjectEntity addSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public ResponseEntity<List<SubjectEntity>> getAllSubjects() {
        return ResponseEntity.ok(subjectRepository.findAll());
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

}
