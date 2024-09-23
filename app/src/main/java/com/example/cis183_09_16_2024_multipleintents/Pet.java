package com.example.cis183_09_16_2024_multipleintents;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//implements vs extends
public class Pet implements Serializable
{
    String name;
    int age;
    String type;

    public Pet()
    {

    }

    public Pet(String n, int a, String t)
    {
        name = n;
        age = a;
        type = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    static class PetType
    {
        static ArrayList<String> types = new ArrayList<>(Arrays.asList("Dog", "Cat", "Snake", "Chicken", "Hamster"));

        //3 functions to make this operate the way we want
        public static ArrayList<String> getAllPetTypes()
        {
            return types;
        }

        public static void addPetType(String t)
        {
            types.add(t);
        }

        public static String getPetAt(int i)
        {
            return types.get(i);
        }
    }
}
