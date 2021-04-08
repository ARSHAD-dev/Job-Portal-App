package com.example.jobportalarshad.Database;

public class data {
    String title;
    String description;
    String skill;
    String salary;
    String Data;
    String id;
    public  data(){

    }
    public data(String title, String description, String skill, String salary, String id, String Data) {
        this.title = title;
        this.description = description;
        this.skill = skill;
        this.salary = salary;
        this.Data = Data;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        this.Data = Data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
