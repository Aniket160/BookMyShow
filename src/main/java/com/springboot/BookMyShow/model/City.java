package com.springboot.BookMyShow.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

 @Entity
@Getter
@Setter
public class City{

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Theatre> theatres;
}
