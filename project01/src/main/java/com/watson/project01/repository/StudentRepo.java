package com.watson.project01.repository;

import com.watson.project01.studentmodel.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);
}
