package com.pedrolemoz.academic.api;

import com.pedrolemoz.academic.dtos.DisciplineDTO;
import com.pedrolemoz.academic.models.CourseModel;
import com.pedrolemoz.academic.models.DisciplineModel;
import com.pedrolemoz.academic.models.StudentModel;
import com.pedrolemoz.academic.models.TeacherModel;
import com.pedrolemoz.academic.services.CoursesService;
import com.pedrolemoz.academic.services.DisciplinesService;
import com.pedrolemoz.academic.services.StudentsService;
import com.pedrolemoz.academic.services.TeachersService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/disciplines")
public class DisciplinesAPIController {
    final DisciplinesService disciplinesService;
    final TeachersService teachersService;
    final CoursesService coursesService;
    final StudentsService studentsService;

    public DisciplinesAPIController(
            DisciplinesService disciplinesService,
            TeachersService teachersService,
            CoursesService coursesService,
            StudentsService studentsService
    ) {
        this.disciplinesService = disciplinesService;
        this.teachersService = teachersService;
        this.coursesService = coursesService;
        this.studentsService = studentsService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid DisciplineDTO disciplineDTO) {
        var disciplineModel = new DisciplineModel();
        BeanUtils.copyProperties(disciplineDTO, disciplineModel);
        disciplineModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinesService.save(disciplineModel));
    }

    @PostMapping("/assign_teacher")
    public ResponseEntity<Object> assignTeacher(
            @RequestParam UUID disciplineId,
            @RequestParam UUID teacherId
    ) {
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(disciplineId);

        if (!disciplineModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrada uma disciplina cadastrada com este id");
        }

        Optional<TeacherModel> teacherModelOptional = teachersService.findById(teacherId);

        if (!teacherModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um professor cadastrado com este id");
        }

        var disciplineModel = new DisciplineModel();
        BeanUtils.copyProperties(disciplineModelOptional.get(), disciplineModel);
        disciplineModel.setTeacher(teacherModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body(disciplinesService.save(disciplineModel));
    }

    @PostMapping("/assign_course")
    public ResponseEntity<Object> assignDiscipline(
            @RequestParam UUID disciplineId,
            @RequestParam UUID courseId
    ) {
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(disciplineId);

        if (!disciplineModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrada uma disciplina cadastrada com este id");
        }

        Optional<CourseModel> courseModelOptional = coursesService.findById(courseId);

        if (!courseModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um curso cadastrado com este id");
        }

        var disciplineModel = new DisciplineModel();
        BeanUtils.copyProperties(disciplineModelOptional.get(), disciplineModel);
        disciplineModel.setCourse(courseModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body(disciplinesService.save(disciplineModel));
    }

    @PostMapping("/assign_student")
    public ResponseEntity<Object> assignStudent(
            @RequestParam UUID disciplineId,
            @RequestParam UUID studentId
    ) {
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(disciplineId);

        if (!disciplineModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrada uma disciplina cadastrada com este id");
        }

        Optional<StudentModel> studentModelOptional = studentsService.findById(studentId);

        if (!studentModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um estudante cadastrado com este id");
        }

        var disciplineModel = new DisciplineModel();
        BeanUtils.copyProperties(disciplineModelOptional.get(), disciplineModel);
        var students = disciplineModelOptional.get().getStudents();
        students.add(studentModelOptional.get());
        disciplineModel.setStudents(students);

        return ResponseEntity.status(HttpStatus.OK).body(disciplinesService.save(disciplineModel));
    }

    @GetMapping("/get_all")
    public ResponseEntity<Page<DisciplineModel>> getAllDisciplines(
            @PageableDefault(page = 0, size = 50, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinesService.findAll(pageable));
    }

    @GetMapping("/get_by_id")
    public ResponseEntity<Object> getDisciplineById(@RequestParam UUID id) {
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(id);

        if (!disciplineModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrada uma disciplina cadastrada com este id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(disciplineModelOptional.get());
    }

    @DeleteMapping("/delete_by_id")
    public ResponseEntity<Object> deleteDisciplineById(@RequestParam UUID id) {
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(id);

        if (!disciplineModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrada uma disciplina cadastrada com este id");
        }

        disciplinesService.delete(disciplineModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina excluída com sucesso");
    }

    @PutMapping("/update_by_id")
    public ResponseEntity<Object> updateDiscipline(
            @RequestParam UUID id,
            @RequestBody @Valid DisciplineDTO disciplineDTO) {
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(id);

        if (!disciplineModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrada uma disciplina cadastrada com este id");
        }

        var disciplineModel = new DisciplineModel();
        BeanUtils.copyProperties(disciplineDTO, disciplineModel);
        disciplineModel.setId(disciplineModelOptional.get().getId());
        disciplineModel.setRegistrationDate(disciplineModelOptional.get().getRegistrationDate());

        var course = disciplineModelOptional.get().getCourse();
        if (course != null) {
            disciplineModel.setCourse(course);
        }

        var teacher = disciplineModelOptional.get().getTeacher();
        if (teacher != null) {
            disciplineModel.setTeacher(teacher);
        }

        var students = disciplineModelOptional.get().getStudents();
        if (students != null) {
            disciplineModel.setStudents(students);
        }

        return ResponseEntity.status(HttpStatus.OK).body(disciplinesService.save(disciplineModel));
    }
}
