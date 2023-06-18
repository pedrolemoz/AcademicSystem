package com.pedrolemoz.academic.repositories;

import com.pedrolemoz.academic.models.DisciplineModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DisciplinesRepository extends JpaRepository<DisciplineModel, UUID> {
}
