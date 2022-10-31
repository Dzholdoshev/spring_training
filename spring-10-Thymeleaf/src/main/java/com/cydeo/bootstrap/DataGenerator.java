package com.cydeo.bootstrap;

import com.cydeo.model.Animal;
import com.cydeo.model.Student;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    public static List<Animal> createAnimals(){

        List<Animal> animals = Arrays.asList(
                new Animal(new Faker().ancient().hero(), new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000)),
                new Animal(new Faker().ancient().hero(),new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000)),
                new Animal(new Faker().ancient().hero(),new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000)),
                new Animal(new Faker().ancient().hero(), new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000)),
                new Animal(new Faker().ancient().hero(),new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000)),
                new Animal(new Faker().ancient().hero(),new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000)),
                new Animal(new Faker().ancient().hero(),new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000)),
                new Animal(new Faker().ancient().hero(),new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000)),
                new Animal(new Faker().ancient().hero(),new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000)),
                new Animal(new Faker().ancient().hero(),new Faker().animal().name(),new Faker().number().numberBetween(1,20), Arrays.stream(Animal.Gender.values()).skip(new Random().nextInt(Animal.Gender.values().length)).findAny().get(),new Faker().number().numberBetween(100,2000))
                );
        return animals;
    }


    public static List<Student> createStudent(){

        List<Student> students = Arrays.asList(
                new Student(new Faker().name().firstName(),new Faker().name().lastName(),new Faker().number().numberBetween(20,50),new Faker().address().state()),
                new Student(new Faker().name().firstName(),new Faker().name().lastName(),new Faker().number().numberBetween(20,50),new Faker().address().state()),
                new Student(new Faker().name().firstName(),new Faker().name().lastName(),new Faker().number().numberBetween(20,50),new Faker().address().state()),
                new Student(new Faker().name().firstName(),new Faker().name().lastName(),new Faker().number().numberBetween(20,50),new Faker().address().state())

        );
        return students;
    }

}
