package com.pedrolemoz.academic.repositories;

import com.pedrolemoz.academic.models.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeachersRepository extends JpaRepository<TeacherModel, UUID> {
    boolean existsByDocumentNumber(String documentNumber);
}
