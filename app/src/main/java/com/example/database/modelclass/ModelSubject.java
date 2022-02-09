package com.example.database.modelclass;

public class ModelSubject {
    private int id;
    private String name;
    private String Pass_marks;
    private String full_marks;

    public ModelSubject(int id, String name, String pass_marks, String full_marks) {
        this.id = id;
        this.name = name;
        Pass_marks = pass_marks;
        this.full_marks = full_marks;
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

    public String getPass_marks() {
        return Pass_marks;
    }

    public void setPass_marks(String pass_marks) {
        Pass_marks = pass_marks;
    }

    public String getFull_marks() {
        return full_marks;
    }

    public void setFull_marks(String full_marks) {
        this.full_marks = full_marks;
    }
}
