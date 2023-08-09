package com.example.hw14.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    @NotEmpty(message = "Should be not empty")
    @Size(min = 2, message = "Should be between 2 to 17")
    private String ID;

    @NotEmpty(message = "Should be not empty")
    @Size(min = 4  ,message = "Length more than 4")
    private String name;

    @NotNull(message = "Should be not empty")
   // @Pattern(regexp = "^(0|[1-9][0-9]*)$")
   // @Digits(integer = 5, fraction = 2)
    @Min(value = 25, message = "It must be more than 25")
    private int age;


    @NotNull(message = "Should be not empty")
    @Pattern(regexp = "(supervisor)|(Supervisor)|(coordinator)|(Coordinator)", message = "must be supervisor or coordinator only")
    private String  position;


    @NotNull(message ="Should be not empty" )
    @AssertFalse(message = "must be false")
    private Boolean onLeave;


    @Min(1997)
    @Max(2023)
   // @JsonFormat(pattern = "yyyy/mm/day")
   // @Pattern(regexp = "^^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$")
    @NotNull(message = "Should be not empty")
    private int employmentYear;

    @Digits(integer = 5, fraction = 2)
    @NotNull(message = "Should be not empty")
    private int annualLeave;
}
