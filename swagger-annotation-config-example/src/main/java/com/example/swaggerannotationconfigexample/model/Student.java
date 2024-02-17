package com.example.swaggerannotationconfigexample.model;

import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Piyush Kumar.
 * @since 17/02/24.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Positive(message = "Value should be positive")
    private int registrationNo;

    @NotBlank(message = "rollNo cannot be empty or null")
    @Size(min= 3, message = "Rollno should have minimum 3 characters")
    private String rollNo;

    @NotBlank(message = "Name cannot be empty or null")
    @Size(min= 3, message = "Name should have minimum 3 characters")
    private String name;

    @NotBlank(message = "College cannot be empty or null")
    @Size(min= 3, message = "College should have minimum 3 characters")
    private String college;

    @Size(min= 3, message = "City should have minimum 3 characters")
    private String city;

    @Size(min= 3, message = "State should have minimum 3 characters")
    private String state;

    @NotBlank(message = "Course cannot be empty or null")
    @Size(min= 3, message = "Course should have minimum 3 characters")
    private String course;

    @NotNull(message = "Subjects cannot be null")
    private List<String> subjects;
}
