package com.atsin.Week3Homework.CollegeManagementSystem.controllers;

import com.atsin.Week3Homework.CollegeManagementSystem.entities.ProfessorEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.entities.StudentEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity studentEntity){
        return studentService.addStudent(studentEntity);
    }

    @PutMapping("/{studentId}/assignProfessor/{professorId}")
    public ResponseEntity<StudentEntity> assignProfessorToStudent(@PathVariable Long studentId,
                                                                  @PathVariable Long professorId){
        return studentService.assignProfessorToStudent(studentId, professorId);
    }

    @PutMapping("/{studentId}/assignSubject/{subjectId}")
    public ResponseEntity<StudentEntity> assignSubjectToStudent(@PathVariable Long studentId,
                                                                @PathVariable Long subjectId){
        return studentService.assignSubjectToStudent(studentId, subjectId);
    }
}
