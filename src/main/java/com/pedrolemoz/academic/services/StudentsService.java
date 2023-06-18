package com.pedrolemoz.academic.services;

import com.pedrolemoz.academic.models.StudentModel;
import com.pedrolemoz.academic.repositories.StudentsRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentsService {
    final StudentsRepository studentsRepository;

    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Transactional
    public StudentModel save(StudentModel studentModel) {
        return studentsRepository.save(studentModel);
    }

    public boolean existsByDocumentNumber(String documentNumber) {
        return studentsRepository.existsByDocumentNumber(documentNumber);
    }

    public Page<StudentModel> findAll(Pageable pageable) {
        return studentsRepository.findAll(pageable);
    }

    public Optional<StudentModel> findById(UUID id) {
        return studentsRepository.findById(id);
    }
    
    public void delete(StudentModel studentModel) {
        studentsRepository.delete(studentModel);
    }
}
