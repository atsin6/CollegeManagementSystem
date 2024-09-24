package com.atsin.Week3Homework.CollegeManagementSystem.controllers;

import com.atsin.Week3Homework.CollegeManagementSystem.entities.ProfessorEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.services.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> getAllProfessors(){
        return professorService.getAllProfessors();
    }

    @GetMapping("/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId){
        return professorService.getProfessorById(professorId);
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity) {
        return professorService.createNewProfessor(professorEntity);
    }

    @PutMapping("/{professorId}/assignProfessor/{subjectId}")
    public ResponseEntity<ProfessorEntity> assignProfessorToSubject(@PathVariable Long professorId,
                                                    @PathVariable Long subjectId) {
        return ResponseEntity.ok(professorService.assignProfessorToSubject(professorId, subjectId));
    }


}
