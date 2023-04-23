package org.example.service;

import org.example.entity.Student;
import org.example.enums.Gender;

import java.util.List;

public interface StudentService {
    String saveStudent(Student student);

    Student getStudentById(Long id);

    String updateStudentById(Long id, Student student);

    List<Student> getAllSortedStudentsStudents();

    String deleteStudentById(Long id);

    List<Student> groupByGender(Gender maleOrFemale);

    Student getOldOrYoungerStudent();

    Student findStudentByFirstName(String name);
}
