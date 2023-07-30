package com.springboot.BookMyShow.controller;

import com.springboot.BookMyShow.exceptions.CityNotFoundException;
import com.springboot.BookMyShow.model.SeatType;
import com.springboot.BookMyShow.model.Theatre;
import com.springboot.BookMyShow.model.User;
import com.springboot.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TheatreController {
    private TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public Theatre createTheatre(String name, String address, Long cityId) {
        Theatre theatre = null;
        try {
            theatre = this.theatreService.createTheatre(name, address, cityId);
        } catch (CityNotFoundException e) {
            System.out.println("something wrong happened");
        }
        return theatre;
    }

    public Theatre addAuditorium(Long theatreId, String name, int capacity) {
        return theatreService.addAuditorium(theatreId, name, capacity);
    }

    public void addSeats(Long auditoriumId, Map<SeatType, Integer> seatCount) {
        theatreService.addSeats(auditoriumId, seatCount);
    }

}
