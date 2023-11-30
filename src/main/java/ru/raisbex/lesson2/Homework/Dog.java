package ru.raisbex.lesson2.Homework;

public class Dog extends Animal{

    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void makeSound(){
        System.out.println(
                "woof"
        );
    }


    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                '}';
    }
}
