package com.watson.project01.service;

import com.watson.project01.repository.StudentRepo;
import com.watson.project01.studentmodel.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void addNewStudent (Student student){

        Optional<Student> studentByEmail = studentRepo.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email Exist");
        }
        studentRepo.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepo.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(" student with id " + studentId + " does not exit ");
        }

        studentRepo.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new IllegalStateException(" student with id " + studentId + " does not exit"));
        if (name != null && name.length() > 0 &&
        !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email != null && email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepo.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email Exist");
            }
            student.setEmail(email);
        }


    }
}
