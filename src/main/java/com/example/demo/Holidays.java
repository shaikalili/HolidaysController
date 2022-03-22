package com.example.demo;

public class Holidays implements poco{
    int id;
    String name;
    int day;
    int month;
    int length;

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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Holidays(int id, String name, int day, int month, int length) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.length = length;
    }
    public Holidays(){}

    @Override
    public String toString() {
        return "Holidays{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", length=" + length +
                '}';
    }
}
