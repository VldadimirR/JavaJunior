package ru.raisbex.lesson2.Homework;

public class Cat extends Animal{

    private double weight;

    public Cat(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void makeSound(){
        System.out.println(
                "meow"
        );
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                '}';
    }
}
