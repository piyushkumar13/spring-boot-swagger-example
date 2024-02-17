/*
 *  Copyright (c) 2023 DMG
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO DMG
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */

package com.example.swaggerapifirstexample.api;

import com.example.swaggerapifirstexample.api.model.Student;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Piyush Kumar.
 * @since 17/02/24.
 */

@Component
public class StudentsApiDelegateImpl implements StudentsApiDelegate {

    public ResponseEntity<List<Student>> getStudents(String pagesize, String xRequestId) {

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

    public ResponseEntity<Void> createStudent(String id, Student student) {

        System.out.println("The id is :::: " + id);

        System.out.println("The received student is ::: " + student);

        return ResponseEntity.noContent().build();
    }
}
