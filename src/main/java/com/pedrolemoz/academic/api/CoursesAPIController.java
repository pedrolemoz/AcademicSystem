package com.pedrolemoz.academic.api;

import com.pedrolemoz.academic.dtos.CourseDTO;
import com.pedrolemoz.academic.models.CourseModel;
import com.pedrolemoz.academic.models.DisciplineModel;
import com.pedrolemoz.academic.services.CoursesService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/courses")
public class CoursesAPIController {
    final CoursesService coursesService;

    public CoursesAPIController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid CourseDTO courseDTO) {
        var courseModel = new CourseModel();
        BeanUtils.copyProperties(courseDTO, courseModel);
        courseModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(coursesService.save(courseModel));
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<CourseModel>> getAllCourses() {
        return ResponseEntity.status(HttpStatus.OK).body(coursesService.findAll());
    }

    @GetMapping("/get_by_id")
    public ResponseEntity<Object> getCourseById(@RequestParam UUID id) {
        Optional<CourseModel> courseModelOptional = coursesService.findById(id);

        if (!courseModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um curso cadastrado com este id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(courseModelOptional.get());
    }

    @DeleteMapping("/delete_by_id")
    public ResponseEntity<Object> deleteCourseById(@RequestParam UUID id) {
        Optional<CourseModel> courseModelOptional = coursesService.findById(id);

        if (!courseModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um curso cadastrado com este id");
        }

        var disciplines = courseModelOptional.get().getDisciplines();

        for (DisciplineModel discipline : disciplines) {
            discipline.setCourse(null);
        }

        coursesService.delete(courseModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("Curso excluído com sucesso");
    }

    @PutMapping("/update_by_id")
    public ResponseEntity<Object> updateCourse(
            @RequestParam UUID id,
            @RequestBody @Valid CourseDTO courseDTO) {
        Optional<CourseModel> courseModelOptional = coursesService.findById(id);

        if (!courseModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um curso cadastrado com este id");
        }

        var courseModel = new CourseModel();
        BeanUtils.copyProperties(courseDTO, courseModel);
        courseModel.setId(courseModelOptional.get().getId());
        courseModel.setRegistrationDate(courseModelOptional.get().getRegistrationDate());

        var disciplines = courseModelOptional.get().getDisciplines();
        if (disciplines != null) {
            courseModel.setDisciplines(disciplines);
        }

        return ResponseEntity.status(HttpStatus.OK).body(coursesService.save(courseModel));
    }
}
