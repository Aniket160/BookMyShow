package com.springboot.BookMyShow.controller;


import com.springboot.BookMyShow.model.*;
import com.springboot.BookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Map;

@Controller
public class ShowController {
    @Autowired
    private ShowService showService;


    public ShowInfo createShow(Long movieId,
                           Date startTime,
                           Date endTime,
                           Long AuditoriumId,
                           Map<SeatType, Integer> seatPricing,
                           Languge language) {
        return showService.createShow(movieId, startTime, endTime, AuditoriumId, seatPricing, language);
    }
}
