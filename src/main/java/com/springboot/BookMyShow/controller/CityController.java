package com.springboot.BookMyShow.controller;


import com.springboot.BookMyShow.model.City;
import com.springboot.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;


    @GetMapping()
    public String saveData(City city) {
        cityService.addCity(city.getName());
        return "City is Added";
    }

    public City addCity(String name) {
        return this.cityService.addCity(name);
    }
}
