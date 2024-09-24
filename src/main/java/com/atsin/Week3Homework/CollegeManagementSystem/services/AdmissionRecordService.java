package com.atsin.Week3Homework.CollegeManagementSystem.services;

import com.atsin.Week3Homework.CollegeManagementSystem.entities.AdmissionRecordEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.entities.StudentEntity;
import com.atsin.Week3Homework.CollegeManagementSystem.repositories.AdmissionRecordRepository;
import com.atsin.Week3Homework.CollegeManagementSystem.repositories.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionRecordService {
    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
    }



    public ResponseEntity<List<AdmissionRecordEntity>> getAllAdmissionRecords() {
        return ResponseEntity.ok(admissionRecordRepository.findAll());
    }

    public ResponseEntity<AdmissionRecordEntity> getAdmissionRecordById(Long admissionRecordId) {
        return ResponseEntity.ok(admissionRecordRepository.findById(admissionRecordId).orElse(null));
    }

    public ResponseEntity<AdmissionRecordEntity> addAdmissionRecord(AdmissionRecordEntity admissionRecord) {
        return ResponseEntity.ok(admissionRecordRepository.save(admissionRecord));
    }

    public AdmissionRecordEntity addStudentToAdmissionRecord(Long admissionRecordId, Long studentId) {
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionRecordId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return admissionRecordEntity.flatMap(admissionRecord ->
                studentEntity.map(student ->{
                    admissionRecord.setStudent(student);
                    return admissionRecordRepository.save(admissionRecord);
                })).orElse(null);
    }
}
