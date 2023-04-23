package org.example.service.serviceImpl;

import org.example.dao.StudentDao;
import org.example.dao.daoImpl.StudentDaoImpl;
import org.example.entity.Student;
import org.example.enums.Gender;
import org.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    public String saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    public String updateStudentById(Long id, Student student) {
        return studentDao.updateStudentById(id,student);
    }

    @Override
    public List<Student> getAllSortedStudentsStudents() {
        return studentDao.getAllSortedStudentsStudents();
    }


    public String deleteStudentById(Long id) {
        return studentDao.deleteStudentById(id);
    }

    @Override
    public List<Student> groupByGender(Gender maleOrFemale) {
        return studentDao.groupByGender(maleOrFemale);
    }

    @Override
    public Student getOldOrYoungerStudent() {
        return studentDao.getOldOrYoungerStudent();
    }

    @Override
    public Student findStudentByFirstName(String name) {
        return studentDao.findStudentByFirstName(name);
    }
}
