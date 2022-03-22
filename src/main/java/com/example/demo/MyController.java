package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
HolidaysDao holidaysDao=new HolidaysDao();
    private Holidays holidays;

    @GetMapping("/GetAll")
    public List<String> sayHello()
    {
        List<Holidays> holidays= new ArrayList<Holidays>();
        List<String>HolidaysString=new ArrayList<>();
        holidays=holidaysDao.getAll();
        for (var holiday:holidays){
            HolidaysString.add(holiday.toString());
        }
        return HolidaysString;
    }

    @GetMapping("/GetById/{id}")
    public String getById(@PathVariable int id)
    {
       return holidaysDao.getById(id).toString();
    }

    @PostMapping("/Add")
    public void AddHoliday(@RequestBody Holidays holidays){
      holidaysDao.Add(holidays);
    }
    @PutMapping("/Update/{id}")
    public void updateHoliday(@RequestBody Holidays holidays,@PathVariable int id){
        holidaysDao.Update(holidays,id);
    }

    @DeleteMapping("/Delete/{id}")
    public void multiply(@PathVariable int id){
        holidaysDao.Delete(id);
    }
}
