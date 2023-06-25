package com.pedrolemoz.academic.dtos;

import com.pedrolemoz.academic.enumerators.Degree;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CourseDTO {
    @Null
    private String id;

    @NotBlank
    @NotEmpty
    private String name;

    private Degree degree;

    public UUID getUUID() {
        return UUID.fromString(id);
    }
}
