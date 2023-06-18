package com.pedrolemoz.academic.repositories;

import com.pedrolemoz.academic.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentsRepository extends JpaRepository<StudentModel, UUID> {
    boolean existsByDocumentNumber(String documentNumber);
}
