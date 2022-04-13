package com.example.servletcrud.entity;

public class Teachers {
    private String name;
    private String contact;
    private int id;
    private Departments department;

    public Teachers(){

    }

    public Teachers(String name, String contact, int id, Departments  department){
        this.name = name;
        this.contact = contact;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
