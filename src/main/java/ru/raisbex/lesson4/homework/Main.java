package ru.raisbex.lesson4.homework;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CourseRepository repository = new CourseRepositoryImpl();
        CourseService service = new CourseService(repository);

        // Создание нового курса
        Course newCourse = new Course();
        newCourse.setTitle("New Course");
        newCourse.setDuration(782);

        Course newCourse2 = new Course();
        newCourse2.setTitle("New Course 2");
        newCourse2.setDuration(642);

        Course newCourse3 = new Course();
        newCourse3.setTitle("New Course 3");
        newCourse3.setDuration(992);

        service.insertCourse(newCourse);
        service.insertCourse(newCourse2);
        service.insertCourse(newCourse3);

        // Получение всех курсов
        List<Course> courses = service.gelAllCourse();
        System.out.println("All courses: " + courses);

        Optional<Course> course = service.getCourseById(newCourse3.getId());
        System.out.println("Course by Id: " + course);

        // Обновление курса
        Course courseToUpdate = courses.get(0);
        courseToUpdate.setTitle("Updated Course");
        service.updateCourse(courseToUpdate);

        // Получение всех курсов после обновления
        courses = service.gelAllCourse();
        System.out.println("All courses after update: " + courses);

        // Удаление курса
        Course courseToDelete = courses.get(0);
        service.deleteCourse(courseToDelete);

        // Получение всех курсов после удаления
        courses = service.gelAllCourse();
        System.out.println("All courses after delete: " + courses);
    }
}
