package ru.raisbex.lesson4.homework;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryImpl implements CourseRepository{

    private final SessionFactory sessionFactory;

    public CourseRepositoryImpl() {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }


    @Override
    public void add(Course course) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (HibernateException s){
            s.printStackTrace();
        }

    }

    @Override
    public List<Course> getAll() {
        try(Session session = sessionFactory.openSession()){
            Query query = session.createQuery("from Course");
            List<Course> courses = query.getResultList();
            return courses;
        } catch (HibernateException s){
            s.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Course course) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (HibernateException s){
            s.printStackTrace();
        }
    }

    @Override
    public void delete(Course course) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(course);
            session.getTransaction().commit();
        } catch (HibernateException s){
            s.printStackTrace();
        }
    }

    @Override
    public Optional<Course> getById(int id) {
        try(Session session = sessionFactory.openSession()) {
            Course course = session.get(Course.class, id);
            return Optional.ofNullable(course);
        } catch (HibernateException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
