package com.pedrolemoz.academic.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pedrolemoz.academic.configurations.CustomCourseModelSerializer;
import com.pedrolemoz.academic.configurations.CustomTeacherModelSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "disciplines")
public class DisciplineModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer semester;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @JsonSerialize(using = CustomTeacherModelSerializer.class)
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherModel teacher;

    @JsonSerialize(using = CustomCourseModelSerializer.class)
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseModel course;

    @JsonBackReference
    @ManyToMany
    private List<StudentModel> students;
}
