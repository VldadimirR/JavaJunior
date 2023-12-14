package ru.raisbex.lesson4.homework;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    void add(Course course);
    List<Course> getAll();
    void update(Course course);
    void delete(Course course);
    Optional<Course> getById(int id);

}
