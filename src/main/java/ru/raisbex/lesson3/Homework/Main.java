package ru.raisbex.lesson3.Homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student user = new Student("Владимир", 23, 4.55);
        List<Student> students = new ArrayList<>();

        students.add(new Student("Алексей", 28, 4.98));
        students.add(new Student("Дмитрий", 52, 4.52));
        students.add(new Student("Вероника", 24, 4.28));

        // regular serialization

        try(FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(user);
            System.out.println("Объект Student сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("student.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            user = (Student) objectInputStream.readObject();
            System.out.println("Объект Student десериализован.");
        }

        System.out.println("Объект Student десериализован.");
        System.out.println("Имя: " + user.getName());
        System.out.println("Возраст: " + user.getAge());
        System.out.println("Средний балл (должен быть 0.0, так как transient): " + user.getGPA());

        // end regular serialization


        // serialization json
        System.out.println();
        System.out.println("Сериализация с JSON");
        List<Student> studentFromJSON;

        StudentSerialiser.saveJSONFile(StudentSerialiser.FILE_JSON, students);
        studentFromJSON = StudentSerialiser.loadJSONFromFile(StudentSerialiser.FILE_JSON);
        System.out.println(studentFromJSON);
        // end serialization json


        // serialization xml
        System.out.println();
        System.out.println("Сериализация с XML");
        List<Student> studentFromXML;

        StudentSerialiser.saveXMLFile(StudentSerialiser.FILE_XML, students);
        studentFromXML = StudentSerialiser.loadXMLFromFile(StudentSerialiser.FILE_XML);
        System.out.println(studentFromXML);
        //end serialization xml
    }

}
