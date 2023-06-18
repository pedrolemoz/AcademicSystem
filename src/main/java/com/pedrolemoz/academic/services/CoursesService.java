package com.pedrolemoz.academic.services;

import com.pedrolemoz.academic.models.CourseModel;
import com.pedrolemoz.academic.repositories.CoursesRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CoursesService {
    final CoursesRepository coursesRepository;

    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Transactional
    public CourseModel save(CourseModel courseModel) {
        return coursesRepository.save(courseModel);
    }

    public Page<CourseModel> findAll(Pageable pageable) {
        return coursesRepository.findAll(pageable);
    }

    public Optional<CourseModel> findById(UUID id) {
        return coursesRepository.findById(id);
    }

    public void delete(CourseModel courseModel) {
        coursesRepository.delete(courseModel);
    }
}
