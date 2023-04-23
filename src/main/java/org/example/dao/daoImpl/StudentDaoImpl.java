package org.example.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.config.Config;
import org.example.dao.StudentDao;
import org.example.entity.Course;
import org.example.entity.Student;
import org.example.enums.Gender;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    EntityManagerFactory entityManagerFactory = Config.getEntityManager();
    public String saveStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return student + "saved!!!";
    }

    public Student getStudentById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        with method
//        Student student = entityManager.find(Student.class,id);

//        with query
        Query query = entityManager.createQuery("select s from Student s where s.id = :id").setParameter("id",id);
        Student student = (Student) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return student;
    }

    public String updateStudentById(Long id, Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int updatee = entityManager.createQuery("update Student s set " +
                        "s.firstName = :firstName,s.lastName = :lastName,s.email = :email,s.age = :age,s.gender = :gender where s.id =:id")
                .setParameter("firstName",student.getFirstName())
                .setParameter("lastName",student.getLastName())
                .setParameter("age",student.getAge())
                .setParameter("email",student.getEmail())
                .setParameter("gender",student.getGender())
                .setParameter("id",id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Student with id: " + id + " updated!\n"+updatee;
    }

    @Override
    public List<Student> getAllSortedStudentsStudents() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select s from Student s order by s.age desc ");
        List<Student> students = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return students;
    }


    public String deleteStudentById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return student.getFirstName() + " is deleted!!!";
    }

    @Override
    public List<Student> groupByGender(Gender maleOrFemale) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select s from Student s where s.gender = :gender")
                .setParameter("gender", maleOrFemale);
        List<Student> students = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return students;
    }

    @Override
    public Student getOldOrYoungerStudent() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select s from Student s order by s.age asc");
        query.setMaxResults(1);
        Student youngestStudent = (Student) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return youngestStudent;
    }

    @Override
    public Student findStudentByFirstName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        with method
//        Student student = entityManager.find(Student.class,id);

//        with query
        Query query = entityManager.createQuery("select s from Student s where s.firstName = :firstName").setParameter("firstName",name);
        Student student = (Student) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return student;
    }
}
