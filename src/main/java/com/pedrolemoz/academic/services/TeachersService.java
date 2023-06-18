package com.pedrolemoz.academic.services;

import com.pedrolemoz.academic.models.TeacherModel;
import com.pedrolemoz.academic.repositories.TeachersRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TeachersService {
    final TeachersRepository teachersRepository;

    public TeachersService(TeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }

    @Transactional
    public TeacherModel save(TeacherModel teacherModel) {
        return teachersRepository.save(teacherModel);
    }

    public boolean existsByDocumentNumber(String documentNumber) {
        return teachersRepository.existsByDocumentNumber(documentNumber);
    }

    public Page<TeacherModel> findAll(Pageable pageable) {
        return teachersRepository.findAll(pageable);
    }

    public Optional<TeacherModel> findById(UUID id) {
        return teachersRepository.findById(id);
    }
    
    public void delete(TeacherModel teacherModel) {
        teachersRepository.delete(teacherModel);
    }
}
