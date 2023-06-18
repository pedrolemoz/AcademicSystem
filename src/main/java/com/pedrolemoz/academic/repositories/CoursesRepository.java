package com.pedrolemoz.academic.repositories;

import com.pedrolemoz.academic.models.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoursesRepository extends JpaRepository<CourseModel, UUID> {
}
