package com.example.demo;

import java.util.List;

public interface Dao {

    public <T> List<T> getAll();
    public <T> T getById(int id);
    public <T> boolean Add(T t);
    public <T> boolean Update(T t,int id);
    public boolean Delete(int id);
}
