package ru.raisbex.lesson4.homework;

import java.util.List;
import java.util.Optional;

public class CourseService {

    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void insertCourse(Course course){
        courseRepository.add(course);
    }

    public List<Course> gelAllCourse(){
        return courseRepository.getAll();
    }

    public void updateCourse(Course course){
        courseRepository.update(course);
    }

    public void deleteCourse(Course course){
        courseRepository.delete(course);
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.getById(id);
    }
}
