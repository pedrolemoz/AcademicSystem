package com.pedrolemoz.academic.controllers;

import com.pedrolemoz.academic.dtos.StudentDTO;
import com.pedrolemoz.academic.models.StudentModel;
import com.pedrolemoz.academic.services.StudentsService;
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
@RequestMapping("/students")
public class StudentsController {
    final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid StudentDTO studentDTO) {
        if (studentsService.existsByDocumentNumber(studentDTO.getDocumentNumber())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Já existe um estudante cadastrado com este CPF");
        }

        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDTO, studentModel);
        studentModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(studentsService.save(studentModel));
    }

    @GetMapping("/get_all")
    public ResponseEntity<Page<StudentModel>> getAllStudents(
            @PageableDefault(page = 0, size = 50, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.findAll(pageable));
    }

    @GetMapping("/get_by_id")
    public ResponseEntity<Object> getStudentById(@RequestParam UUID id) {
        Optional<StudentModel> studentModelOptional = studentsService.findById(id);

        if (!studentModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um estudante cadastrado com este id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentModelOptional.get());
    }

    @DeleteMapping("/delete_by_id")
    public ResponseEntity<Object> deleteStudentById(@RequestParam UUID id) {
        Optional<StudentModel> studentModelOptional = studentsService.findById(id);

        if (!studentModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um estudante cadastrado com este id");
        }

        studentsService.delete(studentModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Estudante excluído com sucesso");
    }

    @PutMapping("/update_by_id")
    public ResponseEntity<Object> updateStudent(
            @RequestParam UUID id,
            @RequestBody @Valid StudentDTO studentDTO) {
        Optional<StudentModel> studentModelOptional = studentsService.findById(id);

        if (!studentModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um estudante cadastrado com este id");
        }

        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDTO, studentModel);
        studentModel.setId(studentModelOptional.get().getId());
        studentModel.setRegistrationDate(studentModelOptional.get().getRegistrationDate());

        var disciplines = studentModelOptional.get().getDisciplines();
        if (disciplines != null) {
            studentModel.setDisciplines(disciplines);
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentsService.save(studentModel));
    }
}
