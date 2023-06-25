package com.pedrolemoz.academic.services;

import com.pedrolemoz.academic.models.TeacherModel;
import com.pedrolemoz.academic.repositories.TeachersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<TeacherModel> findAll() {
        return teachersRepository.findAll();
    }

    public Optional<TeacherModel> findById(UUID id) {
        return teachersRepository.findById(id);
    }

    public void delete(TeacherModel teacherModel) {
        teachersRepository.delete(teacherModel);
    }
}
