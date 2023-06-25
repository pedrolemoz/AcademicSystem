package com.pedrolemoz.academic.controllers;

import com.pedrolemoz.academic.dtos.StudentDTO;
import com.pedrolemoz.academic.models.StudentModel;
import com.pedrolemoz.academic.services.StudentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/students")
public class StudentsViewModel {
    final StudentsService studentsService;

    public StudentsViewModel(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/list_all_students")
    public ModelAndView listAllStudentsGetRequest() {
        ModelAndView modelAndView = new ModelAndView("/students/list_all_students");
        var students = studentsService.findAll();
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/create_new_student")
    public ModelAndView createNewStudentGetRequest() {
        return new ModelAndView("/students/create_new_student");
    }

    @PostMapping("/create_new_student")
    public ModelAndView createNewStudentPostRequest(StudentDTO studentDTO) {
        ModelAndView modelAndView = new ModelAndView("/students/list_all_students");

        if (studentsService.existsByDocumentNumber(studentDTO.getDocumentNumber())) {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Já existe um estudante cadastrado com este CPF");
            return modelAndView;
        }


        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDTO, studentModel);
        studentModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        studentsService.save(studentModel);

        var students = studentsService.findAll();
        modelAndView.addObject("students", students);

        return modelAndView;
    }

    @GetMapping("/edit_existing_student/{id}")
    public ModelAndView editExistingStudentGetRequest(@PathVariable("id") UUID id) {
        var modelAndView = new ModelAndView("/students/edit_existing_student");
        Optional<StudentModel> studentModelOptional = studentsService.findById(id);

        if (studentModelOptional.isPresent()) {
            modelAndView.addObject("student", studentModelOptional.get());
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Estudante não encontrado");
        }

        return modelAndView;
    }

    @PostMapping("/edit_existing_student")
    public ModelAndView editExistingStudentPostRequest(StudentDTO studentDTO) {
        ModelAndView modelAndView = new ModelAndView("/students/list_all_students");

        if (!studentsService.existsByDocumentNumber(studentDTO.getDocumentNumber())) {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Não existe um estudante cadastrado com este CPF");
            return modelAndView;
        }

        var studentModel = new StudentModel();
        studentModel.setId(studentDTO.getUUID());
        BeanUtils.copyProperties(studentDTO, studentModel);
        studentModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        studentsService.save(studentModel);

        var students = studentsService.findAll();
        modelAndView.addObject("students", students);

        return modelAndView;
    }

    @GetMapping("/view_student/{id}")
    public ModelAndView viewStudentGetRequest(@PathVariable("id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("/students/view_student");
        Optional<StudentModel> studentModelOptional = studentsService.findById(id);

        if (studentModelOptional.isPresent()) {
            modelAndView.addObject("student", studentModelOptional.get());
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Estudante não encontrado");
        }

        return modelAndView;
    }
}
