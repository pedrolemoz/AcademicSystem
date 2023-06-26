package com.pedrolemoz.academic.controllers;

import com.pedrolemoz.academic.dtos.CourseDTO;
import com.pedrolemoz.academic.models.CourseModel;
import com.pedrolemoz.academic.services.CoursesService;
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
@RequestMapping("/courses")
public class CoursesViewModel {
    final CoursesService coursesService;

    public CoursesViewModel(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping("/list_all_courses")
    public ModelAndView listAllCoursesGetRequest() {
        ModelAndView modelAndView = new ModelAndView("/courses/list_all_courses");
        var courses = coursesService.findAll();
        modelAndView.addObject("courses", courses);
        return modelAndView;
    }

    @GetMapping("/create_new_course")
    public ModelAndView createNewCourseGetRequest() {
        return new ModelAndView("/courses/create_new_course");
    }

    @PostMapping("/create_new_course")
    public String createNewCoursePostRequest(CourseDTO courseDTO) {
        var courseModel = new CourseModel();
        BeanUtils.copyProperties(courseDTO, courseModel);
        courseModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        coursesService.save(courseModel);
        return "redirect:/courses/list_all_courses";
    }

    @GetMapping("/edit_existing_course/{id}")
    public ModelAndView editExistingCourseGetRequest(@PathVariable("id") UUID id) {
        var modelAndView = new ModelAndView("/courses/edit_existing_course");
        Optional<CourseModel> courseModelOptional = coursesService.findById(id);

        if (courseModelOptional.isPresent()) {
            modelAndView.addObject("course", courseModelOptional.get());
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Curso não encontrado");
        }

        return modelAndView;
    }

    @PostMapping("/edit_existing_course")
    public ModelAndView editExistingCoursePostRequest(CourseDTO courseDTO) {
        ModelAndView modelAndView = new ModelAndView("/courses/list_all_courses");

        var courseModel = new CourseModel();
        courseModel.setId(courseDTO.getUUID());
        BeanUtils.copyProperties(courseDTO, courseModel);
        courseModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        coursesService.save(courseModel);

        var courses = coursesService.findAll();
        modelAndView.addObject("courses", courses);

        return modelAndView;
    }

    @GetMapping("/view_course/{id}")
    public ModelAndView viewCourseGetRequest(@PathVariable("id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("/courses/view_course");
        Optional<CourseModel> courseModelOptional = coursesService.findById(id);

        if (courseModelOptional.isPresent()) {
            modelAndView.addObject("course", courseModelOptional.get());
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Curso não encontrado");
        }

        return modelAndView;
    }
}
