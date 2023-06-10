package com.watson.project01.controller;

import com.watson.project01.service.StudentService;
import com.watson.project01.studentmodel.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentsService;

    @Autowired
    public StudentController(StudentService studentsService){
        this.studentsService = studentsService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentsService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
    studentsService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentsService.deleteStudent(studentId);
    }

    @PutMapping(path = {"studentId"})
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentsService.updateStudent(studentId, name, email);
    }
}
