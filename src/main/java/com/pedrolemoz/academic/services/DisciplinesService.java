package com.pedrolemoz.academic.services;

import com.pedrolemoz.academic.models.DisciplineModel;
import com.pedrolemoz.academic.repositories.DisciplinesRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<DisciplineModel> findAll(Pageable pageable) {
        return disciplinesRepository.findAll(pageable);
    }

    public Optional<DisciplineModel> findById(UUID id) {
        return disciplinesRepository.findById(id);
    }
    
    public void delete(DisciplineModel disciplineModel) {
        disciplinesRepository.delete(disciplineModel);
    }
}
