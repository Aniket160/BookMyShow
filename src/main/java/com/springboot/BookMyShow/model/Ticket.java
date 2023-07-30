package com.springboot.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User bookedby;
    @ManyToOne
    private ShowInfo showInfo;

    @ManyToMany
    private List<ShowSeat> showSeats;

    private int totalAmount;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    private DateFormat timeOfBooking;


}
