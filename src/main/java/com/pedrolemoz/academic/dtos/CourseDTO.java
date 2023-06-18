package com.pedrolemoz.academic.dtos;

import com.pedrolemoz.academic.enumerators.Degree;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {
    @NotBlank
    @NotEmpty
    private String name;
    
    private Degree degree;
}
