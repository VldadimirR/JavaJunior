package ru.raisbex.lesson3.Homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentSerialiser {

    public static final String FILE_JSON = "student.json";

    public static final String FILE_XML = "student.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();


    public static void saveJSONFile(String fileName, List<Student> student) throws IOException {
        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(fileName), student);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void saveXMLFile(String fileName, List<Student> student) throws IOException {
        try {
            xmlMapper.writeValue(new File(fileName), student);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Student> loadJSONFromFile(String fileName) {
        List<Student> student = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                student = objectMapper
                        .readValue(file, objectMapper.getTypeFactory()
                        .constructCollectionType(List.class, Student.class));
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    public static List<Student> loadXMLFromFile(String fileName) {
        List<Student> student = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                student = xmlMapper
                        .readValue(file, xmlMapper.getTypeFactory()
                        .constructCollectionType(List.class, Student.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
