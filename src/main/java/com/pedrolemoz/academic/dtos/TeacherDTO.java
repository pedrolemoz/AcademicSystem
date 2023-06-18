package com.pedrolemoz.academic.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Getter
@Setter
public class TeacherDTO {
    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    @CPF
    private String documentNumber;

    private LocalDateTime birthDate;
}