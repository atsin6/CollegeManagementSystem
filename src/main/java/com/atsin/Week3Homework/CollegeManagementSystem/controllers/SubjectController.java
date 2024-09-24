package com.atsin.Week3Homework.CollegeManagementSystem.controllers;

import com.atsin.Week3Homework.CollegeManagementSystem.entities.ProfessorEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.entities.SubjectEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.services.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<List<SubjectEntity>> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public SubjectEntity addSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.addSubject(subjectEntity);
    }



}
