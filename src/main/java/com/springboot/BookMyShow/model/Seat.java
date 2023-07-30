package com.springboot.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
}
