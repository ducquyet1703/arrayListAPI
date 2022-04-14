package com.example.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "array_sort1")
@Entity

public class ArraySort2Entity {
    @Id
    private int id;
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
