package com.springboot.BookMyShow.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class ShowInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Auditorium auditorium;

    @OneToMany(mappedBy = "showInfo")
    private List<ShowSeat> showSeats;

    @OneToMany
    private List<ShowSeatType> showSeatTypes;

    @Enumerated(EnumType.STRING)
    private Languge languge;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ShowFeature> showFeatures;
}
