package com.pedrolemoz.academic.controllers;

import com.pedrolemoz.academic.dtos.DisciplineDTO;
import com.pedrolemoz.academic.models.DisciplineModel;
import com.pedrolemoz.academic.services.DisciplinesService;
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

    public DisciplinesViewModel(DisciplinesService disciplinesService) {
        this.disciplinesService = disciplinesService;
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
}