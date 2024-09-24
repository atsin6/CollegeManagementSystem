package com.atsin.Week3Homework.CollegeManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professors")
@Builder
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "professors", fetch = FetchType.LAZY)
    private Set<SubjectEntity> subjects;

    @ManyToMany
    @JoinTable(name = "who_teaches_whom",
            joinColumns = @JoinColumn(name = "professorId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )
    @JsonIgnore
    private Set<StudentEntity> students;


    //----------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
