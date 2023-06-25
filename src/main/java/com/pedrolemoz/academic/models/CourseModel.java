package com.pedrolemoz.academic.models;

import com.pedrolemoz.academic.enumerators.Degree;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<DisciplineModel> disciplines;

    public String getDegreeAsString() {
        return switch (this.degree) {
            case Bachelor -> "Bacharelado";
            case Licentiate -> "Licenciatura";
            case Master -> "Mestrado";
            case Doctorate -> "Doutorado";
        };
    }
}
