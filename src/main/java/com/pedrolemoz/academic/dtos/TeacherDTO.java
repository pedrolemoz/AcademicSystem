package com.pedrolemoz.academic.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class TeacherDTO {
    @Null
    private String id;

    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    @CPF
    private String documentNumber;

    private LocalDateTime birthDate;

    public UUID getUUID() {
        return UUID.fromString(id);
    }
}