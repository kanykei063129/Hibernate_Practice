package org.example;

import org.example.entity.Course;
import org.example.entity.Student;
import org.example.enums.Gender;
import org.example.service.CourseService;
import org.example.service.StudentService;
import org.example.service.serviceImpl.CourseServiceImpl;
import org.example.service.serviceImpl.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        CourseService courseService = new CourseServiceImpl();
//        System.out.println(courseService.saveCourse(new Course("JS", 12000)));
//        System.out.println(courseService.getCourseById(6L));
//        System.out.println(courseService.updateCourse(5L,new Course("PHP",15000)));
//        System.out.println(courseService.getAllCourse());
//        System.out.println(courseService.deleteCourseById(5L));

        StudentService studentService = new StudentServiceImpl();
//        System.out.println(studentService.saveStudent(new Student("Kanykei", "Akjoltoi kyzy", "akjoltoikyzykanykei@gmail.com", 17, Gender.FEMALE)));
//        System.out.println(studentService.saveStudent(new Student("Baytik", "Taalaibekov", "taalaibekovbaytik@gmail.com", 20, Gender.MALE)));
//        System.out.println(studentService.getStudentById(1L));
//        System.out.println(studentService.updateStudentById(1L, new Student("Madina", "Halikova", "halikovamadina@gmail.com", 16, Gender.FEMALE)));
//        System.out.println(studentService.getAllSortedStudentsStudents());
//        System.out.println(studentService.deleteStudentById(3L));
        System.out.println(studentService.groupByGender(Gender.MALE));
//        System.out.println(studentService.getOldOrYoungerStudent());
//        System.out.println(studentService.findStudentByFirstName("Madina"));
    }
}
