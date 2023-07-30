package com.springboot.BookMyShow.dao;

import com.springboot.BookMyShow.model.ShowInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowInfo,Long> {
}
