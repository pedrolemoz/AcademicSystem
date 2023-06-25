package com.pedrolemoz.academic.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DisciplineDTO {
    @Null
    private String id;

    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private Integer year;

    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Integer semester;

    public UUID getUUID() {
        return UUID.fromString(id);
    }
}
