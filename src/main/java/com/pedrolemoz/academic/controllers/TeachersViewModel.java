package com.pedrolemoz.academic.controllers;

import com.pedrolemoz.academic.dtos.TeacherDTO;
import com.pedrolemoz.academic.models.DisciplineModel;
import com.pedrolemoz.academic.models.TeacherModel;
import com.pedrolemoz.academic.services.TeachersService;
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
@RequestMapping("/teachers")
public class TeachersViewModel {
    final TeachersService teachersService;

    public TeachersViewModel(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    @GetMapping("/list_all_teachers")
    public ModelAndView listAllTeachersGetRequest() {
        ModelAndView modelAndView = new ModelAndView("/teachers/list_all_teachers");
        var teachers = teachersService.findAll();
        modelAndView.addObject("teachers", teachers);
        return modelAndView;
    }

    @GetMapping("/create_new_teacher")
    public ModelAndView createNewTeacherGetRequest() {
        return new ModelAndView("/teachers/create_new_teacher");
    }

    @PostMapping("/create_new_teacher")
    public ModelAndView createNewTeacherPostRequest(TeacherDTO teacherDTO) {
        ModelAndView modelAndView = new ModelAndView("/teachers/list_all_teachers");

        if (teachersService.existsByDocumentNumber(teacherDTO.getDocumentNumber())) {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Já existe um professor cadastrado com este CPF");
            return modelAndView;
        }

        var teacherModel = new TeacherModel();
        BeanUtils.copyProperties(teacherDTO, teacherModel);
        teacherModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        teachersService.save(teacherModel);

        var teachers = teachersService.findAll();
        modelAndView.addObject("teachers", teachers);

        return modelAndView;
    }

    @GetMapping("/edit_existing_teacher/{id}")
    public ModelAndView editExistingTeacherGetRequest(@PathVariable("id") UUID id) {
        var modelAndView = new ModelAndView("/teachers/edit_existing_teacher");
        Optional<TeacherModel> teacherModelOptional = teachersService.findById(id);

        if (teacherModelOptional.isPresent()) {
            modelAndView.addObject("teacher", teacherModelOptional.get());
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Professor não encontrado");
        }

        return modelAndView;
    }

    @PostMapping("/edit_existing_teacher")
    public ModelAndView editExistingTeacherPostRequest(TeacherDTO teacherDTO) {
        ModelAndView modelAndView = new ModelAndView("/teachers/list_all_teachers");

        Optional<TeacherModel> teacherModelOptional = teachersService.findById(teacherDTO.getUUID());

        if (!teacherModelOptional.isPresent()) {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Não existe um professor cadastrado com este CPF");
            return modelAndView;
        }

        var teacherModel = new TeacherModel();
        BeanUtils.copyProperties(teacherDTO, teacherModel);
        teacherModel.setId(teacherModelOptional.get().getId());
        teacherModel.setRegistrationDate(teacherModelOptional.get().getRegistrationDate());

        var disciplines = teacherModelOptional.get().getDisciplines();
        if (disciplines != null) {
            teacherModel.setDisciplines(disciplines);
        }

        teachersService.save(teacherModel);
        
        var teachers = teachersService.findAll();
        modelAndView.addObject("teachers", teachers);

        return modelAndView;
    }

    @GetMapping("/view_teacher/{id}")
    public ModelAndView viewTeacherGetRequest(@PathVariable("id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("/teachers/view_teacher");
        Optional<TeacherModel> teacherModelOptional = teachersService.findById(id);

        if (teacherModelOptional.isPresent()) {
            modelAndView.addObject("teacher", teacherModelOptional.get());
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Professor não encontrado");
        }

        return modelAndView;
    }

    @GetMapping("/delete_existing_teacher/{id}")
    public String deleteTeacherGetRequest(@PathVariable("id") UUID id) {
        Optional<TeacherModel> teacherModelOptional = teachersService.findById(id);

        if (teacherModelOptional.isPresent()) {
            var disciplines = teacherModelOptional.get().getDisciplines();

            for (DisciplineModel discipline : disciplines) {
                discipline.setTeacher(null);
            }

            teachersService.delete(teacherModelOptional.get());
        }

        return "redirect:/teachers/list_all_teachers";
    }
}
