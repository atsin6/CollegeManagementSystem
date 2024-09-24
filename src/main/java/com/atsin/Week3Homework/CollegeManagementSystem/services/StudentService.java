package com.atsin.Week3Homework.CollegeManagementSystem.services;

import com.atsin.Week3Homework.CollegeManagementSystem.entities.ProfessorEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.entities.StudentEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.entities.SubjectEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.repositories.ProfessorRepository;
import com.atsin.Week3Homework.CollegeManagementSystem.repositories.StudentRepository;
import com.atsin.Week3Homework.CollegeManagementSystem.repositories.SubjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    public StudentService(StudentRepository studentRepository, ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }

    public ResponseEntity<StudentEntity> addStudent(StudentEntity studentEntity) {
        return ResponseEntity.ok(studentRepository.save(studentEntity));
    }

    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    public ResponseEntity<StudentEntity> getStudentById(Long studentId) {
        return ResponseEntity.ok(studentRepository.findById(studentId).orElse(null));
    }

    public ResponseEntity<StudentEntity> assignProfessorToStudent(Long studentId, Long professorId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);

        return studentEntity.flatMap(student ->
                professorEntity.map(professor ->{
                    professor.getStudents().add(student);
                    professorRepository.save(professor);

                    student.getProfessors().add(professor);
                    return ResponseEntity.ok(student);
                })).orElse(null);
    }

    public ResponseEntity<StudentEntity> assignSubjectToStudent(Long studentId, Long subjectId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return studentEntity.flatMap(student ->
                subjectEntity.map(subject -> {
                    subject.getWhoStudies().add(student);
                    subjectRepository.save(subject);

                    student.getMySubjects().add(subject);
                    return ResponseEntity.ok(student);
                })).orElse(null);
    }
}
