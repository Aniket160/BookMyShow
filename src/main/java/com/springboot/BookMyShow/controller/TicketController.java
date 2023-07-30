package com.springboot.BookMyShow.controller;

import com.springboot.BookMyShow.exceptions.ShowSeatNotAvailableException;
import com.springboot.BookMyShow.model.Ticket;
import com.springboot.BookMyShow.model.User;
import com.springboot.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public Ticket bookTicket(Long showId, List<Long> showSeatIds, Long userId) {
        try {
            return this.ticketService.bookTicket(showId, showSeatIds, userId);
        } catch (ShowSeatNotAvailableException e) {
            throw new RuntimeException(e);
        }
    }
}
