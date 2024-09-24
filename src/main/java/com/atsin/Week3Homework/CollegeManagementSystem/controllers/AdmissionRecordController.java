package com.atsin.Week3Homework.CollegeManagementSystem.controllers;

import com.atsin.Week3Homework.CollegeManagementSystem.entities.AdmissionRecordEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.services.AdmissionRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admissionRecords")
public class AdmissionRecordController {
    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping
    public ResponseEntity<List<AdmissionRecordEntity>> getAllAdmissionRecords() {
        return admissionRecordService.getAllAdmissionRecords();
    }

    @GetMapping ("/{admissionRecordId}")
    public ResponseEntity<AdmissionRecordEntity> getAdmissionRecordById(@PathVariable Long admissionRecordId) {
        return admissionRecordService.getAdmissionRecordById(admissionRecordId);
    }

    @PostMapping
    public ResponseEntity<AdmissionRecordEntity> addAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecord) {
        return admissionRecordService.addAdmissionRecord(admissionRecord);
    }


    @PutMapping("/{admissionRecordId}/getNewAdmission/{studentId}")
    public AdmissionRecordEntity getNewAdmission(@PathVariable Long admissionRecordId,
                                                                 @PathVariable Long studentId) {
        return admissionRecordService.addStudentToAdmissionRecord(admissionRecordId, studentId);
    }



}
