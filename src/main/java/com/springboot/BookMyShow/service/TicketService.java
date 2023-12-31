package com.springboot.BookMyShow.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.BookMyShow.exceptions.ShowSeatNotAvailableException;
import com.springboot.BookMyShow.model.*;
import com.springboot.BookMyShow.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository, UserRepository userRepository, ShowRepository showRepository, TicketRepository ticketRepository) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.ticketRepository = ticketRepository;
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(
            Long showId,
            List<Long> showSeatIds,
            Long userId
    ) throws ShowSeatNotAvailableException {

        //Fetch the given showSeats
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        //check for availability
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("Show seat is not available : " + showSeat.getId());
            }
        }

        //update the status to lock
        for (ShowSeat showSeat : showSeats) {
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }

        //wait for payment confirmation
        //assuming payment confirmation done
        //return the ticket object
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.SUCCESS);
        ticket.setShowSeats(showSeats);
        ticket.setShowInfo(showRepository.findById(showId).get());
        ticket = ticketRepository.save(ticket);

        //update the status of showSeats to booked
        for (ShowSeat showSeat : showSeats) {
            showSeat.setState(ShowSeatState.BOOKED);
            showSeatRepository.save(showSeat);
        }

        return ticket;
    }


    private List<ShowSeat> checkAvailabilityAndLock(List<Long> showSeatIds) throws ShowSeatNotAvailableException {
        //Fetch the given showSeats
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        //check for availability
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("Show seat is not available : " + showSeat.getId());
            }
        }

        //update the status to lock
        for (ShowSeat showSeat : showSeats) {
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }

        return showSeats;
    }
}
