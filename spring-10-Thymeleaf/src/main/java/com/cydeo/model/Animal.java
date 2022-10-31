package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    private String name;
    private String type;
    private int age;
    private Gender gender;
    private int price;


public enum Gender{
    FEMALE, MALE;
}}