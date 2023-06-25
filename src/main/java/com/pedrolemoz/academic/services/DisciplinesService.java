package com.pedrolemoz.academic.services;

import com.pedrolemoz.academic.models.DisciplineModel;
import com.pedrolemoz.academic.repositories.DisciplinesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DisciplinesService {
    final DisciplinesRepository disciplinesRepository;

    public DisciplinesService(DisciplinesRepository disciplinesRepository) {
        this.disciplinesRepository = disciplinesRepository;
    }

    @Transactional
    public DisciplineModel save(DisciplineModel disciplineModel) {
        return disciplinesRepository.save(disciplineModel);
    }

    public List<DisciplineModel> findAll() {
        return disciplinesRepository.findAll();
    }

    public Optional<DisciplineModel> findById(UUID id) {
        return disciplinesRepository.findById(id);
    }

    public void delete(DisciplineModel disciplineModel) {
        disciplinesRepository.delete(disciplineModel);
    }
}
