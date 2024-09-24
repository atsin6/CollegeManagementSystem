package com.atsin.Week3Homework.CollegeManagementSystem.services;

import com.atsin.Week3Homework.CollegeManagementSystem.entities.ProfessorEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.entities.SubjectEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.repositories.ProfessorRepository;
import com.atsin.Week3Homework.CollegeManagementSystem.repositories.SubjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ResponseEntity<List<ProfessorEntity>> getAllProfessors() {
        return ResponseEntity.ok(professorRepository.findAll());
    }

    public ProfessorEntity getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity assignProfessorToSubject(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return professorEntity.flatMap(professor ->
            subjectEntity.map(subject ->{
                subject.getProfessors().add(professor);
                subjectRepository.save(subject);


                professor.getSubjects().add(subject);
                return professor;
            })
        ).orElse(null);
    }

}
