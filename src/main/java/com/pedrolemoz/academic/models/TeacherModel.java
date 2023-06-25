package com.pedrolemoz.academic.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "teachers")
public class TeacherModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @Column(nullable = false, unique = true)
    private String documentNumber;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<DisciplineModel> disciplines;

    public String getFormattedDocumentNumber() {
        return documentNumber.substring(0, 3) + "."
                + documentNumber.substring(3, 6) + "."
                + documentNumber.substring(6, 9) + "-"
                + documentNumber.substring(9);
    }
}
