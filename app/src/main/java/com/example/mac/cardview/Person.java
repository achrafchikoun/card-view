package com.example.mac.cardview;

/**
 * Created by mac on 13/07/2016.
 */
public class Person {
    private String Name;
    private String Age;
    private String City;

    public Person(String name, String age, String city) {
        Name = name;
        Age = age;
        City = city;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
