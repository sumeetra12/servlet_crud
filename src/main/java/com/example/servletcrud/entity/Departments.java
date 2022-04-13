package com.example.servletcrud.entity;

public class Departments {
    private int id;
    private String name;

    public Departments(){

    }
    public Departments(int id, String name){
        this.name= name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
