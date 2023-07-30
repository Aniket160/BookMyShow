package com.springboot.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "theatres", fetch = FetchType.EAGER)
    private List<Auditorium> auditoriums;

    @OneToMany
    private List<ShowInfo> upcomingshows;
}
