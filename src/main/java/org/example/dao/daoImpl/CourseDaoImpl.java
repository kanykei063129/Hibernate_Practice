package org.example.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.config.Config;
import org.example.dao.CourseDao;
import org.example.entity.Course;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    EntityManagerFactory entityManagerFactory = Config.getEntityManager();
    public String saveCourse(Course newCourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newCourse);
        entityManager.getTransaction().commit();
        entityManager.close();
        return newCourse + "saved!!!";
    }

    public Course getCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        with method
//        Course course = entityManager.find(Course.class,id);
//        with query
        Query query = entityManager.createQuery("select c from Course c where c.id = :id").setParameter("id",id);
        Course course = (Course) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    public String updateCourse(Long oldId, Course newCourse) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    int update = entityManager.createQuery("update Course c set " +
            "c.courseName = :courseName,c.price = :price where c.id =:oldId")
            .setParameter("courseName",newCourse.getCourseName())
            .setParameter("price",newCourse.getPrice())
            .setParameter("oldId",oldId).executeUpdate();
    entityManager.getTransaction().commit();
    entityManager.close();
        return "Course with id: " + oldId + " updated!\n"+update;
    }

    public List<Course> getAllCourse() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        with method
//        List<Course>course = entityManager.createQuery("select c from Course c ",Course.class).getResultList();

//        with query
        Query query = entityManager.createQuery("select c from Course c");
        List<Course> course = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
   }

    public String deleteCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getCourseName() + " is deleted!!!";
    }
}
