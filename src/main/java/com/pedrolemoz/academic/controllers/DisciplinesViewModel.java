package com.pedrolemoz.academic.controllers;

import com.pedrolemoz.academic.dtos.DisciplineDTO;
import com.pedrolemoz.academic.models.CourseModel;
import com.pedrolemoz.academic.models.DisciplineModel;
import com.pedrolemoz.academic.models.TeacherModel;
import com.pedrolemoz.academic.services.CoursesService;
import com.pedrolemoz.academic.services.DisciplinesService;
import com.pedrolemoz.academic.services.StudentsService;
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
@RequestMapping("/disciplines")
public class DisciplinesViewModel {
    final DisciplinesService disciplinesService;
    final StudentsService studentsService;

    final TeachersService teachersService;
    final CoursesService coursesService;


    public DisciplinesViewModel(DisciplinesService disciplinesService, StudentsService studentsService, TeachersService teachersService, CoursesService coursesService) {
        this.disciplinesService = disciplinesService;
        this.studentsService = studentsService;
        this.teachersService = teachersService;
        this.coursesService = coursesService;
    }

    @GetMapping("/list_all_disciplines")
    public ModelAndView listAllDisciplinesGetRequest() {
        ModelAndView modelAndView = new ModelAndView("/disciplines/list_all_disciplines");
        var disciplines = disciplinesService.findAll();
        modelAndView.addObject("disciplines", disciplines);
        return modelAndView;
    }

    @GetMapping("/create_new_discipline")
    public ModelAndView createNewDisciplineGetRequest() {
        return new ModelAndView("/disciplines/create_new_discipline");
    }

    @PostMapping("/create_new_discipline")
    public ModelAndView createNewDisciplinePostRequest(DisciplineDTO disciplineDTO) {
        ModelAndView modelAndView = new ModelAndView("/disciplines/list_all_disciplines");

        var disciplineModel = new DisciplineModel();
        BeanUtils.copyProperties(disciplineDTO, disciplineModel);
        disciplineModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        disciplinesService.save(disciplineModel);

        var disciplines = disciplinesService.findAll();
        modelAndView.addObject("disciplines", disciplines);

        return modelAndView;
    }

    @GetMapping("/edit_existing_discipline/{id}")
    public ModelAndView editExistingDisciplineGetRequest(@PathVariable("id") UUID id) {
        var modelAndView = new ModelAndView("/disciplines/edit_existing_discipline");
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(id);

        if (disciplineModelOptional.isPresent()) {
            modelAndView.addObject("discipline", disciplineModelOptional.get());
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Disciplina não encontrada");
        }

        return modelAndView;
    }

    @PostMapping("/edit_existing_discipline")
    public ModelAndView editExistingDisciplinePostRequest(DisciplineDTO disciplineDTO) {
        ModelAndView modelAndView = new ModelAndView("/disciplines/list_all_disciplines");

        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(disciplineDTO.getUUID());

        if (!disciplineModelOptional.isPresent()) {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Disciplina não encontrada");
            return modelAndView;
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

        disciplinesService.save(disciplineModel);

        var disciplines = disciplinesService.findAll();
        modelAndView.addObject("disciplines", disciplines);

        return modelAndView;
    }

    @GetMapping("/view_discipline/{id}")
    public ModelAndView viewDisciplineGetRequest(@PathVariable("id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("/disciplines/view_discipline");
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(id);

        if (disciplineModelOptional.isPresent()) {
            modelAndView.addObject("discipline", disciplineModelOptional.get());
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Disciplina não encontrada");
        }

        return modelAndView;
    }

    @GetMapping("/delete_existing_discipline/{id}")
    public String deleteDisciplineGetRequest(@PathVariable("id") UUID id) {
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(id);

        if (disciplineModelOptional.isPresent()) {
            disciplinesService.delete(disciplineModelOptional.get());
        }

        return "redirect:/disciplines/list_all_disciplines";
    }

    @GetMapping("/list_teachers/{id}")
    public ModelAndView listTeachersGetRequest(@PathVariable("id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("/disciplines/assign_teacher_to_discipline");
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(id);

        if (disciplineModelOptional.isPresent()) {
            var teachers = teachersService.findAll();
            modelAndView.addObject("discipline", disciplineModelOptional.get());
            modelAndView.addObject("teachers", teachers);
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Disciplina não encontrada");
            return modelAndView;
        }

        return modelAndView;
    }

    @GetMapping("/assign_teacher_to_discipline/{disciplineId}/{teacherId}")
    public ModelAndView assignTeacherToDisciplineGetRequest(
            @PathVariable("disciplineId") UUID disciplineId,
            @PathVariable("teacherId") UUID teacherId
    ) {
        ModelAndView modelAndView = new ModelAndView("/disciplines/view_discipline");
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(disciplineId);
        Optional<TeacherModel> teacherModelOptional = teachersService.findById(teacherId);

        if (!disciplineModelOptional.isPresent()) {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Disciplina não encontrada");
            return modelAndView;
        }

        if (!teacherModelOptional.isPresent()) {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Professor não encontrado");
            return modelAndView;
        }

        var disciplineModel = new DisciplineModel();
        BeanUtils.copyProperties(disciplineModelOptional.get(), disciplineModel);
        disciplineModel.setTeacher(teacherModelOptional.get());

        disciplinesService.save(disciplineModel);

        modelAndView.addObject("discipline", disciplineModel);

        return modelAndView;
    }

    @GetMapping("/list_courses/{id}")
    public ModelAndView listCoursesGetRequest(@PathVariable("id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("/disciplines/assign_course_to_discipline");
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(id);

        if (disciplineModelOptional.isPresent()) {
            var courses = coursesService.findAll();
            modelAndView.addObject("discipline", disciplineModelOptional.get());
            modelAndView.addObject("courses", courses);
        } else {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Disciplina não encontrada");
            return modelAndView;
        }

        return modelAndView;
    }

    @GetMapping("/assign_course_to_discipline/{disciplineId}/{courseId}")
    public ModelAndView assignCourseToDisciplineGetRequest(
            @PathVariable("disciplineId") UUID disciplineId,
            @PathVariable("courseId") UUID courseId
    ) {
        ModelAndView modelAndView = new ModelAndView("/disciplines/view_discipline");
        Optional<DisciplineModel> disciplineModelOptional = disciplinesService.findById(disciplineId);
        Optional<CourseModel> courseModelOptional = coursesService.findById(courseId);

        if (!disciplineModelOptional.isPresent()) {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Disciplina não encontrada");
            return modelAndView;
        }

        if (!courseModelOptional.isPresent()) {
            modelAndView.setViewName("/error");
            modelAndView.addObject("errorMessage", "Curso não encontrado");
            return modelAndView;
        }

        var disciplineModel = new DisciplineModel();
        BeanUtils.copyProperties(disciplineModelOptional.get(), disciplineModel);
        disciplineModel.setCourse(courseModelOptional.get());

        disciplinesService.save(disciplineModel);

        modelAndView.addObject("discipline", disciplineModel);

        return modelAndView;
    }
}
