package com.example.swaggerannotationconfigexample.controller;

import com.example.swaggerannotationconfigexample.model.Student;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * By default, access swagger ui at endpoint : http://localhost:8080/swagger-ui/index.html
 * By default, swagger ui json is available at endpoint : http://localhost:8080/v3/api-docs
 * To get swagger ui yaml, its available at endpoint : http://localhost:8080/v3/api-docs.yaml
 *
 * Link for spring-boot-starter-validation usage : https://reflectoring.io/bean-validation-with-spring-boot/
 * @author Piyush Kumar.
 * @since 17/02/24.
 */

@Validated
@RestController
@SecurityRequirement(name = "sampleappsecurity")
public class SampleController {


    @Operation(summary = "Get Students", description = "Returns list of students", tags = {"sample-controller","GET"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns successfully", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Student.class))} ),
        @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @Parameter(name = "X-request-id", in = ParameterIn.HEADER, description = "provide my custom header", required = true)
//    @Parameter(name = "pageSize", in = ParameterIn.QUERY, description = "pageSize") // we can use this for adding query param as well. But anyways method signature will have request param so swagger will can that.
    @GetMapping(path = "/students")
    ResponseEntity<List<Student>> getStudents(@RequestParam("pagesize") String pagesize){

        Student student1 = Student.builder()
            .registrationNo(1)
            .rollNo("IN-001")
            .name("Piyush")
            .college("DTU")
            .city("New Delhi")
            .state("Delhi")
            .course("M.Tech")
            .subjects(List.of("DS", "DBMS", "OS", "CA"))
            .build();

        Student student2 = Student.builder()
            .registrationNo(2)
            .rollNo("IN-002")
            .name("Amit")
            .college("DTU")
            .city("New Delhi")
            .state("Delhi")
            .course("M.Tech")
            .subjects(List.of("DS", "DBMS", "OS", "CA"))
            .build();


        return ResponseEntity.ok(Arrays.asList(student1, student2));
    }

    @Operation(summary = "Post Student", description = "Create student record", tags = {"sample-controller","POST"})
    @PostMapping(path = "/students/{id}")
    ResponseEntity<Void> createStudent(@PathVariable("id") @Size(min = 3, message = "id should be minimum of 3 chars") String id, @Valid @RequestBody Student student){

        System.out.println("The id is :::: "+ id);

        System.out.println("The received student is ::: " + student);

        return ResponseEntity.noContent().build();
    }
}
