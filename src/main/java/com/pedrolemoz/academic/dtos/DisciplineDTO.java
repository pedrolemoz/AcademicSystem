package com.pedrolemoz.academic.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineDTO {
    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private Integer year;

    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Integer semester;
}
