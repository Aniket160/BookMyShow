package com.springboot.BookMyShow.service;

import com.springboot.BookMyShow.model.*;
import com.springboot.BookMyShow.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShowService {
    private AuditoriumRepository auditoriumRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;



    public ShowInfo createShow(
            Long movieId,
            Date startTime,
            Date endTime,
            Long auditoriumId,
            Map<SeatType, Integer> seatPricing,
            Languge language
    ) {
        ShowInfo show = new ShowInfo();
        show.setStartTime(startTime);
        show.setEndTime(endTime);
        show.setLanguge(language);

        Auditorium auditorium = auditoriumRepository.findById(auditoriumId).get();
        show.setAuditorium(auditorium);
        ShowInfo savedShow = showRepository.save(show);
        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for (Seat seat : auditorium.getSeats()) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setShowInfo(savedShow);
            showSeat.setSeat(seat);
            showSeat.setState(ShowSeatState.AVAILABLE);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        savedShow.setShowSeats(savedShowSeats);

        return showRepository.save(savedShow);
    }
}
