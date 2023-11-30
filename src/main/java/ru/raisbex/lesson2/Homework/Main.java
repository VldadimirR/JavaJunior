package ru.raisbex.lesson2.Homework;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Создаем объекты Cat и Dog
        Cat cat = new Cat(3.5);
        Dog dog = new Dog("Beagle");


// Создаем массив, содержащий объекты Cat и Dog
        Animal[] animals = new Animal[]{cat, dog};

// Для каждого объекта Animal в массиве animals выполняем следующие действия
        for (Animal animal : animals) {
            // Получаем класс объекта animal
            Class<?> animalClass = animal.getClass();

            // Получаем информацию о полях объекта
            Field[] fields = animalClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(
                        "Поле: " + field.getName() +
                        ", Тип: " + field.getType() +
                        ", Модификаторы: " + Modifier.toString(field.getModifiers()));
            }

            // Получаем информацию о конструкторах объекта
            Constructor<?>[] constructors = animalClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(
                        "Конструктор: " + constructor.getName() +
                        ", Количество параметров: " + constructor.getParameterCount());
            }

            // Получаем информацию о методах объекта
            Method[] methods = animalClass.getMethods();
            for (Method method : methods) {
                System.out.println("Метод: " + method.getName() +
                        ", Тип возвращаемого значения: " + method.getReturnType() +
                        ", Модификаторы: " + Modifier.toString(method.getModifiers()));
            }

            try {
                // Пытаемся вызвать метод makeSound для объекта animal
                Method makeSoundMethod = animalClass.getMethod("makeSound");
                makeSoundMethod.invoke(animal);
            } catch (NoSuchMethodException e) {
                // Если метод makeSound не найден, выводим сообщение об этом
                System.out.println("У этого животного нет метода makeSound");
            } catch (IllegalAccessException | InvocationTargetException e) {
                // Если возникают ошибки при вызове метода makeSound, выводим сообщение об ошибке
                System.out.println("Ошибка при вызове метода makeSound: " + e.getMessage());
            }
        }

    }
}

