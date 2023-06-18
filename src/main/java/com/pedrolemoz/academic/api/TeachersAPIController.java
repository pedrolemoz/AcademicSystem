package com.pedrolemoz.academic.api;

import com.pedrolemoz.academic.dtos.TeacherDTO;
import com.pedrolemoz.academic.models.DisciplineModel;
import com.pedrolemoz.academic.models.TeacherModel;
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
@RequestMapping("/teachers")
public class TeachersAPIController {
    final TeachersService teachersService;

    public TeachersAPIController(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid TeacherDTO teacherDTO) {
        if (teachersService.existsByDocumentNumber(teacherDTO.getDocumentNumber())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Já existe um professor cadastrado com este CPF");
        }

        var teacherModel = new TeacherModel();
        BeanUtils.copyProperties(teacherDTO, teacherModel);
        teacherModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(teachersService.save(teacherModel));
    }

    @GetMapping("/get_all")
    public ResponseEntity<Page<TeacherModel>> getAllTeachers(
            @PageableDefault(page = 0, size = 50, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(teachersService.findAll(pageable));
    }

    @GetMapping("/get_by_id")
    public ResponseEntity<Object> getTeacherById(@RequestParam UUID id) {
        Optional<TeacherModel> teacherModelOptional = teachersService.findById(id);

        if (!teacherModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um professor cadastrado com este id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(teacherModelOptional.get());
    }

    @DeleteMapping("/delete_by_id")
    public ResponseEntity<Object> deleteTeacherById(@RequestParam UUID id) {
        Optional<TeacherModel> teacherModelOptional = teachersService.findById(id);

        if (!teacherModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um professor cadastrado com este id");
        }

        var disciplines = teacherModelOptional.get().getDisciplines();

        for (DisciplineModel discipline : disciplines) {
            discipline.setTeacher(null);
        }

        teachersService.delete(teacherModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("Professor excluído com sucesso");
    }

    @PutMapping("/update_by_id")
    public ResponseEntity<Object> updateTeacher(
            @RequestParam UUID id,
            @RequestBody @Valid TeacherDTO teacherDTO) {
        Optional<TeacherModel> teacherModelOptional = teachersService.findById(id);

        if (!teacherModelOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um professor cadastrado com este id");
        }

        var teacherModel = new TeacherModel();
        BeanUtils.copyProperties(teacherDTO, teacherModel);
        teacherModel.setId(teacherModelOptional.get().getId());
        teacherModel.setRegistrationDate(teacherModelOptional.get().getRegistrationDate());

        var disciplines = teacherModelOptional.get().getDisciplines();
        if (disciplines != null) {
            teacherModel.setDisciplines(disciplines);
        }

        return ResponseEntity.status(HttpStatus.OK).body(teachersService.save(teacherModel));
    }
}
