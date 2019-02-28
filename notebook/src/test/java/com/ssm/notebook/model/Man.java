package com.ssm.notebook.model;

public class Man {

    private String name;
    private int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        System.out.println( "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}');
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}