package com.springboot.BookMyShow.service;

import com.springboot.BookMyShow.model.City;
import com.springboot.BookMyShow.dao.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
	
    @Autowired
    private CityRepository cityRepository;
    public City addCity(String name) {
        City newCity = new City();
        newCity.setName(name);
        return this.cityRepository.save(newCity);

    }
}
