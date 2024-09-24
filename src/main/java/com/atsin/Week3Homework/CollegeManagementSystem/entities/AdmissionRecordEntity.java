package com.atsin.Week3Homework.CollegeManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admission_record")
@Builder
public class AdmissionRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer admissionFees;

    @OneToOne
    @JoinColumn(name = "admissionRecord")
    private StudentEntity student;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdmissionRecordEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAdmissionFees(), that.getAdmissionFees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAdmissionFees());
    }
}
