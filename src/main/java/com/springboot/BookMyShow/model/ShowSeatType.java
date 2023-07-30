package com.springboot.BookMyShow.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "show_seattype_mapping")
public class ShowSeatType{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ShowInfo showInfo;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private double price;
}
